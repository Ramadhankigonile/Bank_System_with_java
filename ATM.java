/**
 * ATM interface
 */

public interface ATM {

    void showMenu();
    void deposit(int amount);
    void withdraw(int amount);
    void getPreviousTransactions();

    
} 