package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.List;
import java.util.Scanner;

abstract class ConsoleView implements View {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    String prompt(String message) {
        if (message != null) System.out.println(message);

        val scanner = new Scanner(System.in);
        val line = scanner.nextLine();
        if (!line.isEmpty()) return line;

        System.err.println("Swingy: error: your input is empty.");
        return prompt(message);
    }

    <T> T choose(String message, T[] choices) {
        if (message != null) System.out.println(message);

        for (int i = 0; i < choices.length; i++) {
            val value = choices[i];
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
            return choose(message, choices);
        }
    }

}
