package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * class that looks for Markdown files and
 * stores them within an ArrayList
 * implements the FileVisitor interface
 */
public class MdFileVisitor implements FileVisitor<Path> {
  public ArrayList<Path> mdList = new ArrayList<>();

  /**
   * getter method that returns the list
   * of markdown files in a path
   *
   * @return ArrayList of Paths to markdown files in a directory
   */
  public ArrayList<Path> getList() {
    return mdList;
  }

  /**
   * Invoked for a directory before entries in the directory are visited.
   *
   * <p>If this method returns {@link FileVisitResult#CONTINUE CONTINUE},
   * then entries in the directory are visited. If this method returns {@link
   * FileVisitResult#SKIP_SUBTREE SKIP_SUBTREE} or {@link
   * FileVisitResult#SKIP_SIBLINGS SKIP_SIBLINGS} then entries in the
   * directory (and any descendants) will not be visited.
   *
   * @param dir   a reference to the directory
   * @param attrs the directory's basic attributes
   * @return the visit result
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    System.out.format("Finishing Directory: %s%n", dir);
    return CONTINUE;
  }

  /**
   * Invoked for a file in a directory.
   * stores markdown files found in a directory
   * in the mdList ArrayList
   *
   * @param file  a reference to the file
   * @param attrs the file's basic attributes
   * @return the visit result
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    String fileName = file.getFileName().toString();
    if (fileName.endsWith(".md")) {
      mdList.add(file);
    }

    return CONTINUE;
  }

  /**
   * Invoked for a file that could not be visited. This method is invoked
   * if the file's attributes could not be read, the file is a directory
   * that could not be opened, and other reasons.
   *
   * @param file a reference to the file
   * @param exc  the I/O exception that prevented the file from being visited
   * @return the visit result
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    System.err.println(exc);
    return CONTINUE;
  }

  /**
   * Invoked for a directory after entries in the directory, and all of their
   * descendants, have been visited. This method is also invoked when iteration
   * of the directory completes prematurely (by a {@link #visitFile visitFile}
   * method returning {@link FileVisitResult#SKIP_SIBLINGS SKIP_SIBLINGS},
   * or an I/O error when iterating over the directory).
   *
   * @param dir a reference to the directory
   * @param exc {@code null} if the iteration of the directory completes without
   *            an error; otherwise the I/O exception that caused the iteration
   *            of the directory to complete prematurely
   * @return the visit result
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
    return CONTINUE;
  }
}
