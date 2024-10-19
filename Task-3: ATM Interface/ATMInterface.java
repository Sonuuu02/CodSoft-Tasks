import java.sql.SQLOutput;
import java.util.Scanner;

class BankAccount {

    String name;
    String username;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Your Name: ");
        this.name = scanner.nextLine();
        System.out.println("\nEnter Your Username: ");
        this.username = scanner.nextLine();
        System.out.println("\nEnter Your Password: ");
        this.password = scanner.nextLine();
        System.out.println("\nEnter Your Account Number: ");
        this.accountNo = scanner.nextLine();
        System.out.println("\nRegistration Successful! Please Log in your Bank Account.");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner scanner = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("\nEnter Your Username: ");
            String Username = scanner.nextLine();
            if (Username.equals(username)) {
                while (!isLogin) {
                    System.out.println("\nEnter Your Password: ");
                    String Password = scanner.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin Successful!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUser not found!");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("\nEnter Amount to Withdraw: ");
        Scanner scanner = new Scanner(System.in);
        Float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdral Successful!");
                String str = amount + "Rs Withdrawn.\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    public void deposit() {
        System.out.println("\nEnter Amount to Deposit: ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        try {
            if (amount <= 10000f) {
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Successful!!");
                String str = amount + "Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry!! The limit is 10000.");
            }
        } catch (Exception e) {
        }
    }

    public void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name: ");
        String receipent = scanner.nextLine();
        System.out.println("\nEnter Amount to transfer: ");
        float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + receipent);
                    String string = amount + "Rs Transferred to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(string);
                } else {
                    System.out.println("\nSorry! The limit is 50000.");
                }
            } else {
                System.out.println("\nInsufficient Balance!");
            }
        } catch (Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + "Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No Transactions Happened");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class ATMInterface {

    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter Only Integer Value.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("|<*** WELCOME TO THE PEOPLE'S BANK ***>|");
        System.out.println("\n1. Register \n2. Exit!");
        System.out.println("Choose One Option: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.register();
            while (true) {
                System.out.println("|<** WELCOME BACK **>|");
                System.out.println("\n1. Login \n2.Exit!");
                System.out.println("Choose One Option: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if (bankAccount.login()) {
                        System.out.println("|<** WELCOME BACK " + bankAccount.name + " **>|");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5.Transaction History \n6.Exit!");
                            System.out.println("Enter Your Choice: ");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;

                                case 2:
                                    bankAccount.deposit();
                                    break;

                                case 3:
                                    bankAccount.transfer();
                                    break;

                                case 4:
                                    bankAccount.checkBalance();
                                    break;

                                case 5:
                                    bankAccount.transHistory();
                                    break;

                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
