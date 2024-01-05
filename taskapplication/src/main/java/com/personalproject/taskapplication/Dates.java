package taskapplication.src.main.java.com.personalproject.taskapplication;

import java.time.LocalDate;

class DatesClass {
    private LocalDate dateLocalDate;
    
    public DatesClass() {
        this.dateLocalDate = java.time.LocalDate.now();
    }

    public LocalDate getDateLocalDate() {
        return this.dateLocalDate;
    }

}


public class Dates {
public static void main(String[] args) {
    DatesClass dater = new DatesClass();

    System.out.println(dater.getDateLocalDate());
}}