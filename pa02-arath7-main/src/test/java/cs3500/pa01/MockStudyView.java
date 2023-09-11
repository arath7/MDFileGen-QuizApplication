package cs3500.pa01;

import java.io.IOException;

/**
 * mock class to test StudyView and StudySessionController
 */
public class MockStudyView implements IView {
  private final Appendable log;

  public MockStudyView(Appendable log) {
    this.log = log;
  }

  /**
   * mock method for view
   *
   * @param inputFromController String input to be passed to console
   */
  @Override
  public void view(String inputFromController) {
    try {
      this.log.append("Printed input: " + inputFromController);
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for welcomeUser
   */
  @Override
  public void welcomeUser() {
    try {
      this.log.append("Printed welcome message");
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for promptSrPath
   */
  @Override
  public void promptSrPath() {
    try {
      this.log.append("Asks for .sr path");
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for generateQuestionSetPrompt
   */
  @Override
  public void generateQuestionSetPrompt() {
    try {
      this.log.append("Generated question set and prompts for number of questions");
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for studySessionOptions
   */
  @Override
  public void studySessionOptions() {
    try {
      this.log.append("Shows study session options");
    } catch (IOException e) {
      //Do nothing
    }
  }

  /**
   * mock method for sessionEndAndStats
   */
  @Override
  public void sessionEndAndStats() {
    try {
      this.log.append("Shows the user the session stats");
    } catch (IOException e) {
      //Do nothing
    }
  }

  /**
   * mock method for farewell
   */
  @Override
  public void farewell() {
    try {
      this.log.append("Shows the user the farewell message");
    } catch (IOException e) {
      //Do nothing
    }
  }
}
