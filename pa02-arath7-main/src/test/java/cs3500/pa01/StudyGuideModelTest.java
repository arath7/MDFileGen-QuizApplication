package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * class for testing the StudyGuideModel class and methods
 */
class StudyGuideModelTest {

  /**
   * test for when constructor fails to instantiate
   */
  @Test
  public void constructorFailure1() {
    assertThrows(IllegalArgumentException.class,
        () -> new StudyGuideModel(null, Path.of("n/a"),
            new ArrayList<>(), new CreatedComparator()));
  }

  /**
   * test for when constructor fails to instantiate
   */
  @Test
  public void constructorFailure2() {
    assertThrows(IllegalArgumentException.class,
        () -> new StudyGuideModel(Path.of("n/a"), null,
            new ArrayList<>(), new CreatedComparator()));
  }

  /**
   * test for when constructor fails to instantiate
   */
  @Test
  public void constructorFailure3() {
    assertThrows(IllegalArgumentException.class,
        () -> new StudyGuideModel(Path.of("n/a"), Path.of("n/a"),
            null, new CreatedComparator()));
  }

  /**
   * test for when constructor fails to instantiate
   */
  @Test
  public void constructorFailure4() {
    assertThrows(IllegalArgumentException.class,
        () -> new StudyGuideModel(Path.of("n/a"), Path.of("n/a"),
            new ArrayList<>(), null));
  }
}