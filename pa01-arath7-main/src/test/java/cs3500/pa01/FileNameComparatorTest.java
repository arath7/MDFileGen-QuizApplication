package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Test for the FileName Comparator class and methods
 */
class FileNameComparatorTest {

  FileNameComparator compareByFileName = new FileNameComparator();

  Path p1 = Path.of("./src/test/resources/SampleData/arrays.md");
  Path p2 = Path.of("./src/test/resources/SampleData/vectors.md");

  /**
   * test for the compare method in the File Comparator class
   * that compares two paths by their file names
   */
  @Test
  public void testCompare() {
    assertEquals(-21, compareByFileName.compare(p1, p2));
    assertEquals(0, compareByFileName.compare(p1, p1));
    assertEquals(21, compareByFileName.compare(p2, p1));
  }
}