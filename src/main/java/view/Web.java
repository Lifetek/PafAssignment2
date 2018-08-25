package view;

import controller.ControllerFactory;
import controller.iController;

import static spark.Spark.*;
import static view.GsonToJson.json;
import static view.GsonToJson.toJson;

/**
 * Created by fatih on 1-3-2018.
 */
class Web {
    private Web() {

    }

    static void CreateWebInterface() {
        TitleView(ControllerFactory.createController("Title"));
        LoanView(ControllerFactory.createController("Loan"));
    }

    private static void LoanView(final iController controller) {
        // omdat bij title alle titels te zien zijn, heb ik besloten om voor leningen de aantal leningen de laten zien.
        // De leningen zijn al aangemaakt in loanserive bij getAll
        get("/loans", (req, res) -> controller.getAll().size(), json());
    }

    private static void TitleView(final iController controller) {

        // Om alle titles te verkrijgen. Eerst moet er een POST gedaan worden voordat een title zichtbaar is.
        // Er kan ook (zoals in TitleServicee gecomment is bij getAllTitles) een ArrayList gemaakt worden zodat de titles direct te zien zijn zonder POST.
        get("/titles", (req, res) -> controller.getAll(), json());


        // Een specifieke title terugkrijgen (request) doormiddel van de ID. Als ID onjuist is dan een error message weergeven (response).
        get("/titles/:id", (req, res) -> {
            String id = req.params(":id");

            if (controller.get(id) != null) {
                return controller.get(id);
            }
            res.status(400);
            // Error message dynamic tonen door te zeggen welke ID niet gevonden is:
            return new ResponseError("No title with id '%s' found", id);
        }, json());

        // Een titel naam toevoegen. Dit kan in de app Postman door de volgende url (zie documentatie voor screenshots): http://localhost:4567/titles?name=fatih
        post("/titles", (req, res) -> controller.create(
                req.queryParams("name")
        ), json());

        // ook updaten kan door middel van postman, waarbij je eerst de juiste ID moet weten
        put("/users/:id", (req, res) -> controller.update(
                req.params(":id"),
                req.queryParams("name")
        ), json());


        //hiermee krijg je reservationlist terug aan de hand van de opgegeven ID in title. in TitleController class zijn er al reservations toegevoegd.
        get("/reservationByTitle/:id", (req, res) -> {
            String id = req.params(":id");
            if (controller.getAllReservationPerTitle(id) != null) {
                return controller.getAllReservationPerTitle(id);
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
