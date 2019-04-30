package fr.alegent.Swingy.Interfaces;

import fr.alegent.Swingy.Models.State;

public interface WindowControllerInterface {
    String getTitle();
    State update(State state);
}
