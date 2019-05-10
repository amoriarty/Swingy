package fr.alegent.Swingy.Views.GUI;

import lombok.val;

import javax.swing.*;
import java.awt.*;

class FieldView extends JPanel {

    @SuppressWarnings("SameParameterValue")
    FieldView(String name, JTextField field) {
        this(name, (JComponent) field);
        val dimension = new Dimension(400, 25);
        field.setPreferredSize(dimension);
    }

    FieldView(String name, JComponent component) {
        val layout = new FlowLayout();
        val label = new JLabel(name + ":");

        add(label);
        add(component);
        setLayout(layout);
        layout.setAlignment(FlowLayout.LEADING);
    }

}
