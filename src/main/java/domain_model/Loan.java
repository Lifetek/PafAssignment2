package domain_model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by fatih on 27-11-2017.
 */
public class Loan {

    private String id;
    private Date date;
    private Item item;
    private Borrower_Information borrower_information;

    public Loan(Date d) {
        this.id = UUID.randomUUID().toString();
        this.date = d;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void createLoan() {
    }
}
