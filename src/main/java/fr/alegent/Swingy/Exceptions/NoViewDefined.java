package fr.alegent.Swingy.Exceptions;


import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Views.View;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoViewDefined extends Exception {
    private final View.Type type;
    private final ViewFactory.Mode mode;

    public String toString() {
        return String.format(
                "Swingy: error: no view defined for type %s in %s mode.",
                type.toString(),
                mode.toString()
        );
    }

}
