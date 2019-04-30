package fr.alegent.Swingy;

import fr.alegent.Swingy.Controllers.GameController;
import fr.alegent.Swingy.Models.WindowMode;
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
            val mode = WindowMode.valueOf(args[0].toUpperCase());

            try {
                val game = new GameController(mode);
                game.start();
            } catch (Exception exception) {
                System.err.println("Swingy: error: an error occurred during game. Application will close now.");
            }

        } catch (Exception exception) {
            System.err.println("Swingy: error: invalid game mode.");
            usage();
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
