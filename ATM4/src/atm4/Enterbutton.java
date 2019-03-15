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
public class Enterbutton
{
    public Enterbutton()
    {
        
    }
    public static boolean enterbuttonn(int amount,int balance)
    {
        boolean available;
        if(amount>balance)
        {
            available = false;
            
        }
        else 
        {
            available = true;
            //balance = balance - amount;
        }
        return available;
    }
}
