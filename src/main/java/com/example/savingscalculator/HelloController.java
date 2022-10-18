package com.example.savingscalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class HelloController {
    @FXML
    private TextField Kapitał;
    @FXML
    private TextField Oprocentowanie;
    @FXML
    private TextField Czas;
    @FXML
    private TextField Składka;
    @FXML
    private TextField Podatek;
    @FXML
    private Button Calculate;

    final Integer monthsInYear = 12;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double capital = Double.parseDouble(Kapitał.getText());
            double timeRange = Double.parseDouble(Czas.getText());
            double percentage = Double.parseDouble(Oprocentowanie.getText()) / 100;
            double tax = Double.parseDouble(Podatek.getText()) / 100;

            double percentDifference = 1 - tax;
            double percentageMonthly = percentage / monthsInYear;
            double constantPercentageAndTax = percentageMonthly * percentDifference;
            double powHelper = 1 + constantPercentageAndTax;
            double calculateHelper = Math.pow(powHelper, timeRange);

            double premium = (capital * constantPercentageAndTax) / ((1 + constantPercentageAndTax) * (calculateHelper - 1));

            Składka.setText(String.valueOf(premium));

        } catch (Exception e) {
            System.out.println("Podaj liczbę");
        }
    }
}