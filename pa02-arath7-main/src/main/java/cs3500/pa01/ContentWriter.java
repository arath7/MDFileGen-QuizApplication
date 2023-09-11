package cs3500.pa01;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * writes the final study guide
 */
public class ContentWriter {

  /**
   * Writes the given String to the given filepath.
   *
   * @param path     where to write the contents
   * @param contents contents to write to the file
   */
  public static void writeToFile(Path path, String contents) {
    try {
      FileWriter writer;
      writer = new FileWriter(path.toFile());
      writer.append(contents);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
