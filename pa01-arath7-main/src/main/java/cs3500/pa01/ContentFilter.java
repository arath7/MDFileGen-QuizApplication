package cs3500.pa01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * class that filters out the content from
 * a single markdown file, it reads a file and
 * gets relevant information out
 */
public class ContentFilter {
  private File inputFile;
  private StringBuilder sb;
  boolean noClosedBrackets = false;

  /**
   * method that reads a file and filters out important information
   *
   * @param inputFile file that is being read from
   * @param sb StringBuilder object being used to store important information
   * @return String containing all important information
   */
  public String readFile(File inputFile, StringBuilder sb) throws FileNotFoundException {
    this.inputFile = inputFile;
    this.sb = sb;

    if (this.inputFile == null || this.sb == null) {
      throw new IllegalArgumentException("Content filter not properly instantiated.");
    }
    FileReader input;

    input = new FileReader(this.inputFile);

    Scanner scanner = new Scanner(input);

    String currLine = "";
    boolean extended = false;

    while (extended || scanner.hasNextLine()) {

      if (!extended) {
        currLine = scanner.nextLine();
      }

      if (!extended) {
        if ((currLine.startsWith("# "))
            || (currLine.startsWith("## "))
            || (currLine.startsWith("### "))
            || (currLine.startsWith("#### "))) {
          sb.append("\n").append(currLine).append("\n");
          continue;
        }
      }
      extended = false;

      if (currLine.contains("[[")) {
        int startIndex = currLine.indexOf("[[") + 2;

        if (currLine.substring(startIndex).contains("]]")) {
          int endIndex = currLine.substring(startIndex).indexOf("]]") + startIndex;
          sb.append("- " + currLine.substring(startIndex, endIndex)).append("\n");
          //check if there is another open bracket in the line

          if (!currLine.endsWith("]]")) {

            currLine = currLine.substring(currLine.indexOf("]]") + 2);
            extended = true;
          }
        } else {
          noClosedBrackets = true;
          sb.append("- " + currLine.substring(startIndex));

        }
      } else if (!currLine.contains("]]") && noClosedBrackets) {
        sb.append(currLine.substring(1));
      } else if (currLine.contains("]]") && noClosedBrackets) {
        int endOfPhrase = currLine.indexOf("]]");
        sb.append(currLine.substring(1, endOfPhrase)).append("\n");
        noClosedBrackets = false;
      }
    }

    String output = sb.toString();
    if (output.contains("\n") && output.indexOf("\n") == 0) {
      String editedOutput = output.substring(1);
      return editedOutput;
    } else {
      return output;
    }
  }
}
