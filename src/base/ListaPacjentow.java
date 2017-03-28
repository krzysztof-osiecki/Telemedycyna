package base;

import java.util.ArrayList;
import java.util.List;

public class ListaPacjentow {

  List<Pacjent> pacjenci = new ArrayList<>();

  public ListaPacjentow (List<Pacjent> pacjenci) {
    this.pacjenci = pacjenci;
  }

  public boolean add (Pacjent e) {
    return pacjenci.add(e);
  }

  public Pacjent get (int index) {
    return pacjenci.get(index);
  }

  public void add (int index, Pacjent element) {
    pacjenci.add(index, element);
  }

}
