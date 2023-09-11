package cs3500.pa01;

/**
 * implements the IView interface
 */
public class StudySessionView implements IView {
  /**
   * method to view a message passed to the console
   * @param inputFromController String input to be passed to console
   */
  public void view(String inputFromController) {
    System.out.println(inputFromController);
  }

  /**
   * method to welcome the user to Study Session
   */
  public void welcomeUser() {
    System.out.println("\nWelcome to your study session! Let's get started!\n");
  }

  /**
   * prompts the user for the .sr file path to study from
   */
  public void promptSrPath() {
    System.out.println("Please input an .sr file to generate a study session from.\n");
  }

  /**
   * generates the list of questions and prompts
   * user for how many questions they want to answer
   */
  public void generateQuestionSetPrompt() {
    System.out.println("Please input the number of questions (ex: 5) you would like to practice today.\n" +
        "If the number of questions is more than what exists in your .sr file, " +
        "your session will include all questions");
  }

  /**
   * options that a user can choose from in a study session
   */
  public void studySessionOptions() {
    System.out.println("\nYour options: \n" +
        "1. Mark as easy \t2. Mark as hard \t3. See answer " +
        "\t4. Go to next question \t5. Exit session and view statistics\n");
  }

  /**
   * message that indicates the session is over and stats will be shown
   */
  public void sessionEndAndStats() {
    System.out.println("Your session is over. Thanks for studying! Here are your stats: ");
  }

  /**
   * farewell message that also indicates .sr file was rewritten with updated metadata
   */
  public void farewell() {
    System.out.println("Thanks for studying today. Your .sr file has been updated accordingly. See you soon!");

  }
}
