package cs3500.pa01;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This is the main driver of this project.
 */
public class Driver {

  private Path startPath;
  private Path endPath;
  public ArrayList<Path> mdList;
  private ContentFilter oneFileContent;
  private FileWriter writer;
  private Comparator<Path> sorter;
  private String content;

  /**
   * instantiates the Driver with a startPath, endPath,
   * list of markdown files, and a sorting comparator
   *
   * @param startPath path to search for markdown files from
   * @param endPath path to write final output file to
   * @param mdList list of markdown files to read and write
   * @param sorter sorting comparator to sort markdown file list by
   */
  public Driver(Path startPath, Path endPath, ArrayList<Path> mdList,
         Comparator<Path> sorter) {
    if (startPath == null || endPath == null || mdList == null || sorter == null) {
      throw new IllegalArgumentException("Null argument(s)");
    }
    this.startPath = startPath;
    this.endPath = endPath;
    this.mdList = mdList;
    this.sorter = sorter;
  }

  /**
   * updates the sorting method used to sort the
   * mdList
   *
   * @param newSorter comparator to sort by
   */
  public void updateSorter(Comparator<Path> newSorter) {
    mdList.sort(newSorter);
  }

  /**
   * generates the important information from every Path in the MarkDown file list
   */
  private void generateContent() throws FileNotFoundException {
    StringBuilder sb = new StringBuilder();

    for (Path p : this.mdList) {
      this.oneFileContent = new ContentFilter();
      this.content = oneFileContent.readFile(p.toFile(), sb);
    }
  }

  /**
   * creates the content to output to a file at the output path
   */
  public void writeContent() throws FileNotFoundException {
    this.generateContent();
    try {
      writer = new FileWriter(this.endPath.toFile().getName());
      writer.append(this.content);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
