package cs3500.pa01;

/**
 * class that represents a Question object
 */
public class Question {
  private String question;
  private String answer;
  private DifficultyLevel level;
  private String srString;

  //constructor
  Question(String question, String answer, DifficultyLevel level) {
    this.question = question;
    this.answer = answer;
    this.level = level;
  }

  /**
   * constructor that takes in a String line and creates a Question object
   * @param line String to create Question object from
   */
  Question(String line) {
    this.question = line.substring(2, line.indexOf(":::"));
    this.answer = line.substring(line.indexOf(":::") + 3, line.indexOf("{"));
    if(line.endsWith(DifficultyLevel.HARD.getStringVal())) {
      this.level = DifficultyLevel.HARD;
    }
    else { //will either be hard or easy
      this.level = DifficultyLevel.EASY;
    }
  }

  /**
   * getter to get a question field of a Question
   * @return String question
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * getter to get an answer field of a Question
   * @return String answer
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * getter to get a level field of a Question
   * @return DifficultyLevel level
   */
  public DifficultyLevel getDifficultyLevel() {
    return this.level;
  }

  /**
   * setter to set the level field of a Question
   */
  public void setDifficultyLevel(DifficultyLevel level) {
    this.level = level;
  }

  /**
   * creates a String from a Question object
   * used to write back to .sr file
   */
  private void srFileString() {
    StringBuilder srStringBuilder = new StringBuilder();
    String colons = ":::";
    String bullet = "- ";
    srStringBuilder.append(bullet).
        append(question).
        append(colons).
        append(answer).
        append(level.getStringVal());
    srString = srStringBuilder.toString();
  }

  /**
   * getter to get srString
   * @return String
   */
  public String getSrString() {
    srFileString();
    return srString;
  }
}
