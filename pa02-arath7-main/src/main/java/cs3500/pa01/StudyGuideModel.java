package cs3500.pa01;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * class that creates a study guide
 */
public class StudyGuideModel {

  private Path startPath;
  private Path endPath;
  private Path srPath;
  public ArrayList<Path> mdList;
  private ContentFilter oneFileContent;
  private Comparator<Path> sorter;
  private String contentMd;
  private String contentSr;

  /**
   * instantiates the StudyGuideModel with a startPath, endPath,
   * list of markdown files, and a sorting comparator
   *
   * @param startPath path to search for markdown files from
   * @param endPath path to write final output file to
   * @param mdList list of markdown files to read and write
   * @param sorter sorting comparator to sort markdown file list by
   */
  public StudyGuideModel(Path startPath, Path endPath, ArrayList<Path> mdList,
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
    StringBuilder sbMd = new StringBuilder();
    StringBuilder sbSr = new StringBuilder();

    getSrPath(endPath);


    for (Path p : this.mdList) {
      this.oneFileContent = new ContentFilter();
      oneFileContent.readFile(p.toFile(), sbMd, sbSr);
      this.contentMd = oneFileContent.getMarkdownString();
      this.contentSr = oneFileContent.getSrString();
    }
  }

  /**
   * creates the content to output to a file at the output path
   */
  public void writeContent() {
    try {
      this.generateContent();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    ContentWriter.writeToFile(this.endPath, contentMd);
    ContentWriter.writeToFile(this.srPath, contentSr);
  }

  /**
   * getter to get .sr file path to write to
   * @param endPath Path to use to find .sr file path
   */
  private void getSrPath(Path endPath) {
    String mdPathString = endPath.toString();
    String srPathString = mdPathString.substring(0, mdPathString.indexOf(".md")) + ".sr";
    srPath = Path.of(srPathString);
  }
}
