package librarysytemproject;

/**
 * Elia Schwartz
 * September 14, 2025.
 * CEN 3024C - 14877 Software Development 1
 * Patron.java
 * This class is a representation of a Patron in library
 */
public class Patron {
    private String idNumber;
    private String name;
    private String address;
    private double fines;
    private int booksCheckedOut;

    public Patron(){
        this.idNumber = null;
        this.name = null;
        this.address = null;
        this.fines = 0.00;
        //this.booksCheckedOut = 0;
    }

    public Patron(String idNumber, String name, String address, double fines, int booksCheckedOut){
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.fines = fines;
        this.booksCheckedOut = booksCheckedOut;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public double getFines(){
        return fines;
    }

    public int getBooksCheckedOut(){
        return booksCheckedOut;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setFines(double fines){
        this.fines = fines;
    }

     public void setBooksCheckedOut(int booksCheckedOut){
       this.booksCheckedOut = booksCheckedOut;
    }


    /**
     * Method: toString
     * Parameters: None
     * @return String
     * Purpose: Display content information
     */
    @Override
    public String toString(){
        return "Patron{ "+ getIdNumber() + "-" + getName() + "-" + getAddress() + "-" + getFines();
    }


}
