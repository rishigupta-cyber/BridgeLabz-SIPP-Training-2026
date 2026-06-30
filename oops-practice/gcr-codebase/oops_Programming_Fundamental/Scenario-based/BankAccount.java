public class BankAccount {
    String accountNumber;
    String holder;
    double balance;
    static int totalAccounts = 0;
    static double overdraftLimit = -5000.0;

    BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited Rs." + amount + " | New balance: Rs." + balance);
    }

    void withdraw(double amount) {
        if (balance - amount < overdraftLimit) {
            System.out.println(holder + " withdrawal of Rs." + amount + " denied - overdraft limit exceeded");
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew Rs." + amount + " | New balance: Rs." + balance);
        }
    }

    void getStatement() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holder + " | Final Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("AC101", "Rohit Sharma", 10000.0);
        BankAccount acc2 = new BankAccount("AC102", "Neha Kulkarni", 5000.0);
        BankAccount acc3 = new BankAccount("AC103", "Vikram Singh", 8000.0);

        acc1.deposit(2000.0);
        acc1.withdraw(3000.0);
        acc1.deposit(1500.0);
        acc1.withdraw(20000.0);
        acc1.withdraw(5000.0);

        acc2.deposit(1000.0);
        acc2.withdraw(2000.0);
        acc2.deposit(500.0);
        acc2.withdraw(1000.0);
        acc2.withdraw(8000.0);

        acc3.deposit(2000.0);
        acc3.withdraw(1000.0);
        acc3.deposit(3000.0);
        acc3.withdraw(15000.0);
        acc3.withdraw(2000.0);

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("Total accounts created: " + totalAccounts);
    }
}