package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * class to test MenuOptions enum
 */
class MenuOptionsTest {
  int input1 = 1;
  int input2 = 2;
  int input3 = 3;
  int input4 = 4;
  int input5 = 5;
  int wrongInput = 10;


  /**
   * test for menuOptions method
   */
  @Test
  public void testMenuOptions() {

    assertEquals(MenuOptions.EASY, MenuOptions.assignEnum(input1));
    assertEquals(MenuOptions.HARD, MenuOptions.assignEnum(input2));
    assertEquals(MenuOptions.ANSWER, MenuOptions.assignEnum(input3));
    assertEquals(MenuOptions.NEXT, MenuOptions.assignEnum(input4));
    assertEquals(MenuOptions.EXIT, MenuOptions.assignEnum(input5));

    assertThrows(IllegalArgumentException.class,
        () -> MenuOptions.assignEnum(wrongInput));
  }
}