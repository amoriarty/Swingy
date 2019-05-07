package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Exceptions.NoViewDefined;
import fr.alegent.Swingy.Views.Console.GameConsoleView;
import fr.alegent.Swingy.Views.GUI.GameGUIView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class ViewFactory {
    private final Map<View.Type, Class<? extends View>> console = new HashMap<>();
    private final Map<View.Type, Class<? extends View>> gui = new HashMap<>();
    private final Mode mode;

    public enum Mode {
        CONSOLE, GUI
    }

    public ViewFactory(String mode) {
        this.mode = Mode.valueOf(mode);
        gui.put(View.Type.GAME, GameGUIView.class);
        console.put(View.Type.GAME, GameConsoleView.class);
    }

    public View make(View.Type type) throws Exception {
        val map = mode == Mode.CONSOLE ? console : gui;
        val viewClass = map.get(type);
        if (viewClass == null) throw new NoViewDefined(type, mode);

        return viewClass.getDeclaredConstructor().newInstance();
    }

}
