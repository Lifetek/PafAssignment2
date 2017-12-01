package services;

import com.google.gson.Gson;
import domain_model.Title;

import static spark.Spark.post;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.options;



/**
 * Created by fatih on 1-12-2017.
 */
public class SparkRest {
    public static void main(String[] args) {

        final TitleService titleService = new TitleServiceMap();

        post("/titles", (request, response) -> {
            response.type("application/json");

            Title title  = new Gson().fromJson(request.body(), Title.class);
            titleService.addTitle(title);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));

        });
        get("/titles", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(titleService.getTitles())));
        });
        get("/titles/:name", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(titleService.getTitle(request.params(":name")))));
        });
        put("/titles/:name", (request, response) -> {
            response.type("application/json");

            Title toEdit = new Gson().fromJson(request.body(), Title.class);
            Title editedTitle = titleService.editTitle(toEdit);

            if (editedTitle != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedTitle)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Title not found or error in edit")));
            }
        });
        delete("/titles/:name", (request, response) -> {
            response.type("application/json");

            titleService.deleteTitle(request.params(":name"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "name deleted"));
        });
        options("/titles/:name", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (titleService.TitleExist(request.params(":name"))) ? "Title exists" : "Title does not exists"));
        });
    }
}
