package cs3500.pa01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * StudySessionModel to take inputs and create StudySession bank
 * of Questions from and perform all related tasks
 */
public class StudySessionModel implements IModel {
  private ArrayList<Question> initialQuestionList;
  private ArrayList<Question> randomTotalList; //initial list randomized and hard questions at the beginning
  private ArrayList<Question> sessionList; //only questions used in study session
  private ArrayList<Question> hardQList; //randomized list of all the hard questions
  private ArrayList<Question> easyQList; //randomized list of all the easy questions
  private ArrayList<Question> finalOutputList; //list that will be written back to .sr file

  //constructor
  StudySessionModel() {
    initialQuestionList = new ArrayList<>();
    randomTotalList = new ArrayList<>();
    sessionList = new ArrayList<>();
    hardQList = new ArrayList<>();
    easyQList = new ArrayList<>();
    finalOutputList = new ArrayList<>();
  }

  /**
   * makes initial ArrayList bank of question
   * @param inputPath Path to create List of Questions from
   * @throws FileNotFoundException
   */
  public void makeQuestionBank(Path inputPath) throws FileNotFoundException {
    FileReader input;
    input = new FileReader(inputPath.toFile());
    Scanner scanner = new Scanner(input);
    String currLine = "";
    while(scanner.hasNextLine()) {
      currLine = scanner.nextLine();
      initialQuestionList.add(new Question(currLine));
    }
  }

  /**
   * splits list of questions into a list of hard
   * and a list of easy questions
   */
  private void splitQuestionList(){ //splits question list into hard and easy
    for(Question q: initialQuestionList) {
      if (q.getDifficultyLevel() == DifficultyLevel.HARD) {
        hardQList.add(q);
      }
      else {
        easyQList.add(q);
      }
    }
  }

  /**
   * method that creates list of questions for a session
   * @param numOfQuestions number of questions to be asked in a session
   * @param rand Random object to randomize the list of questions
   */
  public void makeSessionList(int numOfQuestions, Random rand) {
    splitQuestionList();
    Collections.shuffle(hardQList, rand);
    Collections.shuffle(easyQList, rand);
    randomTotalList.addAll(hardQList);
    randomTotalList.addAll(easyQList);

    if(numOfQuestions >= initialQuestionList.size()) {
      sessionList = randomTotalList;
    }
    else { //if it is less
      for(int i = 0; i < numOfQuestions; i++) {
        sessionList.add(randomTotalList.get(i));
      }
    }
  }

  /**
   * getter for session list of questions
   * @return ArrayList of type Question
   */
  public ArrayList<Question> getSessionList() {
    return sessionList;
  }

  /**
   * creates the final list of questions to
   * be rewritten back to the .sr file
   */
  private void makeFinalOutputList() {
    finalOutputList.addAll(sessionList);
    if (sessionList.size() < randomTotalList.size()) {
      for (int i = sessionList.size(); i < randomTotalList.size(); i++) {
        finalOutputList.add(randomTotalList.get(i));
      }
    }
  }

  /**
   * getter for the number of easy questions in a list of questions
   * @param questionList
   * @return int number of questions
   */
  private int getNumEasyQuestions(ArrayList<Question> questionList) {
    int numEasy = 0;
    for(Question q: questionList) {
      if(q.getDifficultyLevel().equals(DifficultyLevel.EASY)) {
        numEasy++;
      }
    }
    return numEasy;
  }

  /**
   * getter for the number of hard questions in a list of questions
   * @param questionList
   * @return int number of questions
   */
  private int getNumHardQuestions(ArrayList<Question> questionList) {
    int numHard = 0;
    for(Question q: questionList) {
      if(q.getDifficultyLevel().equals(DifficultyLevel.HARD)) {
        numHard++;
      }
    }
    return numHard;
  }

  /**
   * creates the session statistics of a study session
   * @param totalAnswered int number of questions answered in session
   * @param toHard int number of questions changed to hard
   * @param toEasy int number of questions changed to easy
   * @return String of statistics to be given to the user
   */
  public String sessionStats(int totalAnswered, int toHard, int toEasy) {
    makeFinalOutputList();
    StringBuilder stats = new StringBuilder();

    String totalSessionAnswered = "the total number of questions answered was " + totalAnswered + " questions";

    String totalEasyToHard = "the total number of questions that changed from easy to hard were " + toEasy + " questions";

    String totalHardToEasy = "the total number of questions that changed from easy to hard were " + toHard + " questions";

    String updatedHardQ = "The updated total number of hard questions is: " + getNumHardQuestions(finalOutputList) + " questions";

    String updatedEasyQ = "The updated total number of easy questions is: " + getNumEasyQuestions(finalOutputList) + " questions";

    stats.append(totalSessionAnswered + "\n").
        append(totalEasyToHard + "\n").
        append(totalHardToEasy + "\n").
        append(updatedHardQ + "\n").
        append(updatedEasyQ);
    return stats.toString();
  }

  /**
   * returns all content to be written to the .sr file
   * @return String content to be written
   */
  public String allContent() {
    StringBuilder allContent = new StringBuilder();
    for(Question q: finalOutputList) {
      allContent.append(q.getSrString() + "\n");
    }
    return allContent.toString();
  }
}
