package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Exceptions.NoViewDefined;
import fr.alegent.Swingy.Views.Console.*;
import fr.alegent.Swingy.Views.GUI.*;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class ViewFactory {
    private final Mode mode;

    private final Map<View.Type, Class<? extends View>> console = new HashMap<View.Type, Class<? extends View>>() {{
        put(View.Type.GAME, GameConsoleView.class);
        put(View.Type.NEW_CHARACTER, NewCharacterConsoleView.class);
        put(View.Type.FREE, FreeModeConsoleView.class);
        put(View.Type.MOVE, MoveConsoleView.class);
        put(View.Type.INVENTORY, InventoryConsoleView.class);
        put(View.Type.EQUIP, EquipConsoleView.class);
        put(View.Type.UNEQUIP, UnequipConsoleView.class);
        put(View.Type.FIGHT, FightConsoleView.class);
    }};

    private final Map<View.Type, Class<? extends View>> gui = new HashMap<View.Type, Class<? extends View>>() {{
        put(View.Type.GAME, GameGUIView.class);
        put(View.Type.NEW_CHARACTER, NewCharacterGUIView.class);
        put(View.Type.FREE, FreeModeGUIView.class);
        put(View.Type.MOVE, MoveGUIView.class);
        put(View.Type.INVENTORY, InventoryGUIView.class);
        put(View.Type.EQUIP, EquipGUIView.class);
        put(View.Type.UNEQUIP, UnequipGUIView.class);
        put(View.Type.FIGHT, FightGUIView.class);
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
