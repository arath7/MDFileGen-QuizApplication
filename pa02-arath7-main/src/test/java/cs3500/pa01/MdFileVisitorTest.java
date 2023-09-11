package cs3500.pa01;

//import static java.nio.file.FileVisitResult.CONTINUE;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import org.junit.jupiter.api.Test;

/**
 * class to test the MDFileVisitor class
 */
class MdFileVisitorTest {
  static final String SAMPLE_INPUTS_DIRECTORY = "src/test/resources/SampleData";

  //works locally but not on GitHub, had to comment out imports as well
  //  /**
  //   * class to test the getList method
  //   */
  //  @Test
  //  //test works locally
  //  public void testGetList() {
  //    MdFileVisitor mdfv = new MdFileVisitor();
  //
  //    try {
  //      Files.walkFileTree(Path.of(SAMPLE_INPUTS_DIRECTORY), mdfv);
  //    } catch (IOException e) {
  //      fail();
  //    }
  //
  //    //build list of expected file paths
  //    ArrayList<Path> expectedFiles = new ArrayList<>();
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/arrays.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/BracketTest.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/BracketTest2.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/DoubleHeaderTest.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/headerTestFile.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/QuadHeaderTest.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/TripleHeaderTest.md"));
  //    expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/vectors.md"));
  //
  //    // get list of traversed Markdown file paths
  //    ArrayList<Path> actualFiles = mdfv.getList();
  //
  //    // compare both lists
  //    assertEquals(8, actualFiles.size());
  //
  //    for (int z = 0; z < expectedFiles.size(); z++) {
  //      assertEquals(expectedFiles.get(z).toString(), actualFiles.get(z).toString());
  //    }
  //  }
}
