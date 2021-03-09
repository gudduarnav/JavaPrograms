/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Personal details for the Contact is stored here
 * @author Arnav
 */
public class Contact {
    private String name; // Name of person
    private String isdcode; // ISD Code: +63 ...
    private Long number; // Phone Number: a the number part only
    
    public Contact() {
        name = "";
        isdcode = "";
        number = 0L;
    }
    
    public Contact(String _name, String isd, Long phone){
        name = _name;
        isdcode = isd;
        number = phone;       
   }
    
    // Getter properties
    public String getName() {
        return this.name;
    }
    
    public String getISDCode() {
        return this.isdcode;
    }
    
    public Long getNumber() {
        return this.number;
    }
    
    
    // Setter properties
    public void setName(String v) {
        this.name = v;
    }
    
    public void setISDCode(String v){
        this.isdcode = v;
    }
    
    public void setNumber(Long v) {
        this.number = v;
    }
}
