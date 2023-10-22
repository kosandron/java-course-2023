package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockShop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Tests {
    @Test
    @DisplayName("most expensive stock")
    void mostExpensiveStock() {
        // Arrange
        StockMarket stockMarket = new StockShop();
        stockMarket.add(new Stock(50, "Gazprom"));
        stockMarket.add(new Stock(60, "Tinkoff"));
        stockMarket.add(new Stock(40, "Yandex"));

        // Act
        Stock mostExpensiveStock = stockMarket.mostValuableStock();


        // Assert
        assertThat(mostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
    }

    @Test
    @DisplayName("most expensive stock after remove")
    void mostExpensiveStockAfterRemove() {
        // Arrange
        StockMarket stockMarket = new StockShop();
        stockMarket.add(new Stock(50, "Gazprom"));
        stockMarket.add(new Stock(60, "Tinkoff"));
        stockMarket.add(new Stock(40, "Yandex"));

        // Act
        Stock mostExpensiveStock = stockMarket.mostValuableStock();
        stockMarket.remove(mostExpensiveStock);
        Stock secondMostExpensiveStock = stockMarket.mostValuableStock();

        // Assert
        assertThat(mostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
        assertThat(secondMostExpensiveStock)
            .isEqualTo(new Stock(50, "Gazprom"));
    }

    @Test
    @DisplayName("most expensive stock after add")
    void mostExpensiveStockAfterAdd() {
        // Arrange
        StockMarket stockMarket = new StockShop();
        stockMarket.add(new Stock(50, "Gazprom"));
        stockMarket.add(new Stock(60, "Tinkoff"));
        stockMarket.add(new Stock(40, "Yandex"));

        // Act
        Stock mostExpensiveStock = stockMarket.mostValuableStock();
        stockMarket.add(new Stock(100, "Tesla"));
        Stock newMostExpensiveStock = stockMarket.mostValuableStock();

        // Assert
        assertThat(mostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
        assertThat(newMostExpensiveStock)
            .isEqualTo(new Stock(100, "Tesla"));
    }

    @Test
    @DisplayName("no changes after add")
    void noChangesAfterAdd() {
        // Arrange
        StockMarket stockMarket = new StockShop();
        stockMarket.add(new Stock(50, "Gazprom"));
        stockMarket.add(new Stock(60, "Tinkoff"));
        stockMarket.add(new Stock(40, "Yandex"));

        // Act
        Stock mostExpensiveStock = stockMarket.mostValuableStock();
        stockMarket.add(new Stock(30, "Tesla"));
        Stock newMostExpensiveStock = stockMarket.mostValuableStock();

        // Assert
        assertThat(mostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
        assertThat(newMostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
    }

    @Test
    @DisplayName("no changes after remove")
    void noChangesAfterRemove() {
        // Arrange
        StockMarket stockMarket = new StockShop();
        stockMarket.add(new Stock(50, "Gazprom"));
        stockMarket.add(new Stock(60, "Tinkoff"));
        stockMarket.add(new Stock(40, "Yandex"));

        // Act
        Stock mostExpensiveStock = stockMarket.mostValuableStock();
        stockMarket.remove(new Stock(50, "Gazprom"));
        Stock newMostExpensiveStock = stockMarket.mostValuableStock();

        // Assert
        assertThat(mostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
        assertThat(newMostExpensiveStock)
            .isEqualTo(new Stock(60, "Tinkoff"));
    }
}
