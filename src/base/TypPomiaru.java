package base;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kylo55
 */
public enum TypPomiaru {
  Wiek, Temperatura, Waga, Cisnienie;

  public static List<TypPomiaru> wartosci () {
    return Arrays.asList(TypPomiaru.values());
  }
}
