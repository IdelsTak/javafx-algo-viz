package com.github.idelstak.viz;

import java.io.*;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class VizApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VizApplication.class.getResource("viz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Algo Viz");
        stage.setScene(scene);
        stage.show();
    }
}