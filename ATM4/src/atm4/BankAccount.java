/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

public class BankAccount 
{
    final static String pin = "0000";
    final static String card = "1234";
    String[] history;
    static int balance ; int i;
    BankAccount user;
    public BankAccount()
    {
        
        i=0;
    }
    public void Withdraw()
    {
        
    }
    public int Deposit(int amount)
    {
        balance = balance + amount;
        history[i] = "Deposit"+amount;
        return balance;
    }
}
