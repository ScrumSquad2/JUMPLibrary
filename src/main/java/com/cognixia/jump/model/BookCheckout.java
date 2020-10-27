package com.cognixia.jump.model;

import java.sql.Date;

public class BookCheckout {

    private int patronId;

    private String isbn;

    private Date checkoutDate;

    private Date dueDate;

    private Date returnedDate;

    public BookCheckout(int patronId, String isbn, Date checkoutDate, Date dueDate, Date returnedDate){
        this.patronId = patronId;

        this.isbn = isbn;

        this.checkoutDate = checkoutDate;

        this.dueDate = dueDate;

        this.returnedDate = returnedDate;
    }

    public int getPatronId(){
        return this.patronId;
    }

    public void setPatronId(int patronId){
        this.patronId = patronId;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public Date getCheckoutDate(){
        return this.checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate){
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    public Date getReturnedDate(){
        return this.returnedDate;
    }

    public void setReturnedDate(Date returnedDate){
        this.returnedDate = returnedDate;
    }

}
