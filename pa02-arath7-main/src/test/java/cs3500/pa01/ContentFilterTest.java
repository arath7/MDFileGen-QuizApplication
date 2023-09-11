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
  Path qAndAnsTest = Path.of("src/test/resources/SampleData/QandATest.md");
  Path multilineQandA = Path.of("src/test/resources/SampleData/MultilineQandA.md");
  Path multipleHeaders = Path.of("src/test/resources/SampleData/multipleHeaders.md");
  Path manyLinesBracket = Path.of("src/test/resources/SampleData/manyLinesBracket.md");
  Path manyBrackets = Path.of("src/test/resources/SampleData/manyBrackets.md");

  /**
   * test method to see if an Illegal Argument Exception
   * is thrown when inputting an invalid file into the readFile
   * method of the ContentFilter class
   */
  @Test
  public void invalidTestContentFilter() {
    File inputFile = null;
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    assertThrows(IllegalArgumentException.class, () ->
        filter.readFile(inputFile, resultMd, resultSr));
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a double header
   */
  @Test
  public void testHeader() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("## double header\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = pathHeader.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());

  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a triple header
   */
  @Test
  public void testHeader2() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("### triple header\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = pathHeader2.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a triple header
   */
  @Test
  public void testHeader3() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("#### quadruple header\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = pathHeader3.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }


  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a double bracket in a line
   */
  @Test
  public void bracketTest() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("-  hello my name is bob \n\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = pathBracketTest.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  /**
   * test method to see the output of a file that has been read
   * in the readFile method of the ContentFilter class
   * test for when a file contains a bracket that extends into
   * another line
   */
  @Test
  public void bracketTest2() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("- this is  testing the bracket\n\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = pathBracketTest2.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  @Test
  public void testQandA() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder();
    StringBuilder expectedSr = new StringBuilder("- "
        + "Who is the president of the USA? ::: Joe Biden {{hard}}\n");
    File f = qAndAnsTest.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  @Test
  public void testMultilineQandA() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder();
    StringBuilder expectedSr = new StringBuilder("- How many co-ops do Northeastern students "
        + "usually do? ::: 2 co-ops {{hard}}\n"
        + "- What is the best Pink Floyd album?::: The Dark Side of the Moon {{hard}}\n");
    File f = multilineQandA.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  @Test
  public void testMultipleHeaders() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedMd = new StringBuilder("# My favorite songs from Pink Floyd's "
        + "\"the Dark Side of the Moon\"\n"
        + "\n## Breathe (in the Air)\n" + "\n#### Brain Damage\n");
    StringBuilder expectedSr = new StringBuilder();
    File f = multipleHeaders.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }

  @Test
  public void testManyLineBracket() {
    StringBuilder resultMd = new StringBuilder();
    StringBuilder resultSr = new StringBuilder();
    StringBuilder expectedSr = new StringBuilder("- What is the best Pink Floyd album?:::  "
        + "The Dark Side of the Moon {{hard}}\n");
    StringBuilder expectedMd = new StringBuilder();
    File f = manyLinesBracket.toFile();

    try {
      filter.readFile(f, resultMd, resultSr);
    } catch (FileNotFoundException e) {
      fail();
    }

    assertEquals(expectedMd.toString(), filter.getMarkdownString());
    assertEquals(expectedSr.toString(), filter.getSrString());
  }
}