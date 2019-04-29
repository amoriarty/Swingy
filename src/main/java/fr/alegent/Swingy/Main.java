package fr.alegent.Swingy;

import fr.alegent.Swingy.Controllers.GameController;
import fr.alegent.Swingy.Interfaces.WindowInterface;
import fr.alegent.Swingy.Factories.WindowFactory;
import lombok.val;

public class Main {

    /**
     * Check if arguments is passed and valid.
     * @param args Programs parameters.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            return;
        }

        try {
            val window = WindowFactory.make(args[0]);
            launch(window);
        } catch (Exception exception) {
            System.err.println("Swingy: error: invalid game mode.");
            usage();
        }
    }

    /**
     * Launch window, create game instance and provide game main loop.
     * @param window Window interface previously created.
     */
    private static void launch(WindowInterface window) {
        try {
            val game = new GameController();
            window.launch();
        } catch (Exception exception) {
            System.err.println("Swingy: error: an error occurred during game. Application will close now.");
        }
    }

    /**
     * Print program usage if arguments are invalid.
     */
    private static void usage() {
        System.out.println("Swingy: usage: java -jar swingy.jar [mode]");
        System.out.println("Swingy: mode: gui - launch game into a graphical interface.");
        System.out.println("Swingy: mode: console - launch game into console, for hardcore hipsters.");
    }

}
