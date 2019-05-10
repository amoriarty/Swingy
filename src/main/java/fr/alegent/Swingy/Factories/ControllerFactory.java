package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.*;
import fr.alegent.Swingy.Exceptions.NoControllerDefined;
import fr.alegent.Swingy.Models.State;

public class ControllerFactory {

    public static Controller make(State.Stage stage,
                                  ViewFactory factory,
                                  GameController parent,
                                  State state) throws Exception {
        switch (stage) {
            case NEW_CHARACTER: return new NewCharacterController(factory, parent, state);
            case MISSION_GENERATION: return new MissionGenerationController(parent, state);
            case FREE_MODE: return new FreeModeController(factory, parent, state);
            case MOVE: return new MoveController(factory, parent, state);
            case STATS: return new StatsController(parent, state);
            case INVENTORY: return new InventoryController(factory, parent, state);
            case EQUIP: return new EquipController(factory, parent, state);
            case UNEQUIP: return new UnequipController(factory, parent, state);
            case CHECK: return new CheckController(parent, state);
            case FIGHT: return new FightController(factory, parent, state);
            default: throw new NoControllerDefined(stage);
        }
    }

}
