package com.calculatorstreetfighter.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CalculatorController {

    @FXML private Node titlePanel;
    @FXML private ImageView btnClose;

    @FXML private Label lblResult;

    private double x, y;
    private boolean iniciouSegundoNumero = false;
    private String operator = "+";
    private double num1 = 0;

    public void init(Stage stage) {
        titlePanel.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePanel.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        if (btnClose != null) {
            btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        }
    }

    @FXML
    void onNumberClicked(MouseEvent event) {

        if (iniciouSegundoNumero) {
            lblResult.setText("0");
            iniciouSegundoNumero = false;
        }

        String id = ((Node) event.getSource()).getId();
        String value = id.replace("bt", "");


        if (lblResult.getText().equals("0") || lblResult.getText().equals("0.0")) {
            lblResult.setText(value);
        } else {
            lblResult.setText(lblResult.getText() + value);
        }
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Node) event.getSource()).getId().replace("bt", "");

        if (symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+" -> lblResult.setText(String.valueOf(num1 + num2));
                case "-" -> lblResult.setText(String.valueOf(num1 - num2));
                case "*" -> lblResult.setText(String.valueOf(num1 * num2));
                case "/" -> {
                    if (num2 == 0) {
                        lblResult.setText("ERROR");
                    } else {
                        lblResult.setText(String.valueOf(num1 / num2));
                    }
                }
            }
            operator = "+";
            iniciouSegundoNumero = true;
        }

        else if (symbol.equals("Clear")) {
            lblResult.setText("0.0");
            num1 = 0;
            operator = "+";
            iniciouSegundoNumero = false;
        }

        else if (symbol.equals("Negative")) {
            double valor = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(valor * -1));
        }
        else {
            num1 = Double.parseDouble(lblResult.getText());

            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
                default -> operator = "+";
            }

            lblResult.setText(num1 + " " + operator);
            iniciouSegundoNumero = true;
        }
    }
}