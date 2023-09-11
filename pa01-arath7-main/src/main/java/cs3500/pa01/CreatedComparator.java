package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * comparator that sorts by creation time
 */
public class CreatedComparator implements Comparator<Path> {
  BasicFileAttributes attr;

  /**
   * getter that gets attributes of a file
   *
   * @param p Path to get attributes from
   * @return BasicFileAttributes the attributes of a path
   */
  public BasicFileAttributes getAttr(Path p) {
    try {
      attr = Files.readAttributes(p, BasicFileAttributes.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return attr;
  }


  /**
   * @param o1 the first Path to be compared.
   * @param o2 the second Path to be compared.
   * @return int greater than, less than, or equal to 0
   */
  @Override
  public int compare(Path o1, Path o2) {
    FileTime fto1 = getAttr(o1).creationTime();
    o1.getFileName();
    FileTime fto2 = getAttr(o2).creationTime();
    return fto1.compareTo(fto2);
  }
}

