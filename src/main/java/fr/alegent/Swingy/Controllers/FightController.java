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
        state.stage = State.Stage.FREE_MODE;

        switch (action) {
            case RUN:
                run();
                break;
            case FIGHT:
                fight(true);
                break;
        }

        state.enemy = null;
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

        if (state.enemy.health <= 0) win();
        else if (state.player.health <= 0) {
            state.player.health = state.player.getMaxHP();
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

    private void win() {
        val random = new Random();
        state.player.health = state.player.getMaxHP();
        parent.view.println("You win the battle !");
        level();

        if (random.nextInt(100) > state.player.getLuck() + 10) return;
        val index = random.nextInt(state.items.length);
        val item = state.items[index];
        //noinspection ConstantConditions
        val formatted = String.format("The enemy drop %s", item.name);
        state.player.inventory.add(item);
        parent.view.println(formatted);
    }

    private void level() {
        val level = state.enemy.level;
        val xp = level * 1000 + ((level - 1) * (level - 1)) + 200;
        val formatted = String.format("You receive %d xp", xp);
        state.player.xp += xp;
        parent.view.println(formatted);

        if (state.player.xp < state.player.nextLevel()) return ;
        state.player.level += 1;
        state.player.xp = 0;
        state.stage = State.Stage.LEVEL_UP;
        parent.view.println("You reach the next level");
    }

}
