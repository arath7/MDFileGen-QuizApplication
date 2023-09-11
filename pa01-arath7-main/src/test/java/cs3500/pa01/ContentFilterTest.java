package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * class to test ContentFilter class and methods
 */
class ContentFilterTest {

  ContentFilter filter = new ContentFilter();

  Path pathHeader = Path.of("src/test/resources/SampleData/DoubleHeaderTest.md");
  Path pathHeader2 = Path.of("src/test/resources/SampleData/TripleHeaderTest.md");
  Path pathHeader3 = Path.of("src/test/resources/SampleData/QuadHeaderTest.md");

  Path pathBracketTest = Path.of("src/test/resources/SampleData/BracketTest.md");
  Path pathBracketTest2 = Path.of("src/test/resources/SampleData/BracketTest2.md");

  /**
   * test method to see if an Illegal Argument Exception
   * is thrown when inputting an invalid file into the readFile
   * method of the ContentFilter class
   */
  @Test
  public void invalidTestContentFilter() {
    File inputFile = null;
    StringBuilder result = new StringBuilder();
    assertThrows(IllegalArgumentException.class, () -> filter.readFile(inputFile, result));
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a double header
   */
  @Test
  public void testHeader() {
    StringBuilder result = new StringBuilder();
    StringBuilder expected = new StringBuilder("## double header\n");
    File f = pathHeader.toFile();

    try {
      assertEquals(expected.toString(), filter.readFile(f, result));
    } catch (FileNotFoundException e) {
      fail();
    }
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a triple header
   */
  @Test
  public void testHeader2() {
    StringBuilder result = new StringBuilder();
    StringBuilder expected = new StringBuilder("### triple header\n");
    File f = pathHeader2.toFile();

    try {
      assertEquals(expected.toString(), filter.readFile(f, result));
    } catch (FileNotFoundException e) {
      fail();
    }
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a triple header
   */
  @Test
  public void testHeader3() {
    StringBuilder result = new StringBuilder();
    StringBuilder expected = new StringBuilder("#### quadruple header\n");
    File f = pathHeader3.toFile();

    try {
      assertEquals(expected.toString(), filter.readFile(f, result));
    } catch (FileNotFoundException e) {
      fail();
    }
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a double bracket in a line
   */
  @Test
  public void bracketTest() {
    StringBuilder result = new StringBuilder();
    StringBuilder expected = new StringBuilder("-  hello my name is bob \n");
    File f = pathBracketTest.toFile();

    try {
      assertEquals(expected.toString(), filter.readFile(f, result));
    } catch (FileNotFoundException e) {
      fail();
    }
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a bracket that extends into
   * another line
   */
  @Test
  public void bracketTest2() {
    StringBuilder result = new StringBuilder();
    StringBuilder expected = new StringBuilder("- this is  testing the bracket\n");
    File f = pathBracketTest2.toFile();

    try {
      assertEquals(expected.toString(), filter.readFile(f, result));
    } catch (FileNotFoundException e) {
      fail();
    }
  }
}