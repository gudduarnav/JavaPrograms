/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Arnav
 */
public class Menu {
  final IMenuEventHandler h;
  public Menu()
  {
      h = new ContactListResponsive();
      h.onInit();
  }
  
  // Display the menu
  public Boolean display()
  {
      System.out.println("----- MENU ----");
      System.out.println("1 - Create New Contact");
      System.out.println("2 - Edit Contact by Name");
      System.out.println("3 - Edit Contact by Phone Number");
      System.out.println("4 - Search Contact by Name");
      System.out.println("5 - Search Contact by Phone Number");
      System.out.println("6 - Delete Contact by Name");
      System.out.println("7 - Delete Contact by Phone Number");
      System.out.println("8 - Show all Contacts");
      System.out.println("9 - Clear all Contacts");
      System.out.println("0 - Exit");
      
      return this.handleChoice(this.getChoice());
  }
  
  // get the Choice
  private int getChoice()
  {
      System.out.print("ENTER CHOICE: ");
      Scanner in = new Scanner(System.in);
      
      try
      {
        int choice = in.nextInt();
        in.nextLine();
        return choice;
      }
      catch(Exception e)
      {
      }
      
      return -1;     
  }
  
  // handle the choice
  private Boolean handleChoice(int choice)
  {
      switch(choice)
      {
          case 1:
              h.onNewContact();
              return true;
          case 2:
              h.onEditContactbyName();
              return true;
          case 3:
              h.onEditContactbyPhoneNumber();
              return true;
          case 4:
              h.onSearchbyName();
              return true;
          case 5:
              h.onSearchbyPhoneNumber();
              return true;
          case 6:
              h.onDeletebyName();
              return true;
          case 7:
              h.onDeletebyPhoneNumber();
              return true;
          case 8:
              h.onShowAll();
              return true;
          case 9:
              h.onClearAll();
              return true;
          case 0:
              h.onExit();
              return false;
          default:
              return true;
      }
  }
}
