package cs3500.pa01;

/**
 * enumeration for options that are
 * shown to a user in the StudySessionController class
 */
public enum MenuOptions {
  EASY, HARD, ANSWER, NEXT, EXIT;

  /**
   * assigns an enum when given an int input
   * @param input int
   * @return MenuOptions enum
   * @throws IllegalArgumentException
   */
  public static MenuOptions assignEnum(int input) throws IllegalArgumentException {
    if (input == 1) { return EASY; }
    else if (input == 2) { return HARD; }
    else if (input == 3) { return ANSWER; }
    else if (input == 4) { return NEXT; }
    else if (input == 5) { return EXIT; }
    else { throw new IllegalArgumentException("Invalid input! Please input 1, 2, 3, 4, or 5"); }
  }
}
