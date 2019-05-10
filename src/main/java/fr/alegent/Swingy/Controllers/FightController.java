package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Coordinate;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;
import lombok.var;

import java.util.Random;

public class FightController extends Controller {

    public enum Action {
        RUN, FIGHT
    }

    public FightController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.FIGHT, parent, state);
    }

    public String getTitle() {
        return "FIGHT";
    }

    void start() throws Exception {
        //noinspection ConstantConditions
        val formatted = String.format(
                "You've stubble upon %s\n%s\nWhat do you choose to do ?",
                state.enemy.name,
                state.enemy.description
        );

        parent.view.println(formatted);
        super.start();
    }

    public void handle(Action action) {
        switch (action) {
            case RUN:
                run();
                break;
            case FIGHT:
                fight(true);
                break;
        }

        state.enemy = null;
        state.stage = State.Stage.FREE_MODE;
        parent.update(state);
    }

    private void run() {
        val random = new Random().nextInt(100);

        if (random < 50) {
            state.player.coordinate = new Coordinate(state.coordinate);
            parent.view.println("You got lucky and successfully return to your previous position.");
            return;
        }

        parent.view.println("You won't escape the battle this time, you'll have to fight !");
        fight(false);
    }

    @SuppressWarnings("ConstantConditions")
    private void fight(boolean begin) {
        if (!begin) {
            parent.view.println("The enemy has make the first hit while you try to run.");
            take();
        }

        while (state.player.health > 0 && state.enemy.health > 0) {
            hit();
            take();
        }

        if (state.enemy.health <= 0) {
            state.player.health = state.player.getMaxHP();
            parent.view.println("You win the battle !");
        } else if (state.player.health <= 0) {
            state.stage = State.Stage.MISSION_GENERATION;
            parent.view.println("YOU DIED");
        }
    }

    private void hit() {
        var hit = state.player.getAttack() - state.enemy.armor;
        hit = hit > 0 ? hit : 0;

        val formatted = String.format("You hit the enemy and he loose %d HP.", hit);
        parent.view.println(formatted);
        state.enemy.health -= hit;
    }

    private void take() {
        var hit = state.enemy.attack - state.player.getArmor();
        hit = hit > 0 ? hit : 0;

        val formatted = String.format("The enemy get you and you loose %d HP.", hit);
        parent.view.println(formatted);
        state.player.health -= hit;
    }

}
