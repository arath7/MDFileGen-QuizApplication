package cs3500.pa01;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

/**
 * IModel interface for a model
 */
public interface IModel {
  /**
   * method that makes a QuestionBank ArrayList
   * @param inputPath Path to create List of Questions from
   * @throws FileNotFoundException
   */
  void makeQuestionBank(Path inputPath) throws FileNotFoundException;

  /**
   * method that creates list of questions for a session
   * @param numOfQuestions number of questions to be asked in a session
   * @param rand Random object to randomize the list of questions
   */
  void makeSessionList(int numOfQuestions, Random rand);

  /**
   * getter to get the ArrayList of session questions
   * @return ArrayList of Question type
   */
  ArrayList<Question> getSessionList();

  /**
   * shows the session statistics after a study session is complete
   * @param totalAnswered int number of questions answered in session
   * @param toHard int number of questions changed to hard
   * @param toEasy int number of questions changed to easy
   * @return String to be printed to user in the console
   */
  String sessionStats(int totalAnswered, int toHard, int toEasy);

  /**
   * all content to be written back to the .sr file
   * with updated metadata
   * @return String
   */
  String allContent();
}
