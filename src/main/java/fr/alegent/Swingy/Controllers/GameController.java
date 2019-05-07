package fr.alegent.Swingy.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Main;
import fr.alegent.Swingy.Models.Item;
import lombok.val;

public class GameController {
    private final Mode mode;

    enum Mode {
        CONSOLE, GUI
    }

    public GameController(String mode) throws Exception {
        try { this.mode = Mode.valueOf(mode); }
        catch (Exception exception) { throw new InvalidGameMode(); }
    }

    public void start() throws Exception {
        val url = Main.class.getResource("items.json");
        val mapper = new ObjectMapper();
        val items = mapper.readValue(url, Item[].class);

        for (val item: items) {
            System.out.println(item.toString());
        }
    }
}
