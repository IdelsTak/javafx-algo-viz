package com.github.idelstak.viz;

import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;

import java.util.concurrent.*;

public class VizViewController {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    @FXML
    private Canvas canvas;
    @FXML
    private BorderPane root;

    @FXML
    public void startAlgorithm(ActionEvent actionEvent) {
        int[] array = generateRandomArray(100);
        startSorting(array, canvas.getGraphicsContext2D());

        actionEvent.consume();
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    private void startSorting(int[] array, GraphicsContext gc) {
        SortAlgorithm sorter = new BubbleSort();
        executor.submit(() -> sorter.sort(array, step -> Platform.runLater(() -> drawArray(gc, step))));
    }

    private void drawArray(GraphicsContext gc, int[] array) {
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        gc.clearRect(0, 0, width, height);
        double barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            double innerHeight = (double) array[i] / array.length * height;
            gc.fillRect(i * barWidth, height - innerHeight, barWidth, innerHeight);
        }
    }

    @FXML
    private void initialize() {
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
    }
}