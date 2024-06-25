package com.github.idelstak.viz;

import java.util.function.*;

public interface SortAlgorithm {

    void sort(int[] array, Consumer<int[]> stepCallback);
}