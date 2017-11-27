package domain_model;

import java.util.Date;

/**
 * Created by fatih on 27-11-2017.
 */
public class Reservation {

    private int id;
    private Date date;
    private Title title;
    private Borrower_Information borrower_information;

    public Reservation() {
    }

    public Reservation(Date d) {
        this.date = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Borrower_Information getBorrower_information() {
        return borrower_information;
    }

    public void setBorrower_information(Borrower_Information borrower_information) {
        this.borrower_information = borrower_information;
    }

    public void find(){
    }
}
