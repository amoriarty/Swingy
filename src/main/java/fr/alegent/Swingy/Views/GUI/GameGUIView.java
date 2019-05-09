package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Views.Generics.GameView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import javax.swing.*;
import java.awt.*;

public class GameGUIView implements GameView {
    private final JSplitPane split = new SplitPane();
    private final JTextArea console = new TextArea();

    public GameGUIView() {
        val frame = new Frame();
        val scroll = new JScrollPane(console);

        split.setTopComponent(scroll);
        frame.add(split);
        frame.setVisible(true);
    }

    public void println(String text) {
        console.append(text + "\n");
    }

    public void addSubview(View view) {
        split.setBottomComponent((Component) view);
    }

    private class Frame extends JFrame {

        Frame() {
            super("Swingy");
            setLayout(new BorderLayout());
            setSize(500, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

    }

    private class SplitPane extends JSplitPane {

        SplitPane() {
            super();
            setEnabled(false);
            setResizeWeight(.5d);
            setOrientation(VERTICAL_SPLIT);
        }

    }

    private class TextArea extends JTextArea {

        TextArea() {
            super();
            val font = new Font("SF Mono", Font.PLAIN,16);
            setFont(font);
            setLineWrap(true);
            setEditable(false);
        }

    }

}
