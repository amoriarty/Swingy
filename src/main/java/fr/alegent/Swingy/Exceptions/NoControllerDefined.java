package fr.alegent.Swingy.Exceptions;


import fr.alegent.Swingy.Models.State;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoControllerDefined extends Exception {
    private final State.Stage stage;

    public String toString() {
        return String.format("Swingy: error: no controller defined for stage %s.", stage);
    }

}
