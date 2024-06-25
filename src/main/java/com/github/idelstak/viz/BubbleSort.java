package com.github.idelstak.viz;

import java.util.function.*;

public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Consumer<int[]> stepCallback) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                    stepCallback.accept(array.clone());
                    try {
                        // Adjust to control animation speed
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            n--;
        } while (swapped);
    }
}