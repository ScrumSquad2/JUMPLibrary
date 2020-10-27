package com.cognixia.jump.model;

public class Librarian {

    private ind librarianId;

    private String userName;

    private String password;

    public Librarian(ind librarianId, String userName, String password){
        this.librarianId = librarianId;

        this.userName = userName;
        
        this.password = password;

    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getLibrarianId(){
        return this.librarianId;
    }

    public void setLibrarianId(int librarianId){
      this.librarianId = librarianId;

}
