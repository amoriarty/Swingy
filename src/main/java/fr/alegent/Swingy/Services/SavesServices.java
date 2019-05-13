package fr.alegent.Swingy.Services;

import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.Save;
import lombok.val;

import java.io.File;

public class SavesServices {
    private static final String path = "saves";

    public static void save(Player player) throws Exception {
        if (player == null) return;
        mkdir();

        val file = new File(path + "/" + player.name + ".json");
        ResourcesService.shared.write(file, player);
    }

    public static Save[] get() throws Exception {
        val directory = new File(path);
        val files = directory.listFiles();
        if (files == null) return new Save[0];

        val saves = new Save[files.length];

        for (int i = 0; i < files.length; i++) {
            val file = files[i];
            val url = file.toURI().toURL();
            val name = file.getName().replace(".json", "");
            val content = ResourcesService.shared.get(url, Player.class);
            val save = new Save(name, content);
            saves[i] = save;
        }

        return saves;
    }

    private static void mkdir() {
        val directory = new File(path);
        if (directory.exists()) return;
        //noinspection ResultOfMethodCallIgnored
        directory.mkdir();
    }

}
