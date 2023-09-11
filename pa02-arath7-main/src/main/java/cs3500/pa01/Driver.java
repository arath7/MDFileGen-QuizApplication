package cs3500.pa01;

import java.io.InputStreamReader;
import java.nio.file.Path;

/**
 * This is the main driver of the program
 */
public class Driver {
  static Path startPath;
  static Path endPath;
  static String flag;

  /**
   * main method that instantiates a Controller object and takes in command line arguments
   *
   * @param args the arguments that a user inputs within the command line
   *             arguments should be a starting file path, a sorting method,
   *             and an ending file path
   */
  public static void main(String[] args) {
    if (args.length == 3) { //if 3 arguments are given
      startPath = Path.of(args[0]);
      endPath = Path.of(args[2]);
      flag = args[1];

      IController sgController = new StudyGuideController(startPath, flag, endPath);
      sgController.run();
    } else if (args.length == 0) { //if no arguments are given
      IModel model = new StudySessionModel();
      IView view = new StudySessionView();
      IController ssController =
          new StudySessionController(new InputStreamReader(System.in),
              System.out, model, view);
      ssController.run();
    } else {
      throw new IllegalArgumentException(
          "Must pass in 3 arguments: a starting path, sorting flag, " +
              "and output path or 0 arguments");
    }
  }
}
