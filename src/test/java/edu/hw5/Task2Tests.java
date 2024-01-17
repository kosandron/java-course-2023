package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Tests {
    @ParameterizedTest
    @ValueSource(ints = {1970, 2007, 2050, 3000})
    public void testGetAllFriday13thInYear(int year) {
        // Act
        List<LocalDate> fridayThe13ths = Task2.getAll13thFridayInYear(year);

        // Assert
        assertThat(fridayThe13ths.isEmpty()).isFalse();
        for (LocalDate date : fridayThe13ths) {
            assertThat(date.getDayOfWeek()).isEqualTo(DayOfWeek.FRIDAY);
            assertThat(date.getDayOfMonth()).isEqualTo(13);
            assertThat(date.getYear()).isEqualTo(year);
        }
    }

    @Test
    public void testGetAllFriday13thIn2006() {
        // Arrange
        List<LocalDate> answer = List.of(
            LocalDate.parse("2006-01-13"),
            LocalDate.parse("2006-10-13")
        );

        // Act
        List<LocalDate> friday13 = Task2.getAll13thFridayInYear(2006);

        // Assert
        assertThat(friday13).isEqualTo(answer);
    }
}
