package controller;

import domain_model.Title;
import services.ResponseError;
import services.Service;

import static services.GsonToJson.json;
import static services.GsonToJson.toJson;
import static spark.Spark.*;

/**
 * Created by fatih on 3-2-2018.
 */
public class LoanController {


    public LoanController(final Service service) {
        // omdat bij title alle titels te zien zijn, heb ik besloten om voor leningen de aantal leningen de laten zien.
        // De leningen zijn al aangemaakt in loanserive bij getAll
        get("/loans", (req, res) -> service.getAll().size(), json());
    }
}
