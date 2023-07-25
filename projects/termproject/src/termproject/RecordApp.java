package termproject;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RecordApp extends Application {

    private ObservableList<Record> expenseRecords;
    private ObservableList<Record> incomeRecords;
    private TableView<Record> expenseTableView;
    private TableView<Record> incomeTableView;
    private TextField categoryTextField;
    private TextField amountTextField;



    @Override
    public void start(Stage primaryStage) {
        expenseRecords = FXCollections.observableArrayList();
        incomeRecords = FXCollections.observableArrayList();

        expenseTableView = createRecordTableView(expenseRecords);
        incomeTableView = createRecordTableView(incomeRecords);

        categoryTextField = new TextField();
        amountTextField = new TextField();

        Button addExpenseButton = new Button("Add Expense");
        addExpenseButton.setOnAction(e -> addExpenseRecord());

        Button addIncomeButton = new Button("Add Income");
        addIncomeButton.setOnAction(e -> addIncomeRecord());

        Button updateExpenseButton = new Button("Update Expense");
        updateExpenseButton.setOnAction(e -> updateExpenseRecord());

        Button updateIncomeButton = new Button("Update Income");
        updateIncomeButton.setOnAction(e -> updateIncomeRecord());

        Button deleteExpenseButton = new Button("Delete Expense");
        deleteExpenseButton.setOnAction(e -> deleteExpenseRecord());

        Button deleteIncomeButton = new Button("Delete Income");
        deleteIncomeButton.setOnAction(e -> deleteIncomeRecord());

        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(10);
        inputGridPane.setVgap(5);
        inputGridPane.addRow(0, new Label("Category:"), categoryTextField);
        inputGridPane.addRow(1, new Label("Amount:"), amountTextField);

        VBox expenseBox = new VBox(10, new Label("Expense Records"), expenseTableView, inputGridPane, addExpenseButton, updateExpenseButton, deleteExpenseButton);
        VBox incomeBox = new VBox(10, new Label("Income Records"), incomeTableView, addIncomeButton, updateIncomeButton, deleteIncomeButton);

        HBox root = new HBox(10, expenseBox, incomeBox);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Record App");
        primaryStage.show();
    }

    private TableView<Record> createRecordTableView(ObservableList<Record> records) {
        TableView<Record> tableView = new TableView<>(records);

        TableColumn<Record, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());

        TableColumn<Record, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());

        tableView.getColumns().addAll(categoryColumn, amountColumn);

        return tableView;
    }

    private void addExpenseRecord() {
        String category = categoryTextField.getText();
        double amount = Double.parseDouble(amountTextField.getText());

        Record record = new Record(category, amount);
        expenseRecords.add(record);

        categoryTextField.clear();
        amountTextField.clear();
    }

    private void addIncomeRecord() {
        String category = categoryTextField.getText();
        double amount = Double.parseDouble(amountTextField.getText());

        Record record = new Record(category, amount);
        incomeRecords.add(record);

        categoryTextField.clear();
        amountTextField.clear();
    }

    private void updateExpenseRecord() {
        Record selectedRecord = expenseTableView.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            String category = categoryTextField.getText();
            double amount = Double.parseDouble(amountTextField.getText());

            selectedRecord.setCategory(category);
            selectedRecord.setAmount(amount);

            expenseTableView.refresh();

            categoryTextField.clear();
            amountTextField.clear();
        }
    }

    private void updateIncomeRecord() {
        Record selectedRecord = incomeTableView.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            String category = categoryTextField.getText();
            double amount = Double.parseDouble(amountTextField.getText());

            selectedRecord.setCategory(category);
            selectedRecord.setAmount(amount);

            incomeTableView.refresh();

            categoryTextField.clear();
            amountTextField.clear();
        }
    }

    private void deleteExpenseRecord() {
        Record selectedRecord = expenseTableView.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            expenseRecords.remove(selectedRecord);
        }
    }

    private void deleteIncomeRecord() {
        Record selectedRecord = incomeTableView.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            incomeRecords.remove(selectedRecord);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class Record {
    private String category;
    private double amount;

    public Record(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StringProperty categoryProperty() {
        return new SimpleStringProperty(category);
    }

    public DoubleProperty amountProperty() {
        return new SimpleDoubleProperty(amount);
    }
    
    
}


