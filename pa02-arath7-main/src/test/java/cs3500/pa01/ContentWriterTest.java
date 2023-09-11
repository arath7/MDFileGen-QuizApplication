package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * test for the ContentWriter class
 */
class ContentWriterTest {
  Path fileWriterTest = Path.of("src/test/resources/SampleData/FileWriterTest.md");
  String expectedContent = "Testing the file writer. If you can see this, it worked!";


  /**
   * test to see if content is being written to file path
   */
  @Test
  public void testFileWriter() {
    ContentWriter.writeToFile(fileWriterTest, expectedContent);

    String testContent = "";
    try {
      testContent = new String(Files.readAllBytes(fileWriterTest));
    } catch (IOException e) {
      fail();
    }
    assertEquals(expectedContent, testContent);
  }
}