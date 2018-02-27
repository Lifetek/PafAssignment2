package services;

import domain_model.Loan;
import domain_model.Reservation;
import domain_model.Title;

import java.util.*;

/**
 * Created by fatih on 3-2-2018.
 */
public class LoanService implements Service<Loan> {

    //HashMap om key(String)/value(Title) op te slaan
    private Map<String, Title> loans = new HashMap<>();


    //hier heb ik al leningen aangemaakt.
    @Override
    public List<Loan> getAll() {
        List<Loan> allLoans = new ArrayList<Loan>();
        allLoans.add(new Loan(new Date()));
        allLoans.add(new Loan(new Date()));
        allLoans.add(new Loan(new Date()));
        allLoans.add(new Loan(new Date()));
        return allLoans;
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