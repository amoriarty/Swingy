package fr.alegent.Swingy.Views;

public interface GameView extends View {
    void dispose();
    void println(String text);
    void addSubview(View view);
}
