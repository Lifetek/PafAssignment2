package services;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by fatih on 3-2-2018.
 */
public class GsonToJson {

    //Deze class is gemaakt zodat er niet elke keer new Gson toJson gedaan hoeft te worden. (gebruiksgemak)

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return GsonToJson::toJson;
    }
}
