package cs3500.pa01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * main class for the program
 */
public class Main {

  public static ArrayList<Path> mdFileList;
  static Path startPath;
  static Path endPath;
  static Comparator<Path> sorter;
  public static Driver d;

  /**
   * main method that instantiates a Driver object and takes in command line arguments
   *
   * @param args the arguments that a user inputs within the command line
   *             arguments should be a starting file path, a sorting method,
   *             and an ending file path
   */
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length == 3) {
      startPath = Path.of(args[0]);

      switch (args[1]) {
        case "filename" -> sorter = new FileNameComparator();
        case "created" -> sorter = new CreatedComparator();
        default -> sorter = new ModifiedComparator();
      }

      endPath = Path.of(args[2]);
      MdFileVisitor mdVisitor = new MdFileVisitor();
      try {
        Files.walkFileTree(startPath, mdVisitor);
      } catch (IOException e) {
        throw new IllegalArgumentException("Invalid input path");
      }
      mdFileList = mdVisitor.getList();
      d = new Driver(startPath, endPath, mdFileList, sorter);
      d.writeContent();
    } else {
      throw new IllegalArgumentException(
          "Must pass in 3 arguments: a starting path, sorting flag, and output path");
    }
  }
}
