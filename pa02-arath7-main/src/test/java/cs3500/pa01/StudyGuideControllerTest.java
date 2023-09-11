package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class StudyGuideControllerTest {

  @Test
  public void testSorterCreated() {
    Path startPath = Path.of("./src/test/resources");
    String flag = "created";
    Path endPath = Path.of("src/test/StudyGuide.md");
    StudyGuideController testStudyGuideController = new
        StudyGuideController(startPath, flag, endPath);

    assertEquals(ModifiedComparator.class,
        testStudyGuideController.getSorter().getClass()); //before running method

    testStudyGuideController.run();
    assertEquals(CreatedComparator.class,
        testStudyGuideController.getSorter().getClass());
  }

  @Test
  public void testSorterModified() {
    Path startPath = Path.of("./src/test/resources");
    String flag = "modified";
    Path endPath = Path.of("src/test/StudyGuide.md");
    StudyGuideController testStudyGuideController =
        new StudyGuideController(startPath, flag, endPath);

    assertEquals(ModifiedComparator.class, testStudyGuideController.getSorter().getClass());
    testStudyGuideController.run();
    assertEquals(ModifiedComparator.class, testStudyGuideController.getSorter().getClass());
  }

  @Test
  public void testSorterFilename() {
    Path startPath = Path.of("./src/test/resources");
    String flag = "filename";
    Path endPath = Path.of("src/test/StudyGuide.md");
    StudyGuideController testStudyGuideController =
        new StudyGuideController(startPath, flag, endPath);

    assertEquals(ModifiedComparator.class, testStudyGuideController.getSorter().getClass());
    testStudyGuideController.run();
    assertEquals(FileNameComparator.class, testStudyGuideController.getSorter().getClass());
  }


}