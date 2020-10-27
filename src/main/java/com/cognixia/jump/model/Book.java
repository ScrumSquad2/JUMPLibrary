package com.cognixia.jump.model;

public class Book {
    private String isbn;
    
    private String title;

    private String desc;

    private boolean rented;

    private DateTime addedToLibrary;

    public Book(String isbn, String title, String desc, boolean rented, DateTime addedToLibrary){
        this.isbn = isbn;

        this.title = title;

        this.desc = desc;

        this.rented = rented;

        this.addedToLibrary = addedToLibrary;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public boolean getRented(){
        return this.rented;
    }

    public void setRented(boolean rented){
        this.rented = rented;
    }

    public DateTime getAddedToLibrary(){
        return this.addedToLibrary;
    }


    public void setAddedToLibrary(DateTime addedToLibrary){
        this.addedToLibrary = addedToLibrary;
    }


}
