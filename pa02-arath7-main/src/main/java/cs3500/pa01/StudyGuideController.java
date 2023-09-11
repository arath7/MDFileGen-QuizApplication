package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * class that uses a Path to create a .md file and a .sr file
 */
public class StudyGuideController implements IController {
  private Path startPath;
  private Path endPath;
  private String flag;
  private Comparator<Path> sorter;
  private StudyGuideModel model;
  private ArrayList<Path> mdFileList;


  //constructor
  StudyGuideController(Path startPath, String flag, Path endPath) {
    this.startPath = startPath;
    this.flag = flag;
    this.endPath = endPath;
    this.sorter = new ModifiedComparator();

  }

  /**
   * run method that sorts list of paths, walks file tree and writes to a path
   */
  public void run() {

    switch (flag) {
      case "filename" -> sorter = new FileNameComparator();
      case "created" -> sorter = new CreatedComparator();
      default -> sorter = new ModifiedComparator();
    }

    MdFileVisitor mdVisitor = new MdFileVisitor();
    try {
      Files.walkFileTree(startPath, mdVisitor);
    } catch (IOException e) {
      throw new IllegalArgumentException("Invalid input path");
    }
    mdFileList = mdVisitor.getList();
    model = new StudyGuideModel(startPath, endPath, mdFileList, sorter);
    model.writeContent();
  }

  /**
   * getter to get a Sorter
   * @return Comparator of type Path
   */
  public Comparator<Path> getSorter() {
    return sorter;
  }
}
