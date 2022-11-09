package com.amakhnev.problems.misc.changemachine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeMachineTest {

  ChangeMachine changeMachine;

  @BeforeEach
  public void setup() {
    changeMachine = new ChangeMachine();
  }

  @Test
  public void whenInvalidAmountGivenForSimpleCase_ThenExceptionThrown() {

    Exception thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> changeMachine.change(0),
            "Expected change(0) to throw, but it didn't");

    assertTrue(thrown.getMessage().contains("0"));

    thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> changeMachine.change(-123),
            "Expected change(0) to throw, but it didn't");
    assertTrue(thrown.getMessage().contains("-123"));
  }

  @Test
  public void whenSimpleCase_ShouldReturnExpectedResults() {
    assertThat(
        "Should return two coins for 6 pence", changeMachine.change(6), containsInAnyOrder(1, 5));
  }

  @Test
  public void whenComplexCase_ShouldReturnExpectedResults() {
    assertThat(
        "Should return 3 coins for 6p and till with 5p, 2p, 2p, 2p coins",
        changeMachine.change(List.of(5, 2, 2, 2), 6),
        containsInAnyOrder(2, 2, 2));

    assertThat(
        "Should return 2 coins for 6p and till with 5p, 2p, 2p, 2p, 1p coins",
        changeMachine.change(List.of(5, 2, 2, 2, 1), 6),
        containsInAnyOrder(1, 5));

    assertThat(
        "Should return 7 coins for 574p and till with 200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2 coins",
        changeMachine.change(List.of(200, 100, 20, 200, 10, 5, 50, 2, 1, 1, 2), 574),
        containsInAnyOrder(200, 200, 100, 50, 20, 2, 2));
  }
}
