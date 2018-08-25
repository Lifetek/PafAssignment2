package controller;

/**
 * Created by fatih on 1-3-2018.
 * <p>
 * FactoryPattern
 */
public class ControllerFactory {

    private ControllerFactory() {
        // constructor verbergen static class
    }

    // input = "Loan" of "Title"
    public static iController createController(String name) {
        iController controller;
        try {
            // de eerste letter van de code hoofdletter maken
            String newName = "controller." + name + "Controller";
            // nieuwe object aanmaken
            controller = (iController) Class.forName(newName).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }

        return controller;
    }
}
