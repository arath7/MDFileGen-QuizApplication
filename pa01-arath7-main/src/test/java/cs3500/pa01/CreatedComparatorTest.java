package cs3500.pa01;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import java.io.IOException;
//import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.attribute.BasicFileAttributeView;
//import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.Test;

/**
 * tests for the CreatedComparator class and methods
 */
class CreatedComparatorTest {
  CreatedComparator created = new CreatedComparator();

  Path p1 = Path.of("./src/test/resources/SampleData/arrays.md");
  Path p2 = Path.of("./src/test/resources/SampleData/vectors.md");

  /**
   * test for when trying to compare by created time
   * and a path is invalid in the getAttr method of
   * the CreatedComparator class
   */
  @Test
  public void invalidPathTest() {
    assertThrows(RuntimeException.class, () -> created.getAttr(Path.of("invalid path")));
  }

  //works locally but not on GitHub
  //    /**
  //     * tests for getting the getAttr method which gets a file's attributes
  //     */
  //    @Test
  //    public void getAttrTest() {
  //      BasicFileAttributeView p1Viewer =
  //      Files.getFileAttributeView(p1, BasicFileAttributeView.class);
  //      try {
  //        p1Viewer.setTimes(FileTime.fromMillis(1002),
  //            FileTime.fromMillis(1001), FileTime.fromMillis(1000));
  //      } catch (IOException e) {
  //        throw new RuntimeException(e);
  //      }
  //      assertEquals(FileTime.fromMillis(1002), created.getAttr(p1).lastModifiedTime());
  //      assertEquals(FileTime.fromMillis(1001), created.getAttr(p1).lastAccessTime());
  //      assertEquals(FileTime.fromMillis(1000), created.getAttr(p1).creationTime());
  //    }
  //    /**
  //     * tests for comparing two files
  //     */
  //    @Test
  //    public void testCompare() {
  //      BasicFileAttributeView p1Viewer = Files.getFileAttributeView(p1,
  //      BasicFileAttributeView.class);
  //      BasicFileAttributeView p2Viewer = Files.getFileAttributeView(p2,
  //      BasicFileAttributeView.class);
  //
  //      FileTime p1CreatedTime = FileTime.fromMillis(1000);
  //      FileTime p2CreatedTime = FileTime.fromMillis(2000);
  //
  //      try {
  //        p1Viewer.setTimes(FileTime.fromMillis(0),
  //        FileTime.fromMillis(0), p1CreatedTime);
  //        p2Viewer.setTimes(FileTime.fromMillis(0),
  //        FileTime.fromMillis(0), p2CreatedTime);
  //
  //        System.out.println(p2Viewer.readAttributes().creationTime());
  //        System.out.println(p1Viewer.readAttributes().creationTime());
  //
  //      }
  //      catch (IOException e) {
  //        e.printStackTrace();
  //      }
  //      assertEquals(-1, created.compare(p1, p2));
  //     // assertEquals(0, created.compare(p1, p1));
  //      assertEquals(1, created.compare(p2, p1));
  //    }
}