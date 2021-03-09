/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Arnav
 */
public class ContactListResponsive extends ContactListSerializer 
        implements IMenuEventHandler{
    
    private final String filename = "contacts.csv";
    
    public ContactListResponsive()
    {
        super();
    }
    
    @Override
    public void onInit() 
    {
        try
        {
            this.fromFile(filename);
            System.out.println("Contact List loaded successfully.");
            System.out.printf("%d contacts are loaded from file %s\n", 
                    this.length(),
                    filename);

        }
        catch(Exception e)
        {
            
        }
    }

    @Override
    public void onNewContact() 
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- NEW CONTACT ---");
        System.out.print("ENTER NAME:");
        String name = in.nextLine();
        
        System.out.print("ENTER ISD CODE (+**):");
        String isdcode = in.nextLine();
        
        System.out.print("ENTER PHONE NUMBER (9-10 digits):");
        long number = in.nextLong();
        in.nextLine();
        
        this.addContact(name, isdcode, number);
        System.out.println("New Contact saved successfully");
        System.out.printf("Total %d contacts created\n", this.length());
    }

    @Override
    public void onEditContactbyName()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- EDIT CONTACT BY NAME ----");
        System.out.print("ENTER NAME:");
        String name = in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(name.toLowerCase().equals(this.getAt(index).getName().toLowerCase()))
            {
                indexFound = index;
                break;
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
        else
        {
            System.out.println("-- CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
            
            System.out.printf("Enter New ISD Code [%s]:",
                    this.getAt(indexFound).getISDCode());
            this.getAt(indexFound).setISDCode(in.nextLine());
            in.nextLine();
            
            System.out.printf("Enter New Phone Number [%d]:",
                    this.getAt(indexFound).getNumber());
            this.getAt(indexFound).setNumber(in.nextLong());
            in.nextLine();

            System.out.println("-- UPDATED CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
        }
    }

    @Override
    public void onEditContactbyPhoneNumber()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- EDIT CONTACT BY PHONE NUMBER ----");
        System.out.print("ENTER ISD Code:");
        String isdcode = in.nextLine();
        System.out.print("ENTER PHONE NUMBER:");
        Long number = in.nextLong();
        in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(isdcode.equals(this.getAt(index).getISDCode()) &&
               number.equals(this.getAt(index).getNumber()))
            {
                indexFound = index;
                break;
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
        else
        {
            System.out.println("-- CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
            
            System.out.printf("Enter New Name [%s]:",
                    this.getAt(indexFound).getName());
            this.getAt(indexFound).setName(in.nextLine());
            
             System.out.println("-- UPDATED CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
        }
    }

    @Override
    public void onSearchbyName()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- SEARCH CONTACT BY NAME ----");
        System.out.print("ENTER NAME:");
        String name = in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(name.toLowerCase().equals(this.getAt(index).getName().toLowerCase()))
            {
                indexFound = index;

                System.out.println("-- CONTACT INFO --");
                System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
                System.out.printf("PHONE NUMBER: %s %d\n", 
                        this.getAt(indexFound).getISDCode(),
                        this.getAt(indexFound).getNumber());
                System.out.println();
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
    }

    @Override
    public void onSearchbyPhoneNumber()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- SEARCH CONTACT BY PHONE NUMBER ----");
        System.out.print("ENTER ISD CODE:");
        String isd = in.nextLine();
        
        System.out.print("ENTER PHONE NUMBER:");
        Long number = in.nextLong();
        in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(isd.equals(this.getAt(index).getISDCode()) &&
               number.equals(this.getAt(index).getNumber()))
            {
                indexFound = index;

                System.out.println("-- CONTACT INFO --");
                System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
                System.out.printf("PHONE NUMBER: %s %d\n", 
                        this.getAt(indexFound).getISDCode(),
                        this.getAt(indexFound).getNumber());
                System.out.println();
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
    }

    @Override
    public void onDeletebyName()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- DELETE CONTACT BY NAME ----");
        System.out.print("ENTER NAME:");
        String name = in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(name.toLowerCase().equals(this.getAt(index).getName().toLowerCase()))
            {
                indexFound = index;
                break;
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
        else
        {
            System.out.println("-- CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
            
            System.out.print("Are you sure you want to delete [Y/N]?");
            if(in.nextLine().toLowerCase().equals("y"))
            {
                this.removeAt(indexFound);
                System.out.println("Contact Deleted successfully");
            }
            else
            {
                System.out.println("Contact NOT DELETED");
            }
            System.out.printf("Total %d contacts are present", this.length());
        }
    }

    @Override
    public void onDeletebyPhoneNumber()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("---- DELETE CONTACT BY PHONE NUMBER ----");
        System.out.print("ENTER ISD CODE:");
        String isd = in.nextLine();
        System.out.print("ENTER PHONE NUMBER:");
        Long number = in.nextLong();
        in.nextLine();
        
        int indexFound=-1;
        for(int index=0; index<this.length(); index++)
        {
            if(isd.equals(this.getAt(index).getISDCode()) &&
               number.equals(this.getAt(index).getNumber()))
            {
                indexFound = index;
                break;
            }
        }
        
        if(indexFound == -1)
        {
            System.out.println("ERROR: No such contact found");
        }
        else
        {
            System.out.println("-- CONTACT INFO --");
            System.out.printf("NAME: %s\n", this.getAt(indexFound).getName());
            System.out.printf("PHONE NUMBER: %s %d\n", 
                    this.getAt(indexFound).getISDCode(),
                    this.getAt(indexFound).getNumber());
            System.out.println();
            
            System.out.print("Are you sure you want to delete [Y/N]?");
            if(in.nextLine().toLowerCase().equals("y"))
            {
                this.removeAt(indexFound);
                System.out.println("Contact Deleted successfully");
            }
            else
            {
                System.out.println("Contact NOT DELETED");
            }
            System.out.printf("Total %d contacts are present", this.length());
        }
    }

    @Override
    public void onShowAll()
    {
        System.out.println("---- CONTACT LIST ----");
        System.out.println("Index\t\tNAME\t\tPHONE NUMBER");
        for(int index=0; index<this.length(); index++)
        {
            Contact c = this.getAt(index);
            System.out.printf("#%d\t\t%s\t\t%s %d\n", 
                    index+1,
                   c.getName(),
                   c.getISDCode(),
                   c.getNumber());
        }
        System.out.printf("Total %d contacts\n", this.length());
    }

    @Override
    public void onClearAll()
    {
        this.clear();
    }

    @Override
    public void onExit() {
        try
        {
            this.toFile(filename);
            System.out.println("Contact List saved successfully.");
            System.out.printf("%d contacts are saved to file %s\n", 
                    this.length(),
                    filename);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
