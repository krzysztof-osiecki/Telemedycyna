package base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pacjent {

  String imie;
  String nazwisko;
  Map<TypPomiaru, List<Pomiar>> pomiary = new HashMap<>();

  public Pacjent () {
  }

  public Pacjent (String imie, String nazwisko) {
    this.imie = imie;
    this.nazwisko = nazwisko;
  }

  @Override
  public String toString () {

    return imie == null ? "" : imie + " " + nazwisko == null ? "" : nazwisko;
  }

}
