package fr.alegent.Swingy.Services;

import fr.alegent.Swingy.Models.Save;

public class SavesServices {
    public static final SavesServices shared = new SavesServices();
    public Save[] saves = {};

    private SavesServices() {

    }
}
