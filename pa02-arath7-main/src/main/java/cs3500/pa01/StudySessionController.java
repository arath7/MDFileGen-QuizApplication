package cs3500.pa01;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Controller for the Study
 */
public class StudySessionController implements IController {
  private Appendable output;
  private Readable input;
  IView viewer;
  IModel model;
  Scanner inputScanner;
  Path srFilePath;
  Random rand;
  boolean exitSession;
  int totalAnswered;
  int toHard;
  int toEasy;

  //constructor
  public StudySessionController(Readable input, Appendable output, IModel model, IView view) {
    this.viewer = view;
    this.model = model;
    this.inputScanner = new Scanner(input);
    this.rand = new Random();
    this.exitSession = false;
    this.totalAnswered = 0;
    this.toHard = 0;
    this.toEasy = 0;
    this.output = Objects.requireNonNull(output);
    this.input = Objects.requireNonNull(input);
  }

  /**
   * uses the model and the view to give output to user
   * and take in information to create a study session
   */
  public void run() {
    viewer.welcomeUser(); //runs the welcomeUser method and welcomes user to study session
    viewer.promptSrPath(); //prints out a message asking for an .sr path to create a study session with
    String srPathInput = getUserInput(); //also writing out to this file
    getSrPath(srPathInput);

    try {
      model.makeQuestionBank(srFilePath); //generates a total bank of questions
    } catch (FileNotFoundException e) {
      System.out.println("Invalid file path\n");
    }

    viewer.generateQuestionSetPrompt(); //asks user how many questions in the study session
    int questionNumberInput = Integer.parseInt(getUserInput());
    model.makeSessionList(questionNumberInput, rand); //creates the session list
    for (Question q : model.getSessionList()) {
      viewer.studySessionOptions();
      studyOneQuestion(q);
      if (exitSession) {
        break;
      }
    }
    System.out.println(totalAnswered + " questions answered");
    viewer.sessionEndAndStats();
    viewer.view(model.sessionStats(totalAnswered, toHard, toEasy));
    ContentWriter.writeToFile(srFilePath, model.allContent());
    viewer.farewell();
  }

  /**
   * creates .sr path from String
   *
   * @param srPathInput String
   * @return Path srPathInput now a Path
   */
  private Path getSrPath(String srPathInput) {
    srFilePath = Path.of(srPathInput);
    return srFilePath;
  }


  /**
   * gets the user input from the console
   *
   * @return String from scanner
   */
  private String getUserInput() {
    String scanned = inputScanner.nextLine();
    return scanned;
  }

  /**
   * translates an input number into a MenuOptions enum
   *
   * @return MenuOptions
   */
  private MenuOptions integerToMenuEnum() {
    return MenuOptions.assignEnum(Integer.parseInt(getUserInput()));
  }

  /**
   * passes in a single question for user to decide how to
   * perform study session on
   *
   * @param question to be presented to user along with menu options
   */
  private void studyOneQuestion(Question question) {
    String currQuestion = question.getQuestion();
    String currAnswer = question.getAnswer();
    viewer.view(currQuestion);
    MenuOptions userChoiceEnum;
    boolean inCurrentQuestion = true;

    while (inCurrentQuestion) {
      try {
        userChoiceEnum = integerToMenuEnum();
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid Menu Input: Choose 1, 2, 3, 4, or 5");
        continue;
      }
      if (userChoiceEnum == MenuOptions.ANSWER) {
        viewer.view(currAnswer);
        totalAnswered++;
      } //if user presses 3, show answer and wait for input

      if (userChoiceEnum == MenuOptions.EASY) {
        question.setDifficultyLevel(DifficultyLevel.EASY);
        toEasy++;
      }  //if user presses 1, mark as easy and wait for input

      if (userChoiceEnum == MenuOptions.HARD) {
        question.setDifficultyLevel(DifficultyLevel.HARD);
        toHard++;
      } //if user presses 2, mark as hard and wait for input

      if (userChoiceEnum == MenuOptions.NEXT) {
        inCurrentQuestion = false;
      }//if user presses 4, move to next question in loop

      if (userChoiceEnum == MenuOptions.EXIT) {
        exitSession = true;
        break;
      } //if user presses 5, end study session and show stats
    }
  }
}
