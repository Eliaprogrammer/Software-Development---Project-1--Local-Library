package librarysytemproject;

/**
 * Elia Schwartz
 * September 14, 2025.
 * CEN 3024C - 14877 Software Development 1
 * FineCalculation.java
 * This class determines how the overdue fines are calculation for each library member
 */

public class FineCalculations {
    private double totalFines; //Total cost of fines
    private int numLateBooks; //Number of books currently late
    private double finesPerDay; //set cost of days a book is late
    private double returnFee; // a single cost per book returned back
    private int daysLeft; //count down until it reaches 30 days
    private int daysBookLate; //Number of days late after 30 days
    private String dateOfCheckedOut;
    double totalFinePerDay; //Total cost of fines per day late

    public FineCalculations(double totalFines, int numLateBooks, double finesPerDay, double returnFee) {
        this.totalFines = totalFines;
        this.numLateBooks = numLateBooks;
        this.finesPerDay = finesPerDay;
        this.returnFee = returnFee;
    }
    public FineCalculations(){
        this.totalFines = 0;
        this.numLateBooks = 0;
        this.finesPerDay = 0.50;
        this.returnFee = 5.12;
    }

    public double getTotalFines(){
        return totalFines;
    }

    public void setTotalFines(double totalFines){
        this.totalFines = totalFines;
    }

    public int getNumLateBooks(){
        return numLateBooks;
    }

    public void setNumLateBooks(int numLateBooks){
        this.numLateBooks = numLateBooks;
    }

    public double getFinesPerDay(){
        return finesPerDay;
    }

    public void setFinesPerDay(double finesPerDay) {
        this.finesPerDay = finesPerDay;
    }

    public double getReturnFee(){
        return returnFee;
    }

    public void setReturnFee(double returnFee){
        this.returnFee = returnFee;
    }

    public int getDaysLeft(){
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft){
        this.daysLeft = daysLeft;
    }

    public int getDaysBookLate(){
        return daysBookLate;
    }

    public void setDaysBookLate(int daysBookLate){
        this.daysBookLate = daysBookLate;
    }

    public String getDateOfCheckedOut(){
        return dateOfCheckedOut;
    }
    public void setDateOfCheckedOut(String dateOfCheckedOut){
        this.dateOfCheckedOut = dateOfCheckedOut;
    }

    /**
     * Method: calTotalFinesPerDay
     * @param daysBookLate
     * @return double
     * purpose: return the calculated amount of overdue fines per day
     */
    public double calTotalFinesPerDay(int daysBookLate){
        calDaysLeft();
        totalFinePerDay = finesPerDay * daysBookLate;
        return totalFinePerDay;
    }

    /**
     * Method: calTotalFines
     * parameter: None
     * @return Total cost of overdue fines a patron must pay
     * Final calculation of overdue fines
     */

    public double calTotalFines(){
        setReturnFee(5.12);
        //0 = (0.50 * 5) + 5.12
        //totalFines = 7.62
        //For each book that is not return
        return totalFines = totalFinePerDay + returnFee;

    }

    /**
     * Method: calDaysLeft
     * parameter: None
     * @return the number of days a book is late to return
     * Determine how many days a patron has before fines accrued.
     */
    public double calDaysLeft(){
        //Day of check out, has 30 days to read and return book
        setDaysLeft(30);
        //Once the 30-day countdown is 0
        while(daysLeft > 0){
            daysLeft--;
            totalFinePerDay = 0;
        }
        // When the 30 days is over and reaches 0
        if(daysLeft == 0){
            //While the number of late books is greater than 0
            while(numLateBooks > 0){
                //The number of days a book is late increases
                daysBookLate++;
            }
        }
        return daysLeft;
    }

}
