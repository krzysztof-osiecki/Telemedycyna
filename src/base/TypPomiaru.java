package base;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kylo55
 */
public enum TypPomiaru {
  Wiek, Temperatura, Waga, Tetno;

  public static List<TypPomiaru> wartosci () {
    return Arrays.asList(TypPomiaru.values());
  }
}
