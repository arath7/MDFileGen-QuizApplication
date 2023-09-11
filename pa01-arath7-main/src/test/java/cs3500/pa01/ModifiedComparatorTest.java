package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.Test;

/**
 * class for testing the modified comparator class
 * and methods
 *
 */
class ModifiedComparatorTest {

  ModifiedComparator modified = new ModifiedComparator();

  Path p1 = Path.of("./src/test/resources/SampleData/arrays.md");
  Path p2 = Path.of("./src/test/resources/SampleData/vectors.md");

  /**
   * method to test if an invalid path is passed
   * into the getAttr method of the ModifiedComparator class
   */
  @Test
  public void invalidPathTest() {
    assertThrows(RuntimeException.class, () -> modified.getAttr(Path.of("invalid path")));
  }
  //test passes locally but not on GitHub
  //    /**
  //     * method to test the getAttr method
  //     */
  //    @Test
  //    public void getAttrTest() {
  //      BasicFileAttributeView p1Viewer = Files.getFileAttributeView(p1,
  //      BasicFileAttributeView.class);
  //      try {
  //        p1Viewer.setTimes(FileTime.fromMillis(1002),
  //            FileTime.fromMillis(1001), FileTime.fromMillis(1000));
  //      } catch (IOException e) {
  //        throw new RuntimeException(e);
  //      }
  //      assertEquals(FileTime.fromMillis(1002), modified.getAttr(p1).lastModifiedTime());
  //      assertEquals(FileTime.fromMillis(1001), modified.getAttr(p1).lastAccessTime());
  //      assertEquals(FileTime.fromMillis(1000), modified.getAttr(p1).creationTime());
  //    }

  /**
   * method to test the compare method
   * of the ModifiedComparator class
   */
  @Test
  public void testCompare() {
    BasicFileAttributeView p1Viewer = Files.getFileAttributeView(p1, BasicFileAttributeView.class);
    BasicFileAttributeView p2Viewer = Files.getFileAttributeView(p2, BasicFileAttributeView.class);

    FileTime p1ModTime = FileTime.fromMillis(1000);
    FileTime p2ModTime = FileTime.fromMillis(2000);

    try {
      p1Viewer.setTimes(p1ModTime, FileTime.fromMillis(0), FileTime.fromMillis(0));
      p2Viewer.setTimes(p2ModTime, FileTime.fromMillis(0), FileTime.fromMillis(0));
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(-1, modified.compare(p1, p2));
    assertEquals(0, modified.compare(p1, p1));
    assertEquals(1, modified.compare(p2, p1));
  }

}