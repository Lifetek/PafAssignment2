package controller;

import model.Loan.Reservation;

import java.util.List;

/**
 * Created by fatih on 3-2-2018.
 */

//in interface gebruik gemaakt van generics.
public interface iController<T> {
    List<T> getAll();

    T get(String id);

    T update(String id, String string);

    T create(String text);

    void failIfInvalid(String name);

    List<Reservation> getAllReservationPerTitle(String titleId);
}
