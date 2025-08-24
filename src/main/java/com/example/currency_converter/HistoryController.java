package com.example.currency_converter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class HistoryController {

    @FXML private TableView<CurrencyConversion> historyTable;
    @FXML private TableColumn<CurrencyConversion, String> fromCol;
    @FXML private TableColumn<CurrencyConversion, String> toCol;
    @FXML private TableColumn<CurrencyConversion, Double> amountCol;
    @FXML private TableColumn<CurrencyConversion, Double> resultCol;

    @FXML
    public void initialize() {
        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        resultCol.setCellValueFactory(new PropertyValueFactory<>("result"));

        historyTable.setItems(ConverterController.history);
    }

    @FXML
    private void handleBack() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("converter-view.fxml"));
        VBox root = loader.load();
        Scene mainScene = new Scene(root, 400, 250);
        MainApp.setScene(mainScene);
    }

}
