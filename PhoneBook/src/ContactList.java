/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * Container for all contacts
 * @author Arnav
 */
public class ContactList {
    final private List<ContactSerializer> contacts;
    
    public ContactList() {
        contacts = new ArrayList<>(); // Java 7 or above
    }
    
    // add a new contact
    public void addContact(String name, String isd, Long phone)
    {
        ContactSerializer p = new ContactSerializer(name, isd, phone);
        contacts.add(p);
    }
    
    protected void addContact(ContactSerializer c)
    {
        contacts.add(c);
    }
    
    // return number of items
    public int length()
    {
        return contacts.size();
    }
    
    // return the Contact at particular location
    public Contact getAt(int index)
    {
        return contacts.get(index);
    }
    
    protected ContactSerializer getAtasSerializer(int index)
    {
        return contacts.get(index);
    }
    
    // deletes an entry
    public void removeAt(int index)
    {
        contacts.remove(index);
    }
    
    // clear all
    public void clear()
    {
        contacts.clear();
    }
    
    
}
