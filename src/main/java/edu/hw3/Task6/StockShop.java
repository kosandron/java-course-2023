package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class StockShop implements StockMarket {
    private PriorityQueue<Stock> stockList = new PriorityQueue<>(new Comparator<Stock>() {
        @Override
        public int compare(Stock o1, Stock o2) {
            return o2.price() - o1.price();
        }
    });

    @Override
    public void add(Stock stock) {
        stockList.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockList.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockList.peek();
    }
}
