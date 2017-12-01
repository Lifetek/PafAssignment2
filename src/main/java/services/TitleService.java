package services;

import domain_model.Title;
import org.omg.CORBA.UserException;

import java.util.Collection;

import static spark.Spark.get;

/**
 * Created by fatih on 28-11-2017.
 */
public interface TitleService {

    public void addTitle(Title title);

    public Collection<Title> getTitles();

    public Title getTitle(String name);

    public Title editTitle(Title title) throws UserException, TitleException;

    public void deleteTitle(String name);

    public boolean TitleExist(String name);

//public static void main (String[] args) {
//    get("/hello", (req, res) -> "Hello, world");
//
//    get("/hello/:name", (req,res)->{
//        return "Hello, "+ req.params(":name");
//    });
//}
}
