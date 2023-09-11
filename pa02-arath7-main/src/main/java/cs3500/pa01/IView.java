package cs3500.pa01;

/**
 * interface for View
 */
public interface IView {
  /**
   * method to view a message passed to the console
   * @param inputFromController String input to be passed to console
   */
  void view(String inputFromController);

  /**
   * method to welcome the user to Study Session
   */
  public void welcomeUser();

  /**
   * prompts the user for the .sr file path to study from
   */
  public void promptSrPath();

  /**
   * generates the list of questions and prompts
   * user for how many questions they want to answer
   */
  public void generateQuestionSetPrompt();

  /**
   * options that a user can choose from in a study session
   */
  public void studySessionOptions();

  /**
   * message that indicates the session is over and stats will be shown
   */
  public void sessionEndAndStats();

  /**
   * farewell message that also indicates .sr file was rewritten with updated metadata
   */
  public void farewell();
}
