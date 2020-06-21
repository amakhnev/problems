

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeMachineTest{

   ChangeMachine changeMachine;

   @BeforeEach
   public void setup(){
      changeMachine = new ChangeMachine();
   }

   @Test
   public void whenInvalidAmountGivenForSimpleMethod_ThenExceptionThrown(){

      Exception thrown = assertThrows(
          IllegalArgumentException.class,
          () -> changeMachine.change(0),
          "Expected change(0) to throw, but it didn't"
      );

    assertTrue(thrown.getMessage().contains("0"));

       thrown = assertThrows(
          IllegalArgumentException.class,
          () -> changeMachine.change(-123),
          "Expected change(0) to throw, but it didn't"
      );
      assertTrue(thrown.getMessage().contains("-123"));
   }

}
