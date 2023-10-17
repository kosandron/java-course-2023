package edu.hw2;

import edu.hw1.Task1;
import edu.hw2.Task4.CallInfo;
import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Tests {
    @Test
    @DisplayName("Test")
    void noSecondsTest() {
        // Arrange
        CallingInfo a = new CallingInfo("", "");
        // Act
            a = CallInfo.callingInfo();


        // Assert
        assertThat(a.className()).isEqualTo("edu.hw2.Task4Tests");
        assertThat(a.methodName()).isEqualTo("noSecondsTest");
    }
}
