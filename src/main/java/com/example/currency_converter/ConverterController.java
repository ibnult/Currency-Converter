package com.example.currency_converter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ConverterController {

    @FXML private TextField amountField;
    @FXML private ComboBox<String> fromCurrency;
    @FXML private ComboBox<String> toCurrency;
    @FXML private Label resultLabel;

    public static ObservableList<CurrencyConversion> history = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        fromCurrency.getItems().addAll("USD", "EUR", "BDT");
        toCurrency.getItems().addAll("USD", "EUR", "BDT");
    }

    @FXML
    private void handleConvert() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            if (from == null || to == null) {
                resultLabel.setText("Select currencies!");
                return;
            }

            double converted = convertCurrency(amount, from, to);
            resultLabel.setText(String.format("%.2f %s", converted, to));

            history.add(new CurrencyConversion(from, to, amount, converted));

        } catch (NumberFormatException e) {
            resultLabel.setText("Enter valid amount!");
        }
    }

    @FXML
    private void handleViewHistory() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("history-view.fxml"));
        VBox root = loader.load();
        Scene historyScene = new Scene(root, 400, 300);
        MainApp.setScene(historyScene);
    }

    private double convertCurrency(double amount, String from, String to) {
        double usdToEur = 0.9;
        double usdToBdt = 110;

        if (from.equals(to)) return amount;

        double inUsd;
        switch (from) {
            case "USD": inUsd = amount; break;
            case "EUR": inUsd = amount / usdToEur; break;
            case "BDT": inUsd = amount / usdToBdt; break;
            default: return amount;
        }

        switch (to) {
            case "USD": return inUsd;
            case "EUR": return inUsd * usdToEur;
            case "BDT": return inUsd * usdToBdt;
            default: return amount;
        }
    }
}
