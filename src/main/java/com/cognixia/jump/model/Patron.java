package com.cognixia.jump.model;


public class Patron {


    private int patronId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean accountFrozen;

    public Patron(int patronId, String fistName, String lastName, String userName, String password, boolean accountFrozen){
        this.patronId = patronId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.accountFrozen = accountFrozen;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
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

    public boolean getAccountFrozen(){
        return this.accountFrozen;
    }

    public void setAccountFrozen(boolean frozen){
        this.accountFrozen = frozen;
    }

    public int getPatronId(){
        return patronId;
    }

    public void setPatronId(int patronId){
        this.patronId = patronId;
    }
}
