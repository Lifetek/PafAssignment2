package domain_model;

import domain_model.Item;
import domain_model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by fatih on 27-11-2017.
 */
public class Title {

    private String id;
    private String name;
    private List<Item> itemList = new ArrayList<Item>();
    private List<Reservation> reservationList = new ArrayList<Reservation>();


    public Title() {
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
}