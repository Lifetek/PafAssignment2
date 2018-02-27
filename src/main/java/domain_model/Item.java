package domain_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatih on 27-11-2017.
 */
public class Item {

    private int id;
    private List<Loan> loanList = new ArrayList<Loan>();
    private Title title;


    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void findOnTitle(){
    }

    public void findOnId(){
    }

    public void findOnReservation(){
    }
}
