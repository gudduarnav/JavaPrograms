/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arnav
 */
public interface IMenuEventHandler {
    public void onInit();
    public void onNewContact();
    public void onEditContactbyName();
    public void onEditContactbyPhoneNumber();
    public void onSearchbyName();
    public void onSearchbyPhoneNumber();
    public void onDeletebyName();
    public void onDeletebyPhoneNumber();
    public void onShowAll();
    public void onClearAll();
    public void onExit();
    
}
