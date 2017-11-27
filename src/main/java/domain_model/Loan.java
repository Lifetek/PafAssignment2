package domain_model;

import java.util.Date;

/**
 * Created by fatih on 27-11-2017.
 */
public class Loan {

    private int id;
    private Date date;
    private Item item;
    private Borrower_Information borrower_information;

    public Loan(){
    }

    public Loan(Date d){
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Borrower_Information getBorrower_information() {
        return borrower_information;
    }

    public void setBorrower_information(Borrower_Information borrower_information) {
        this.borrower_information = borrower_information;
    }

    public void createLoan(){
    }
}
