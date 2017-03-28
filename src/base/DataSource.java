package base;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DataSource {

  public ListaPacjentow pacjenci;

  public DataSource () {
    try {
      final List<String> readAllLines = Files.readAllLines(Paths.get("database.txt"));
      final String json = readAllLines.stream().collect(Collectors.joining(""));
      pacjenci = new Gson().fromJson(json, ListaPacjentow.class);
    } catch (IOException ex) {
      pacjenci = new ListaPacjentow(new ArrayList<>());
      Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public List<Pacjent> dajPacjentow () {
    return pacjenci.pacjenci;
  }

  public Pacjent znajdz (String imie, String nazwisko) {
    if (imie == null || nazwisko == null) {
      return null;
    }
    final Pacjent orElse = pacjenci.pacjenci.stream()
      .filter(p -> imie.equals(p.imie) && nazwisko.equals(p.nazwisko))
      .findAny().orElse(null);
    if (orElse == null) {
      final Pacjent pacjent = new Pacjent(imie, nazwisko);
      pacjenci.add(pacjent);
      return pacjent;
    }
    return orElse;
  }

  public void save () {
    PrintWriter out = null;
    try {
      final Gson gson = new Gson();
      final String resultJson = gson.toJson(pacjenci);
      File yourFile = new File("database.txt");
      yourFile.createNewFile();
      out = new PrintWriter(yourFile);
      out.println(resultJson);
      out.close();
    } catch (IOException ex) {
      Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      out.close();
    }
  }
}
