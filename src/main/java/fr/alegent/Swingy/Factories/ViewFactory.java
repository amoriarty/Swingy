package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Exceptions.NoViewDefined;
import fr.alegent.Swingy.Views.Console.GameConsoleView;
import fr.alegent.Swingy.Views.GUI.GameGUIView;
import fr.alegent.Swingy.Views.GUI.NewCharacterGUIView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class ViewFactory {
    private final Mode mode;

    private final Map<View.Type, Class<? extends View>> console = new HashMap<View.Type, Class<? extends View>>() {{
        put(View.Type.GAME, GameConsoleView.class);
    }};

    private final Map<View.Type, Class<? extends View>> gui = new HashMap<View.Type, Class<? extends View>>() {{
        put(View.Type.GAME, GameGUIView.class);
        put(View.Type.NEW_CHARACTER, NewCharacterGUIView.class);
    }};


    public enum Mode {
        CONSOLE, GUI
    }

    public ViewFactory(String mode) {
        this.mode = Mode.valueOf(mode);
    }

    @SuppressWarnings("unchecked")
    public <V extends View> V make(View.Type type) throws Exception {
        val map = mode == Mode.CONSOLE ? console : gui;
        val viewClass = map.get(type);
        if (viewClass == null) throw new NoViewDefined(mode, type);
        return (V) viewClass.getDeclaredConstructor().newInstance();
    }

}
