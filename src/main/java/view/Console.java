package view;

import controller.iController;

import java.util.List;

/**
 * Created by fatih on 1-3-2018.
 */
class Console {
    private iController controller;

    Console(iController controller) {
        this.controller = controller;
    }

    void showAllItems() {
        List allItems = controller.getAll();
        for (Object o : allItems) {
            System.out.println(o);
        }
    }

}
