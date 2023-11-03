package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTests {
    private Animal cat = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 2, 50, 15, true);
    private Animal dog = new Animal("Sharik Kosharik", Animal.Type.DOG, Animal.Sex.M, 4, 70, 25, true);
    private Animal parrot = new Animal("Newton", Animal.Type.BIRD, Animal.Sex.F, 5, 20, 8, false);
    private Animal spider = new Animal("Rectus Angulus Camawinga", Animal.Type.SPIDER, Animal.Sex.F, 2, 10, 6, true);
    private Animal fish = new Animal("Guppi Luppi Puppi", Animal.Type.FISH, Animal.Sex.F, 3, 2, 4, false);

    @Test
    @DisplayName("Task1.sortAnimalsByHeight")
    void task1Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        List<Animal> answer = new ArrayList<Animal>() {};
        answer.add(spider);
        answer.add(parrot);
        answer.add(cat);
        answer.add(dog);

        // Act
        List<Animal> result = Task1.sortAnimalsByHeight(list);

        // Assert
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("Task2.sortDecreasingByWeight")
    void task2Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        List<Animal> answer = new ArrayList<Animal>() {};
        answer.add(parrot);
        answer.add(cat);
        answer.add(dog);
        Collections.reverse(answer);

        // Act
        List<Animal> result = Task2.sortDecreasingByWeight(list, 3);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task3.AnimalTypesCounter")
    void task3Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(cat);
        list.add(parrot);
        list.add(cat);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        Map<Animal.Type, Long> answer = new HashMap<>();
        answer.put(Animal.Type.CAT, 3L);
        answer.put(Animal.Type.DOG, 1L);
        answer.put(Animal.Type.SPIDER, 2L);
        answer.put(Animal.Type.BIRD, 1L);

        // Act
        Map<Animal.Type, Long> result = Task3.animalTypesCounter(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task4.animalWithLongestName")
    void task4Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        Animal answer = spider;

        // Act
        Animal result = Task4.animalWithLongestName(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task5.mostPopularGender")
    void task5Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        Animal.Sex answer = Animal.Sex.F;

        // Act
        Animal.Sex result = Task5.mostPopularGender(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task6.mostHeavyAnimal")
    void task6Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(cat);
        list.add(parrot);
        list.add(cat);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        list.add(new Animal("Ruzuk", Animal.Type.CAT, Animal.Sex.M, 12, 10, 24, true));
        list.add(new Animal("Bobka", Animal.Type.BIRD, Animal.Sex.M, 12, 10, 10, false));
        Map<Animal.Type, Animal> answer = new HashMap<>();
        answer.put(Animal.Type.CAT, new Animal("Ruzuk", Animal.Type.CAT, Animal.Sex.M, 12, 10, 24, true));
        answer.put(Animal.Type.DOG, dog);
        answer.put(Animal.Type.SPIDER, spider);
        answer.put(Animal.Type.BIRD, new Animal("Bobka", Animal.Type.BIRD, Animal.Sex.M, 12, 10, 10, false));

        // Act
        Map<Animal.Type, Animal> result = Task6.mostHeavyAnimal(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task7.oldestAnimal")
    void task7Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        Animal answer = parrot;

        // Act
        Animal result = Task7.oldestAnimal(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task8.mostHeavyAnimalShorterK")
    void task8Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        list.add(fish);
        Optional<Animal> answer = Optional.of(spider);

        // Act
        Optional<Animal> result = Task8.mostHeavyAnimalShorterK(list, 15);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task9.sumOfPaws")
    void task9Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        list.add(spider);
        list.add(fish);
        Integer answer = 26;

        // Act
        Integer result = Task9.sumOfPaws(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task10.animalWithDifferentAgeAndPawsCount")
    void task10Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(dog);
        List<Animal> answer = new ArrayList<Animal>() {};
        answer.add(cat);
        answer.add(parrot);
        answer.add(spider);

        // Act
        List<Animal> result = Task10.animalWithDifferentAgeAndPawsCount(list);

        // Assert
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("Task11.animalThatBitsAndTaller100")
    void task11Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Animal("Uppi", Animal.Type.CAT, Animal.Sex.M, 12, 125, 24, true));
        list.add(parrot);
        list.add(new Animal("Rew Cooringa", Animal.Type.SPIDER, Animal.Sex.M, 12, 105, 24, true));
        list.add(new Animal("Gor", Animal.Type.DOG, Animal.Sex.M, 12, 130, 24, true));
        list.add(fish);
        list.add(new Animal("Ruzuk", Animal.Type.CAT, Animal.Sex.M, 12, 15, 24, true));
        List<Animal> answer = new ArrayList<Animal>() {};
        answer.add(new Animal("Uppi", Animal.Type.CAT, Animal.Sex.M, 12, 125, 24, true));
        answer.add(new Animal("Rew Cooringa", Animal.Type.SPIDER, Animal.Sex.M, 12, 105, 24, true));
        answer.add(new Animal("Gor", Animal.Type.DOG, Animal.Sex.M, 12, 130, 24, true));

        // Act
        List<Animal> result = Task11.animalThatBitsAndTaller100(answer);

        // Assert
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("Task12.fatAnimalsCount")
    void task12Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(fish);
        list.add(dog);
        list.add(spider);
        list.add(fish);
        Integer answer = 2;

        // Act
        Integer result = Task12.fatAnimalsCount(list);

        // Assert
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("Task13.animalsWithLongName")
    void task13Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(fish);
        List<Animal> answer = new ArrayList<Animal>() {};
        answer.add(spider);
        answer.add(fish);

        // Act
        List<Animal> result = Task13.animalsWithLongName(list);

        // Assert
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("Task14.hasDogBiggerK: false")
    void task14FalseTest() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(fish);
        list.add(dog);

        // Act
        boolean result = Task14.hasDogBiggerK(list, 100);

        // Assert
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Task14.hasDogBiggerK: true")
    void task14TrueTest() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(fish);
        list.add(dog);

        // Act
        boolean result = Task14.hasDogBiggerK(list, 23);

        // Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Task15.weightSumAnimalsInAgeInterval")
    void task15Test() {
        // Arrange
        List<Animal> list = new ArrayList<Animal>();
        list.add(cat);
        list.add(parrot);
        list.add(spider);
        list.add(fish);
        list.add(dog);
        Integer answer = cat.weight() + spider.weight() + fish.weight();

        // Act
        Integer result = Task15.weightSumAnimalsInAgeInterval(list, 2, 3);

        // Assert
        assertThat(answer).isEqualTo(result);
    }
}
