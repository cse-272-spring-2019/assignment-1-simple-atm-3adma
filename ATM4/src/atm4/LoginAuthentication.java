/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

/**
 *
 * @author Yasser Hamed
 */
public class LoginAuthentication 
{
    public static boolean validate(String card,String pin)
    {
        if (card.equals(BankAccount.card)&& pin.equals(BankAccount.pin))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
