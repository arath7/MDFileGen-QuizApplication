package cs3500.pa01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

/**
 * mocks class for testing StudySessionModel and StudySessionController
 */
public class MockStudySessionModel implements IModel {
  private final Appendable log;

  public MockStudySessionModel(Appendable log) {
    this.log = log;
  }

  /**
   * Mock method for makeQuestionBank
   *
   * @param inputPath Path to create List of Questions from
   * @throws FileNotFoundException Exception
   */
  @Override
  public void makeQuestionBank(Path inputPath) throws FileNotFoundException {
    try {
      this.log.append("Made Question Bank " + inputPath.toString());
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for makeSessionList
   *
   * @param numOfQuestions number of questions to be asked in a session
   * @param rand           Random object to randomize the list of questions
   */
  @Override
  public void makeSessionList(int numOfQuestions, Random rand) {
    try {
      this.log.append("Made Session List " + "Number of Questions: "
          + numOfQuestions + " and a random input");
    } catch (IOException e) {
      //do nothing
    }
  }

  /**
   * mock method for getSessionList
   *
   * @return Arraylist of type Question
   */
  @Override
  public ArrayList<Question> getSessionList() {
    return new ArrayList<Question>();
  }

  /**
   * mock method for sessionStats
   *
   * @param totalAnswered int number of questions answered in session
   * @param toHard        int number of questions changed to hard
   * @param toEasy        int number of questions changed to easy
   * @return String
   */
  @Override
  public String sessionStats(int totalAnswered, int toHard, int toEasy) {
    return "Session stats were found";
  }

  /**
   * mock method for allContent
   *
   * @return String
   */
  @Override
  public String allContent() {
    return "allContent was created";
  }
}
