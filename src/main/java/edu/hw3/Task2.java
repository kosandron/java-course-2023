package edu.hw3;

import java.util.ArrayList;

public final class Task2 {

    private Task2() {
    }

    public static ArrayList<String> clusterize(String str) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance--;
            } else if (str.charAt(i) == ')') {
                balance++;
            } else {
                throw new IllegalArgumentException("Another char in string!");
            }
            cluster.append(str.charAt(i));

            if (balance == 0) {
                result.add(cluster.toString());
                cluster.delete(0, cluster.length());
            }
        }

        return result;
    }
}
