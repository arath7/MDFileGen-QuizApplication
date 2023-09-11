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
  private StringBuilder sbMd;
  private String markdownString;
  private String srString;
  private StringBuilder sbSr;
  boolean noClosedBrackets = false;
  boolean colonFlag = false;

  /**
   * method that reads a file and filters out important information
   *
   * @param inputFile file that is being read from
   * @param sb        StringBuilder object used to store important information for markdown file
   * @param sb2       StringBuilder object being used to store important information for sr file
   * @throws FileNotFoundException Exception to throw
   */
  public void readFile(File inputFile, StringBuilder sb, StringBuilder sb2)
      throws FileNotFoundException {
    this.inputFile = inputFile;
    this.sbMd = sb;
    this.sbSr = sb2;

    if (this.inputFile == null || this.sbMd == null || this.sbSr == null) {
      throw new IllegalArgumentException("Content filter not properly instantiated.");
    }
    FileReader input;
    input = new FileReader(this.inputFile);
    Scanner scanner = new Scanner(input);
    String currLine = "";
    boolean extended = false;
    StringBuilder passInto = new StringBuilder();

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
        extended = false;
      }
      //extended = false;


      bracketFilter(currLine, passInto, extended);
      if (colonFlag == false) {
        String currString = passInto.toString();
        if (currString.contains(":::")) {
          sb2.append(currString.substring(0, currString.length() - 1)).append(" {{hard}}")
              .append("\n");
        } else {
          sb.append(currString).append("\n");
        }
        passInto = new StringBuilder();

      }
    }
    markdownString = sb.toString();
    if (markdownString.contains("\n") && markdownString.indexOf("\n") == 0) {
      markdownString = markdownString.substring(1);
    }

    srString = sb2.toString();
  }

  /**
   * helper method that filters through a line and looks for a bracket
   *
   * @param currLine String current line you are on
   * @param sbBr     StringBuilder to send important information to
   * @param extended boolean for whether a line is extended or not
   * @return String to be added to a StringBuilder
   */
  private String bracketFilter(String currLine, StringBuilder sbBr, boolean extended) {
    if (currLine.contains("[[")) {
      colonFlag = true;
      int startIndex = currLine.indexOf("[[") + 2;

      if (currLine.substring(startIndex).contains("]]")) {
        colonFlag = false;
        int endIndex = currLine.substring(startIndex).indexOf("]]") + startIndex;
        sbBr.append("- " + currLine.substring(startIndex, endIndex)).append("\n");
        //check if there is another open bracket in the line
        if (!currLine.endsWith("]]")) {
          currLine = currLine.substring(currLine.indexOf("]]") + 2);
          extended = true;
        }
      } else {
        noClosedBrackets = true;
        sbBr.append("- " + currLine.substring(startIndex));
      }
    } else if (!currLine.contains("]]") && noClosedBrackets) {
      sbBr.append(currLine.substring(1));

    } else if (currLine.contains("]]") && noClosedBrackets) {
      colonFlag = false;
      int endOfPhrase = currLine.indexOf("]]");
      sbBr.append(currLine.substring(1, endOfPhrase)).append("\n");
      noClosedBrackets = false;
    }
    return sbBr.toString();
  }

  /**
   * getter for .sr file's string
   *
   * @return String to be written to .sr file
   */
  public String getSrString() {
    return srString;
  }

  /**
   * getter for .md file's string
   *
   * @return String to be written to .md file
   */
  public String getMarkdownString() {
    return markdownString;
  }
}

