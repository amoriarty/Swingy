package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Views.Generics.GameView;
import fr.alegent.Swingy.Views.View;

public class GameConsoleView implements GameView {

    public void println(String text) {
        System.out.println(text);
    }

    public void addSubview(View view) { }

}
