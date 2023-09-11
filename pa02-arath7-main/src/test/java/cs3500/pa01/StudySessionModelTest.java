package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for testing StudySessionModel
 */
class StudySessionModelTest {

  Path sampleBank;
  StudySessionModel model;
  Random rand;
  int numQuestions;
  int totalAnswered;
  int toHard;
  int toEasy;
  ArrayList<Question> sessionList;
  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Question q5;

  @BeforeEach
  public void initData() {
    sampleBank = Path.of("src/test/resources/SampleData/sampleQuestionBank.sr");
    model = new StudySessionModel();
    rand = new Random(5);
    numQuestions = 3;
    totalAnswered = 3;
    toHard = 1;
    toEasy = 1;
    sessionList = new ArrayList<>();

    q1 = new Question("What is the capital of India", "New Delhi ", DifficultyLevel.HARD);
    q2 = new Question("What is the current year? ", " 2026 ", DifficultyLevel.HARD);
    q3 = new Question("When was the Declaration of Independence signed? ",
        " August 2, 1776 ", DifficultyLevel.HARD);
    q4 = new Question("Who is Abraham Lincoln? ",
        "  He was the 16th president of the United States ", DifficultyLevel.HARD);
    q5 = new Question("Who is Luke Skywalker's father?", "Darth Vader ", DifficultyLevel.HARD);

  }

  /**
   * test for makeQuestionBank method
   */
  @Test
  public void testMakeQuestionBank() {
    assertEquals(0, model.getSessionList().size());
    try {
      model.makeQuestionBank(sampleBank);
    } catch (FileNotFoundException e) {
      fail();
    }
    model.makeSessionList(3, rand);
    assertEquals(3, model.getSessionList().size());

  }

  /**
   * test for generateSessionList method
   */
  @Test
  public void generateSessionList() {
    try {
      model.makeQuestionBank(sampleBank);
    } catch (FileNotFoundException e) {
      fail();
    }
    model.makeSessionList(numQuestions, rand);
    sessionList.add(q4);
    sessionList.add(q2);
    sessionList.add(q5);

    for (int i = 0; i < numQuestions; i++) {
      assertEquals(sessionList.get(i).getQuestion(), model.getSessionList().get(i).getQuestion());
      assertEquals(sessionList.get(i).getAnswer(), model.getSessionList().get(i).getAnswer());
      assertEquals(sessionList.get(i).getDifficultyLevel(),
          model.getSessionList().get(i).getDifficultyLevel());
    }
  }

  /**
   * test for sessionStats method
   */
  @Test
  public void testSessionStats() {
    try {
      model.makeQuestionBank(sampleBank);
    } catch (FileNotFoundException e) {
      fail();
    }


    String stats = "the total number of questions answered was 3 questions"
        + "\nthe total number of questions that changed from easy to hard were 1 questions"
        + "\nthe total number of questions that changed from easy to hard were 1 questions"
        + "\nThe updated total number of hard questions is: 0 questions"
        + "\nThe updated total number of easy questions is: 0 questions";
    assertEquals(stats, model.sessionStats(totalAnswered, toHard, toEasy));
  }

  /**
   * test for allContent method
   */
  @Test
  public void testAllContent() {
    sessionList.add(q4);
    sessionList.add(q2);
    sessionList.add(q5);
    sessionList.add(q1);
    sessionList.add(q3);
    StringBuilder allContent = new StringBuilder();
    for (Question q : sessionList) {
      allContent.append(q.getSrString() + "\n");
    }
    String allContentString = allContent.toString(); 


    try {
      model.makeQuestionBank(sampleBank);
    } catch (FileNotFoundException e) {
      fail();
    }
    model.makeSessionList(numQuestions, rand); //make the session list here
    model.sessionStats(totalAnswered, toHard, toEasy);
    String modelAllContentString = model.allContent();
    assertEquals(allContentString, modelAllContentString);
  }
}