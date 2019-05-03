package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;
import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Interfaces.WindowInterface;
import lombok.val;

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

    public void setController(ControllerInterface controller) {
        val title = controller.getTitle();
        System.out.println();
        if (title == null) return;
        System.out.println(controller.getTitle());
    }

    /**
     * Get next line from STDIN.
     * @return Next line.
     */
    String prompt(String message) {
        if (message != null) System.out.println(message);

        val line = scanner.nextLine();
        if (!line.isEmpty()) return line;

        System.err.println("Swingy: error: your input is empty.");
        return prompt(message);
    }

    /**
     * Get a value from a list of choices. Need to be cast from ChoiceInterface.
     * @param choices List of choices proposed to the user
     * @return Value choose form the list of choices.
     */
    ChoiceInterface promptChoice(String message, ChoiceInterface[] choices) {
        if (message != null) System.out.println(message);

        for (int i = 0; i < choices.length; i++) {
            val choice = choices[i];
            val value = choice.asChoice();
            val formatted = String.format("(%d) %s", i, value);
            System.out.println(formatted);
        }

        try {
            val input = prompt(null);
            val index = Integer.parseInt(input);
            if (index < 0 || index > choices.length) {
                throw new Exception();
            }

            return choices[index];
        } catch (Exception exception) {
            System.err.println("Swingy: error: your input is invalid.");
            return promptChoice(message, choices);
        }
    }
}
