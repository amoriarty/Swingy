package fr.alegent.Swingy;

import fr.alegent.Swingy.Controllers.GameController;
import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import lombok.val;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            return;
        }

        try {
            val mode = args[0].toUpperCase();
            val game = new GameController(mode);
            game.start();
        } catch (InvalidGameMode exception) {
            System.err.println(exception.toString());
            usage();
        } catch (Exception exception) {
            System.err.println(exception.toString());
            exception.printStackTrace();
        }
    }

    private static void usage() {
        System.out.println("Swingy: usage: java -jar target/Swingy-1.0.0.jar [mode]");
        System.out.println("Swingy: mode: gui - launch game into a graphical interface.");
        System.out.println("Swingy: mode: console - launch game into console, for hardcore hipsters.");
    }

}
