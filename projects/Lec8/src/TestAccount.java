import java.util.*;

public class TestAccount {

	public static void main(String[] args) {
		
		Account1 account = new Account1("George", 1122, 1000);
        account.setAnnualInterestRate(1.65);

        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println("Name : " + account.getName());
        System.out.printf("Annual interest rate : %.1f\n", Math.floor(account.getAnnualInterestRate()*10)/10);
        System.out.println("Balance : " + account.getBalance());
        System.out.println(account.getTransactionTable());
		

	}

}
