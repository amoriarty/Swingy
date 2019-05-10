package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.MoveController;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveGUIView extends GUIView implements ActionListener {

    public MoveGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val direction: MoveController.Direction.values()) {
            val button = new JButton(direction.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val direction = MoveController.Direction.valueOf(command);
        ((MoveController) controller).handle(direction);
    }

}
