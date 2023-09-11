package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

/**
 * class to test the main class
 */
class MainTest {
  /**
   * method to test the filename sorting method used in the main method
   */
  @Test
  public void testMainSorter() {
    String[] args = new String[3];
    args[0] = "./src/test/resources";
    args[1] = "filename";
    args[2] = "src/test/StudyGuide";
    try {
      Main.main(args);
    } catch (FileNotFoundException e) {
      fail();
    }
    assertEquals(FileNameComparator.class, Main.sorter.getClass());
  }

  /**
   * method to test the created sorting method used in the main method
   */
  @Test
  public void testMainSorter2() {
    String[] args = new String[3];
    args[0] = "./src/test/resources";
    args[1] = "created";
    args[2] = "src/test/StudyGuide";
    try {
      Main.main(args);
    } catch (FileNotFoundException e) {
      fail();
    }
    assertEquals(CreatedComparator.class, Main.sorter.getClass());
  }

  /**
   * method to test the modified sorting method used in the main method
   */
  @Test
  public void testMainSorter3() {
    String[] args = new String[3];
    args[0] = "./src/test/resources created src/test/StudyGuide";
    args[1] = "modified";
    args[2] = "./src/test/resources created src/test/StudyGuide";
    try {
      Main.main(args);
    } catch (FileNotFoundException e) {
      fail();
    }
    assertEquals(ModifiedComparator.class, Main.sorter.getClass());
  }

  /**
   * method to test the exception that occurs when an invalid argument
   * is given to the main method
   */
  @Test
  public void testIoException() {
    String[] args = new String[2];
    args[0] = "./src/test/resources";
    args[1] = "modified";

    assertThrows(IllegalArgumentException.class, () -> Main.main(args));
  }
}