/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg12;

import java.util.Scanner;

/**
 *
 * @author Christopher
 * This Object holds the name, number and office of a contact. All values can be
 * changed and viewed
 */
public class Contact {
    private String name;
    private String number;
    private String office;

    public Contact(){
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter the Name");
        name = kbd.nextLine();
        System.out.println("Enter the Number");
        number = kbd.nextLine();
        System.out.println("Enter the Office");
        office = kbd.nextLine();
    }
    
    public Contact(String name, String number, String office) {
        this.name = name;
        this.number = number;
        this.office = office;
    }
    
    
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getOffice() {
        return office;
    }

    public void setName(String nameNew) {
        name = nameNew;
    }

    public void setNumber(String numberNew) {
        number = numberNew;
    }

    public void setOffice(String officeNew) {
        office = officeNew;
    }

    
    
    
    
}
