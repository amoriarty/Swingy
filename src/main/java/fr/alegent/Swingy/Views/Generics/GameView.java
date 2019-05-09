package fr.alegent.Swingy.Views.Generics;

import fr.alegent.Swingy.Views.View;

public interface GameView extends View {
    void println(String text);
    void addSubview(View view);
    void dispose();
}
