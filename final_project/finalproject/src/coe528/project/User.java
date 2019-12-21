/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Janeeta Zahid
 */
public abstract class User {
    public  ArrayList<File> bankfiles=new ArrayList<>();
    String password;
    String Username;
    User (String p, String u)
        {
             password=p;
             Username=u;
             
        }
   abstract boolean Login(String p,String u);
   abstract void Logout();
}
