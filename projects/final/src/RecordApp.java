import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RecordApp extends Application {

    private TableView<ExpenseRecord> expenseTableView;
    private ObservableList<ExpenseRecord> expenseRecords;
    private TextField expenseCategoryTextField;
    private TextField expenseAmountTextField;
    private DatePicker expenseDatePicker;
    private Label expenseTotalLabel;

    private TableView<IncomeRecord> incomeTableView;
    private ObservableList<IncomeRecord> incomeRecords;
    private TextField incomeCategoryTextField;
    private TextField incomeAmountTextField;
    private DatePicker incomeDatePicker;
    private Label incomeTotalLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Record App");

        // Expense
        expenseTableView = new TableView<>();
        expenseRecords = FXCollections.observableArrayList();
        expenseTableView.setItems(expenseRecords);

        TableColumn<ExpenseRecord, String> expenseCategoryColumn = new TableColumn<>("Category");
        expenseCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<ExpenseRecord, Double> expenseAmountColumn = new TableColumn<>("Amount"); 
        expenseAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<ExpenseRecord, LocalDate> expenseDateColumn = new TableColumn<>("Date"); 
        expenseDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        expenseTableView.getColumns().addAll(expenseCategoryColumn, expenseAmountColumn, expenseDateColumn);

        expenseCategoryTextField = new TextField();
        expenseAmountTextField = new TextField();
        expenseDatePicker = new DatePicker();
        Button expenseAddButton = new Button("Add");
        Button expenseUpdateButton = new Button("Update");
        Button expenseDeleteButton = new Button("Delete");

        expenseAddButton.setOnAction(e -> addExpenseRecord());
        expenseUpdateButton.setOnAction(e -> updateExpenseRecord());
        expenseDeleteButton.setOnAction(e -> deleteExpenseRecord());

        GridPane expenseFormPane = createFormPane(
                new Label("Category:"), expenseCategoryTextField,
                new Label("Amount:"), expenseAmountTextField,
                new Label("Date:"), expenseDatePicker,
                expenseAddButton, expenseUpdateButton, expenseDeleteButton
        );

        expenseTotalLabel = createTotalLabel("Expense Total: 0.00");

        VBox expenseVBox = createVBox("Expenses", expenseTableView, expenseFormPane, expenseTotalLabel);

        // Income 
        incomeTableView = new TableView<>();
        incomeRecords = FXCollections.observableArrayList();
        incomeTableView.setItems(incomeRecords);

        TableColumn<IncomeRecord, String> incomeCategoryColumn = new TableColumn<>("Category");
        incomeCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<IncomeRecord, Double> incomeAmountColumn = new TableColumn<>("Amount"); 
        incomeAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<IncomeRecord, LocalDate> incomeDateColumn = new TableColumn<>("Date"); 
        incomeDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        incomeTableView.getColumns().addAll(incomeCategoryColumn, incomeAmountColumn, incomeDateColumn);

        incomeCategoryTextField = new TextField();
        incomeAmountTextField = new TextField();
        incomeDatePicker = new DatePicker();
        Button incomeAddButton = new Button("Add");
        Button incomeUpdateButton = new Button("Update");
        Button incomeDeleteButton = new Button("Delete");

        incomeAddButton.setOnAction(e -> addIncomeRecord());
        incomeUpdateButton.setOnAction(e -> updateIncomeRecord());
        incomeDeleteButton.setOnAction(e -> deleteIncomeRecord());

        GridPane incomeFormPane = createFormPane(
                new Label("Category:"), incomeCategoryTextField,
                new Label("Amount:"), incomeAmountTextField,
                new Label("Date:"), incomeDatePicker,
                incomeAddButton, incomeUpdateButton, incomeDeleteButton
        );

        incomeTotalLabel = createTotalLabel("Income Total: 0.00");

        VBox incomeVBox = createVBox("Incomes", incomeTableView, incomeFormPane, incomeTotalLabel);

        // 메인화면
        HBox mainLayout = new HBox(expenseVBox, incomeVBox);
        mainLayout.setSpacing(20);
        mainLayout.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(mainLayout));
        primaryStage.show();
    }

    private GridPane createFormPane(Node... nodes) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        for (int i = 0; i < nodes.length; i++) {
            gridPane.add(nodes[i], 0, i);
        }

        return gridPane;
    }

    private Label createTotalLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-weight: bold");
        return label;
    }

    private VBox createVBox(String title, TableView<?> tableView, GridPane formPane, Label totalLabel) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(new Label(title), tableView, formPane, totalLabel);
        return vBox;
    }

    private void addExpenseRecord() {
        String category = expenseCategoryTextField.getText();
        String amountText = expenseAmountTextField.getText();
        LocalDate date = expenseDatePicker.getValue();

        if (!category.isEmpty() && !amountText.isEmpty() && date != null) {
            try {
                double amount = Double.parseDouble(amountText);
                ExpenseRecord record = new ExpenseRecord(category, amount, date);
                expenseRecords.add(record);
                updateExpenseTotal();
                clearExpenseFields();
            } catch (NumberFormatException e) {
                showAlert("Invalid amount format");
            }
        } else {
            showAlert("Please enter all fields");
        }
    }

    private void updateExpenseRecord() {
        ExpenseRecord selectedRecord = expenseTableView.getSelectionModel().getSelectedItem();

        if (selectedRecord != null) {
            String category = expenseCategoryTextField.getText();
            String amountText = expenseAmountTextField.getText();
            LocalDate date = expenseDatePicker.getValue();

            if (!category.isEmpty() && !amountText.isEmpty() && date != null) {
                try {
                    double amount = Double.parseDouble(amountText);
                    selectedRecord.setCategory(category);
                    selectedRecord.setAmount(amount);
                    selectedRecord.setDate(date);
                    expenseTableView.refresh();
                    updateExpenseTotal();
                    clearExpenseFields();
                } catch (NumberFormatException e) {
                    showAlert("Invalid amount format");
                }
            } else {
                showAlert("Please enter all fields");
            }
        } else {
            showAlert("No expense record selected");
        }
    }

    private void deleteExpenseRecord() {
        ExpenseRecord selectedRecord = expenseTableView.getSelectionModel().getSelectedItem();

        if (selectedRecord != null) {
            expenseRecords.remove(selectedRecord);
            updateExpenseTotal();
            clearExpenseFields();
        } else {
            showAlert("No expense record selected");
        }
    }

    private void addIncomeRecord() {
        String category = incomeCategoryTextField.getText();
        String amountText = incomeAmountTextField.getText();
        LocalDate date = incomeDatePicker.getValue();

        if (!category.isEmpty() && !amountText.isEmpty() && date != null) {
            try {
                double amount = Double.parseDouble(amountText);
                IncomeRecord record = new IncomeRecord(category, amount, date);
                incomeRecords.add(record);
                updateIncomeTotal();
                clearIncomeFields();
            } catch (NumberFormatException e) {
                showAlert("Invalid amount format");
            }
        } else {
            showAlert("Please enter all fields");
        }
    }

    private void updateIncomeRecord() {
        IncomeRecord selectedRecord = incomeTableView.getSelectionModel().getSelectedItem();

        if (selectedRecord != null) {
            String category = incomeCategoryTextField.getText();
            String amountText = incomeAmountTextField.getText();
            LocalDate date = incomeDatePicker.getValue();

            if (!category.isEmpty() && !amountText.isEmpty() && date != null) {
                try {
                    double amount = Double.parseDouble(amountText);
                    selectedRecord.setCategory(category);
                    selectedRecord.setAmount(amount);
                    selectedRecord.setDate(date);
                    incomeTableView.refresh();
                    updateIncomeTotal();
                    clearIncomeFields();
                } catch (NumberFormatException e) {
                    showAlert("Invalid amount format");
                }
            } else {
                showAlert("Please enter all fields");
            }
        } else {
            showAlert("No income record selected");
        }
    }

    private void deleteIncomeRecord() {
        IncomeRecord selectedRecord = incomeTableView.getSelectionModel().getSelectedItem();

        if (selectedRecord != null) {
            incomeRecords.remove(selectedRecord);
            updateIncomeTotal();
            clearIncomeFields();
        } else {
            showAlert("No income record selected");
        }
    }

    private void updateExpenseTotal() {
        double total = expenseRecords.stream().mapToDouble(ExpenseRecord::getAmount).sum();
        expenseTotalLabel.setText("Expense Total: " + String.format("%.2f", total));
    }

    private void updateIncomeTotal() {
        double total = incomeRecords.stream().mapToDouble(IncomeRecord::getAmount).sum();
        incomeTotalLabel.setText("Income Total: " + String.format("%.2f", total));
    }

    private void clearExpenseFields() {
        expenseCategoryTextField.clear();
        expenseAmountTextField.clear();
        expenseDatePicker.setValue(null);
    }

    private void clearIncomeFields() {
        incomeCategoryTextField.clear();
        incomeAmountTextField.clear();
        incomeDatePicker.setValue(null);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class ExpenseRecord {
        private SimpleStringProperty category;
        private SimpleDoubleProperty amount;
        private SimpleObjectProperty<LocalDate> date;

        public ExpenseRecord(String category, double amount, LocalDate date) {
            this.category = new SimpleStringProperty(category);
            this.amount = new SimpleDoubleProperty(amount);
            this.date = new SimpleObjectProperty<>(date);
        }

        public String getCategory() {
            return category.get();
        }

        public void setCategory(String category) {
            this.category.set(category);
        }

        public double getAmount() {
            return amount.get();
        }

        public void setAmount(double amount) {
            this.amount.set(amount);
        }

        public LocalDate getDate() {
            return date.get();
        }

        public void setDate(LocalDate date) {
            this.date.set(date);
        }
    }

    public static class IncomeRecord {
        private SimpleStringProperty category;
        private SimpleDoubleProperty amount;
        private SimpleObjectProperty<LocalDate> date;

        public IncomeRecord(String category, double amount, LocalDate date) {
            this.category = new SimpleStringProperty(category);
            this.amount = new SimpleDoubleProperty(amount);
            this.date = new SimpleObjectProperty<>(date);
        }

        public String getCategory() {
            return category.get();
        }

        public void setCategory(String category) {
            this.category.set(category);
        }

        public double getAmount() {
            return amount.get();
        }

        public void setAmount(double amount) {
            this.amount.set(amount);
        }

        public LocalDate getDate() {
            return date.get();
        }

        public void setDate(LocalDate date) {
            this.date.set(date);
        }
    }
}
