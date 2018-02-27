package services;

import domain_model.Reservation;
import domain_model.Title;

import java.util.*;

/**
 * Created by fatih on 3-2-2018.
 */
public class TitleService implements Service<Title> {

    //HashMap om key(String)/value(Title) op te slaan
    private Map<String, Title> titles = new HashMap<>();


    public void failIfInvalid(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'name' cannot be empty");
        }
    }

    //alle titles krijgen (moet wel eerst post of zoals hieronder in comment weergegeven arraylist gemaakt worden)
    @Override
    public List<Title> getAll() {
        return new ArrayList<>(titles.values());
    }

    //specifieke titel krijgen door ID mee te geven
    @Override
    public Title get(String id) {
        return titles.get(id);
    }

    //een titel updaten door eerst ID mee te geven
    @Override
    public Title update(String id, String name) {
        Title title = titles.get(id);
        if (title == null) {
            throw new IllegalArgumentException("No title with id '" + id + "' found");
        }
        failIfInvalid(name);
        title.setName(name);
        return title;
    }

    //per titel een reservation. reservations zijn helemaal onderaan bij create al toegevoegd. na een titel te maken moet dus de ID van die titel gepakt worden.
    public List<Reservation> getAllReservationPerTitle(String titleId) {
        List<Reservation> reservationList = new ArrayList<>();

        for (Title title : titles.values()) {
            if (title.getId().equals(titleId)) {
                if (!title.getReservationList().isEmpty()) {
                    return reservationList;
                }
            }
        }
        return null;
    }

    //bij het maken van de titel worden dus ook de reservations aangemaakt.
    @Override
    public Title create(String namee) {
        failIfInvalid(namee);
        Title title = new Title(namee);

        Reservation reservation1 = new Reservation(new Date());
        Reservation reservation2 = new Reservation(new Date());
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation1);
        reservationList.add(reservation2);
        title.setReservationList(reservationList);

        titles.put(title.getId(), title);
        return title;
    }
}
