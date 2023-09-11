package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * tests for the main driver class
 */
class DriverTest {

  /**
   * method to test the exception that occurs when an invalid argument
   * is given to the main method
   */
  @Test
  public void testException() {
    String[] args = new String[2];
    args[0] = "./src/test/resources";
    args[1] = "modified";

    assertThrows(IllegalArgumentException.class, () -> Driver.main(args));
  }

  /**
   * test for 3 arguments
   */
  @Test
  public void test3Args() {
    String[] args = new String[3];
    args[0] = "./src/test/resources";
    args[1] = "modified";
    args[2] = "studyGuideFile.md";

    Driver.main(args);

    assertEquals("modified", Driver.flag);
  }
}