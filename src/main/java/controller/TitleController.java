package controller;

import domain_model.Reservation;
import domain_model.Title;
import services.ResponseError;
import services.Service;

import java.util.List;

import static services.GsonToJson.json;
import static services.GsonToJson.toJson;
import static spark.Spark.*;

/**
 * Created by fatih on 3-2-2018.
 */
public class TitleController {


    public TitleController(final Service service) {

        // Om alle titles te verkrijgen. Eerst moet er een POST gedaan worden voordat een title zichtbaar is.
        // Er kan ook (zoals in TitleServicee gecomment is bij getAllTitles) een ArrayList gemaakt worden zodat de titles direct te zien zijn zonder POST.
        get("/titles", (req, res) -> service.getAll(), json());


        // Een specifieke title terugkrijgen (request) doormiddel van de ID. Als ID onjuist is dan een error message weergeven (response).
        get("/titles/:id", (req, res) -> {
            String id = req.params(":id");
            Title title = (Title) service.get(id);
            if (title != null) {
                return title;
            }
            res.status(400);
            // Error message dynamic tonen door te zeggen welke ID niet gevonden is:
            return new ResponseError("No title with id '%s' found", id);
        }, json());

        // Een titel naam toevoegen. Dit kan in de app Postman door de volgende url (zie documentatie voor screenshots): http://localhost:4567/titles?name=fatih
        post("/titles", (req, res) -> service.create(
                req.queryParams("name")
        ), json());

        // ook updaten kan door middel van postman, waarbij je eerst de juiste ID moet weten
        put("/users/:id", (req, res) -> service.update(
                req.params(":id"),
                req.queryParams("name")
        ), json());


        //hiermee krijg je reservationlist terug aan de hand van de opgegeven ID in title. in TitleService class zijn er al reservations toegevoegd.
        //doordat dit met title te maken heeft, heb ik het in de titlecontroller class gezet.
        get("/reservationByTitle/:id", (req, res) -> {
            String id = req.params(":id");
            List<Reservation> listOfReservations = service.getAllReservationPerTitle(id);
            if (listOfReservations != null) {
                return listOfReservations;
            }
            res.status(400);
            // Error message dynamic tonen door te zeggen welke ID niet gevonden is:
            return new ResponseError("No reservations with id '%s' found", id);
        }, json());

        //content type
        after((req, res) -> {
            res.type("application/json");
        });

        //exception
        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(toJson(new ResponseError(e)));
        });
    }
}
