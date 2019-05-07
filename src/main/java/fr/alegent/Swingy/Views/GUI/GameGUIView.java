package fr.alegent.Swingy.Views.GUI;

import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameGUIView {
    private final JFrame frame = new JFrame("Swingy");
    private final JScrollPane scroll;

    public GameGUIView() {
        val font = new Font("SF Mono", Font.PLAIN,16);
        val text = new JTextArea();

        text.setFont(font);
        text.setLineWrap(true);
        text.setEditable(false);
        scroll = new JScrollPane(text);

        frame.add(scroll);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.addComponentListener(new Adapter());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    class Adapter extends ComponentAdapter {

        @Override
        public void componentResized(ComponentEvent e) {
            super.componentResized(e);

            val size = frame.getSize();
            scroll.setBounds(10, 10, size.width - 20, (size.height / 2) - 30);
        }

    }

}
