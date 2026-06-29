public class BankAccountSystem {
    final String accountNumber;
    String accountHolderName;
    double balance;
    static String bankName = "National Trust Bank";
    static int totalAccounts = 0;

    BankAccountSystem(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    void displayDetails() {
        if (this instanceof BankAccountSystem) {
            System.out.println("Bank: " + bankName + ", Account No: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: Rs." + balance);
        }
    }

    static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    public static void main(String[] args) {
        BankAccountSystem acc1 = new BankAccountSystem("AC1001", "Suresh Patil", 25000.0);
        BankAccountSystem acc2 = new BankAccountSystem("AC1002", "Meena Shah", 40000.0);

        acc1.displayDetails();
        acc2.displayDetails();

        BankAccountSystem.getTotalAccounts();
    }
}