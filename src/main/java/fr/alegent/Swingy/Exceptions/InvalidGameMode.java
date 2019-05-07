package fr.alegent.Swingy.Exceptions;

public class InvalidGameMode extends Exception {

    @Override
    public String toString() {
        return "Swingy: error: invalid game mode.";
    }

}
