package com.calculatorstreetfighter;

import com.calculatorstreetfighter.controller.CalculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/calculatorstreetfighter/view/MainWindowInterface.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Calculator Street Fighter - Round 1!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
        Image image = new Image(getClass().getResourceAsStream("/com/calculatorstreetfighter/assets/ICONStreerFighterCalculator.png"));
        stage.getIcons().add(image);
        ((CalculatorController) loader.getController()).init(stage);

    }

        public static void main (String[]args){
            launch(args);
        }

}
