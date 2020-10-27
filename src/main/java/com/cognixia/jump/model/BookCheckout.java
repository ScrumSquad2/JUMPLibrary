package com.cognixia.jump.model;


public class BookCheckout {

    private int patronId;

    private String isbn;

    private DateTime checkoutDate;

    private DateTime dueDate;

    private DateTime returnedDate;

    public BookCheckout(int patronId, String isbn, DateTime checkoutDate, DateTime dueDate, DateTime returnedDate){
        this.patronId = patronId;

        this.isbn = isbn;

        this.checkoutDate = checkoutDate;

        this.dueDate = dueDate;

        this.returnedDate = returnedDate;
    }

    public int getPatronId(){
        return this.pagtronId;
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

    public DateTime getCheckoutDate(){
        return this.checkoutDate;
    }

    public void setCheckoutDate(DateTime checkoutDate){
        this.checkoutDate = checkoutDate;
    }

    public DateTime getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(DateTime dueDate){
        this.dueDate = dueDate;
    }

    public DateTime getReturnedDate(){
        return this.returnedDate;
    }

    public void setReturnedDate(DateTime returnedDate){
        this.returnedDate = returnedDate;
    }

}
