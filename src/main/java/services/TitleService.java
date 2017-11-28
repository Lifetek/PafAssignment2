package services;

import static spark.Spark.get;

/**
 * Created by fatih on 28-11-2017.
 */
public class TitleService {

public static void main (String[] args) {
    get("/hello", (req, res) -> "Hello, world");

    get("/hello/:name", (req,res)->{
        return "Hello, "+ req.params(":name");
    });

}
}
