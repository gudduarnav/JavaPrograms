/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 * Loads or Save the Contact list to file
 * @author Arnav
 */
public class ContactListSerializer extends ContactList {
    public ContactListSerializer()
    {
        super();
    }
    
    public void save(BufferedWriter out) throws IOException
    {
        for(int index=0; index<this.length(); index++)
        {
            this.getAtasSerializer(index).SaveToStream(out);           
        }
    }
    
    public void load(BufferedReader in) throws IOException
    {
        while(true)
        {
            ContactSerializer cl = new ContactSerializer();
            if(!cl.LoadFromStream(in))
                return;
            
            this.addContact(cl);
        }
    }
    
    public void toFile(String filename) throws IOException
    {
        try(BufferedWriter out = new BufferedWriter( new FileWriter(filename)))
        {
            this.save(out);
        }
    }
    
    public void fromFile(String filename) throws IOException
    {
        try(BufferedReader in = new BufferedReader(new FileReader(filename)))
        {
            this.load(in);
        }
    }
}
