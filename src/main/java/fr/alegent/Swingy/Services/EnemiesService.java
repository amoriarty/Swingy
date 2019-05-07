package fr.alegent.Swingy.Services;

import fr.alegent.Swingy.Models.Enemy;

public class EnemiesService extends ResourceService<Enemy> {
    public static final EnemiesService shared = new EnemiesService();

    private EnemiesService() {
        super("enemies.json", Enemy[].class);
    }
}
