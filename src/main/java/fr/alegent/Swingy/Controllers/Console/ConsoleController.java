package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.WindowControllerInterface;
import fr.alegent.Swingy.Interfaces.WindowInterface;

import java.util.Scanner;

/**
 * Interface to console based game.
 * In order to simplified the all process, console will be considered as window in this all project.
 */
public class ConsoleController implements WindowInterface {
    private Scanner scanner = new Scanner(System.in);

    public void launch() {
        System.out.println("Swingy - Console Version");
    }

    public void setController(WindowControllerInterface controller) {
        System.out.println(controller.getTitle());
    }

    /**
     * Get next line from STDIN.
     * @return Next line.
     */
    String getInput() {
        return scanner.nextLine();
    }

}
