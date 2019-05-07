package fr.alegent.Swingy.Exceptions;

public class FailedResourceLoad extends Exception {

    @Override
    public String toString() {
        return "Swingy: error: failed to load some resource.";
    }

}
