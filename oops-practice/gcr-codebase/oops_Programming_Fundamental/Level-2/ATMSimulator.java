public class ATMSimulator {
    String accountHolder;
    String accountNumber;
    double balance;

    ATMSimulator(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance to withdraw " + amount);
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        ATMSimulator account = new ATMSimulator("Rishi Gupta", "AC10293847", 5000.0);

        account.displayBalance();
        account.deposit(2000.0);
        account.withdraw(1500.0);
        account.withdraw(10000.0);
        account.displayBalance();
    }
}