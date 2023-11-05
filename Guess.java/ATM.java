import java.util.Scanner;

class BankAccount {
    private double accountBalance;
    
    public BankAccount(double initialBalance){
        accountBalance = initialBalance;
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            accountBalance += amount;
            System.out.println("Deposited --> $" + amount);
        }
        else{
            System.out.println("Invalid Deposit amount...");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= accountBalance){
            accountBalance -= amount;
            System.out.println("Withdrawn --> $" + amount);
        }
        else{
            System.out.println("Invalid Withdrawal amount or insufficient balance");
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account){
        userAccount = account;
        scanner = new Scanner(System.in);
    }

    public void checkBalance(){
        System.out.println("Current Balance is --> $" + userAccount.getAccountBalance());
    }

    public void displayOptions(){
        System.out.println("Select an option");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run(){
        boolean isRunning = true;
        while (isRunning) {
            displayOptions();
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.println("Enter the Deposit amount --> $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter the Withdrawal amount --> $");
                    double withdrawalAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawalAmount);
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option. ");
                    break;
            }
        }
    }

    public static void main(String args[]){
        BankAccount userAccount = new BankAccount(100000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
