package fr.alegent.Swingy.Services;

import fr.alegent.Swingy.Models.Origin;

public class OriginsService extends ResourceService<Origin> {
    public static final OriginsService shared = new OriginsService();

    private OriginsService() {
        super("origins.json", Origin[].class);
    }
}
