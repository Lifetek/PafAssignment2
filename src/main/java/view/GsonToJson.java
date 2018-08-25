package view;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by fatih on 3-2-2018.
 * <p>
 * Singleton class
 */
class GsonToJson {
    private static Gson gson = null;

    //Deze class is gemaakt zodat er niet elke keer new Gson toJson gedaan hoeft te worden. (gebruiksgemak)

    private GsonToJson() {
    }

    static String toJson(Object object) {
        if (gson == null) {
            gson = new Gson();
        }
        return gson.toJson(object);
    }

    static ResponseTransformer json() {
        return GsonToJson::toJson;
    }
}
