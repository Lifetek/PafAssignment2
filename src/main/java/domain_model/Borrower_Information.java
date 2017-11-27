package domain_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatih on 27-11-2017.
 */
public class Borrower_Information {

    private int id;
    private String name;
    private String address;
    private List<Loan> loanList = new ArrayList<Loan>();
    private List<Reservation> reservationList = new ArrayList<Reservation>();

    public Borrower_Information() {
    }

    public Borrower_Information(String n, String a) {
        this.name = n;
        this.address = a;
        //reservationList = new ArrayList<Reservation>();            is al bovenin als arraylist gezet.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void find(){
    }
}
