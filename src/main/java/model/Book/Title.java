package model.Book;

import model.Loan.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by fatih on 27-11-2017.
 */
public class Title {
    protected String id;
    protected String name;
    protected List<Item> itemList = new ArrayList<>();
    protected List<Reservation> reservationList = new ArrayList<>();


    Title() {
    }

    public Title(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", reservationList=" + reservationList +
                '}';
    }
}