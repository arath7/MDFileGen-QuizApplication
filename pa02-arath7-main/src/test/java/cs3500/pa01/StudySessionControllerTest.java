package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class to test StudySessionController
 */
class StudySessionControllerTest {
  Readable in;
  Appendable out;
  String userInput;
  StudySessionController ssController;

  @BeforeEach
  void setup() {
    userInput = "testQandA.sr\n"
        + "5\n" //number of q to answer
        + "1\n" + "4\n"  //mark as easy and show next question
        + "2\n" + "3\n" + "4\n" //mark as hard, show answer, and move to next question
        + "4\n" //move to next question
        + "2\n" + "4\n" //mark as hard and move to next question
        + "4\n"; //move to next question

    in = new StringReader(userInput);
    out = new StringBuilder();
    IModel mockModel = new MockStudySessionModel(out);
    IView mockView = new MockStudyView(out);

    ssController = new StudySessionController(in, out, mockModel, mockView);
  }

  /**
   * tests the run method using a mocks class
   */
  @Test
  public void testController() {
    String line = "Printed welcome messageAsks for .sr path"
        + "Made Question Bank test"
        + "QandA.srGenerated question set and prompts for number of questions"
        + "Made Session List Number of Questions: 5 and a random input"
        + "Shows the user the session stats"
        + "Printed input: Session stats were found"
        + "Shows the user the farewell message";
    ssController.run();
    assertEquals(line, out.toString());
    assertEquals(0, ssController.totalAnswered);
    assertEquals(0, ssController.toEasy);
    assertEquals(0, ssController.toHard);
  }
}