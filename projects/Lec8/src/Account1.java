//21101989 황지연

import java.util.*;

public class Account1 extends Account {
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account1(String name, int id, double balance) {
        super(id, balance);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
        transactions.add(new Transaction('W', amount, getBalance(), "Withdrawal"));
    }

    public void deposit(double amount) {
        super.deposit(amount);
        transactions.add(new Transaction('D', amount, getBalance(), "Deposit"));
    }
    
    public String getTransactionTable() {
        String table = "Date\t\t\t\tType\t\tAmount\t\tBalance\n";
        for (Transaction t : transactions) {
            table += t.toString() + "\n";
        }
        return table;
    }
    
    
    class Transaction {
        private Date date;
        private char type;
        private double amount;
        private double balance;
        private String description;

        public Transaction(char type, double amount, double balance, String description) {
            this.date = new Date();
            this.type = type;
            this.amount = amount;
            this.balance = balance;
            this.description = description;
       }

    public String toString() {
       return String.format("%s\t%s\t\t%.2f\t\t%.2f", date.toString(), type, amount, balance);
        }
}
}