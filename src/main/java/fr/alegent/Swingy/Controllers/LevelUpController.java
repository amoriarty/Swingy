package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class LevelUpController extends Controller {

    public enum Type {
        HEALTH, ATTACK, ARMOR, LUCK
    }

    public LevelUpController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.LEVEL_UP, parent, state);
    }

    public String getTitle() {
        return "LEVEL UP";
    }

    public void handle(Type type) {
        switch (type) {
            case HEALTH:
                state.player.maxHP += 1;
                state.player.health = state.player.getMaxHP();
                break;
            case ATTACK:
                state.player.attack += 1;
                break;
            case ARMOR:
                state.player.armor += 1;
                break;
            case LUCK:
                state.player.luck += 1;
                break;
        }

        state.stage = State.Stage.FREE_MODE;
        parent.update(state);
    }

}
