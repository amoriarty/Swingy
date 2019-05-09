package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Views.GameView;
import fr.alegent.Swingy.Views.View;

public class GameConsoleView extends ConsoleView implements GameView {

    public void println(String text) {
        System.out.println(text);
    }

    public void addSubview(View view) { }

    public void setController(Controller controller) { }

}
