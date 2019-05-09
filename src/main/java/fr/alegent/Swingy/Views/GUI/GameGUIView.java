package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Views.GameView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import javax.swing.*;
import java.awt.*;

public class GameGUIView extends JFrame implements GameView {
    private final JSplitPane split = new SplitPane();
    private final JTextArea console = new TextArea();

    public GameGUIView() {
        super("Swingy");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        val scroll = new JScrollPane(console);
        val pane = new JPanel();
        split.setTopComponent(scroll);
        split.setBottomComponent(pane);
        add(split);
        setVisible(true);
    }

    public void println(String text) {
        console.append(text + "\n");
    }

    public void addSubview(View view) {
        split.setBottomComponent((Component) view);
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

    // MARK:- Unused

    public void setController(Controller controller) { }

}
