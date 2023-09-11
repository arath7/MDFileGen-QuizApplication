package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * class for testing Question class
 */
class QuestionTest {
  Question question1 = new Question("Where is Canada?",
      "Canada is north of the United States", DifficultyLevel.HARD);
  String line1 = "- Where is Canada?:::Canada is north of the United States{{hard}}";

  Question question2 = new Question("Where is Mexico?",
      "Mexico is south of the United States", DifficultyLevel.EASY);
  String line2 = "- Where is Mexico?:::Mexico is south of the United States{{easy}}";

  /**
   * test for getQuestion method
   */
  @Test
  public void testGetQuestion() {
    assertEquals("Where is Canada?", question1.getQuestion());
    assertEquals("Where is Mexico?", question2.getQuestion());

  }

  /**
   * test for getAnswer method
   */
  @Test
  public void testGetAnswer() {
    assertEquals("Canada is north of the United States", question1.getAnswer());
    assertEquals("Mexico is south of the United States", question2.getAnswer());

  }

  /**
   * test for getDifficultyLevel method
   */
  @Test
  public void testGetDifficultyLevel() {
    assertEquals(DifficultyLevel.HARD, question1.getDifficultyLevel());
    assertEquals(DifficultyLevel.EASY, question2.getDifficultyLevel());

  }

  /**
   * test for setDifficultyLevel method
   */
  @Test
  public void testSetDifficultyLevel() {
    assertEquals(DifficultyLevel.HARD, question1.getDifficultyLevel());
    question1.setDifficultyLevel(DifficultyLevel.EASY);
    assertEquals(DifficultyLevel.EASY, question1.getDifficultyLevel());

    assertEquals(DifficultyLevel.EASY, question2.getDifficultyLevel());
    question2.setDifficultyLevel(DifficultyLevel.HARD);
    assertEquals(DifficultyLevel.HARD, question2.getDifficultyLevel());
  }

  /**
   * test for getSrString method
   */
  @Test
  public void getSrString() {
    assertEquals(line1, question1.getSrString());
    assertEquals(line2, question2.getSrString());
  }
}