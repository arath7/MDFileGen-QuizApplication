package cs3500.pa01;

/**
 * enum class for difficulty levels
 * can be either easy or hard
 */
public enum DifficultyLevel {
  HARD("{{hard}}"), EASY("{{easy}}");
  private final String difficultyLevel;

  DifficultyLevel(String level) {
    this.difficultyLevel = level;
  }

  /**
   * gets the String value of a DifficultyLevel enum
   *
   * @return String value of the enum
   */
  public String getStringVal() {
    return difficultyLevel;
  }
}
