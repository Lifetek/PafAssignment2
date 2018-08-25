package view;

import controller.ControllerFactory;

/**
 * Created by fatih on 3-2-2018.
 */
//de main geeft aan welke view welke service gebruikt
public class Main {
    public static void main(String[] args) {
        // Grafische representatie 1
        Console c = new Console(ControllerFactory.createController("Title"));
        c.showAllItems();

        // Grafische representatie 2
        Web.CreateWebInterface();
    }


}
