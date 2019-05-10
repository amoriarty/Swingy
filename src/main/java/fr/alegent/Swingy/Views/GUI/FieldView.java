package fr.alegent.Swingy.Views.GUI;

import lombok.val;

import javax.swing.*;
import java.awt.*;

class FieldView extends JPanel {

    FieldView(String name, JComponent component) {
        val layout = new FlowLayout();
        val label = new JLabel(name + ":");

        add(label);
        add(component);
        setLayout(layout);
        layout.setAlignment(FlowLayout.LEADING);
    }

}
