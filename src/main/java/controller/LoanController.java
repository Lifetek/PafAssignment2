package controller;

import model.Loan.Loan;
import model.Loan.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fatih on 3-2-2018.
 */
class LoanController implements iController<Loan> {

    //HashMap om key(String)/value(Title) op te slaan
    private List<Loan> loans = new ArrayList<>();

    LoanController() {
        loans.add(new Loan(new Date()));
        loans.add(new Loan(new Date()));
        loans.add(new Loan(new Date()));
        loans.add(new Loan(new Date()));
    }

    //hier heb ik al leningen aangemaakt.
    @Override
    public List<Loan> getAll() {
        return loans;
    }


    //omdat de functies hieronder al in title beschikbaar zijn heb ik ze niet voor leningen gemaakt.
    @Override
    public Loan get(String id) {
        return null;
    }

    @Override
    public Loan update(String id, String string) {
        return null;
    }

    @Override
    public Loan create(String text) {
        return null;
    }

    @Override
    public void failIfInvalid(String name) {

    }

    @Override
    public List<Reservation> getAllReservationPerTitle(String titleId) {
        return null;
    }
}