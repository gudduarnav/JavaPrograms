
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 * Load and Save contact from File
 * @author Arnav
 */


public class ContactSerializer extends Contact {
    
    public ContactSerializer(){
        super();
    }
 
    public ContactSerializer(String _name, String isd, Long phone){
        super(_name, isd, phone);  
   }
       
    public String SaveToString()
    {
        return String.format("%s, %s, %d", 
                this.getName(),
                this.getISDCode(),
                this.getNumber());
    }
    
    public Boolean LoadFromString(String csv) {
        String[] tokens = csv.split(",");
        if(tokens.length >= 3)
        {
            String tok1 = tokens[0].trim(); // String
            String tok2 = tokens[1].trim(); // String
            String tok3 = tokens[2].trim(); // Long
            
            if(tok1.length() < 1)
            {
                return false; // Name cannot be blank
            }
            
            if(tok2.length()<2)
            {
                return false; // ISD code cannot be blank
            }
            
            if(tok3.length()<9)
            {
                return false; // Phone Number is atleast 9 characters
            }
            
            if(tok2.charAt(0) != '+')
            {
                return false;  // ISD code starts with 1 + sign always
            }
            
            Long num= 0L;
            try
            {
                num = Long.parseLong(tok3);
            }
            catch(NumberFormatException e)
            {
                return false;
            }
            
            // Save the correct data to this Contact
            this.setName(tok1);
            this.setISDCode(tok2);
            this.setNumber(num);
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public void SaveToStream(BufferedWriter out) throws IOException {
        String s = this.SaveToString();
        if(s.length()>5 && out!=null)
        {
            out.write(s);
            out.write("\n");
        }
    }
    
    public Boolean LoadFromStream(BufferedReader in) throws IOException {
        if(in.ready())
        {
            String s = in.readLine();
            return this.LoadFromString(s);
        
        }
        return false;
    }
}
