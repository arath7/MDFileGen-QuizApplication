package cs3500.pa01;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * comparator that sorts by the names of the files
 */
public class FileNameComparator implements Comparator<Path> {

  /**
   * @param o1 the first Path to be compared.
   * @param o2 the second Path to be compared.
   * @return int greater than, less than, or equal to 0
   */
  @Override
  public int compare(Path o1, Path o2) {
    return o1.getFileName().compareTo(o2.getFileName());
  }
}
