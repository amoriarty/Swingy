package fr.alegent.Swingy.Views;

public interface GameView extends View {
    @SuppressWarnings("EmptyMethod")
    void dispose();
    void println(String text);
    void addSubview(View view);
}
