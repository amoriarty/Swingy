package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.FreeModeController;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FreeModeGUIView extends GUIView implements ActionListener {

    public FreeModeGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val action: FreeModeController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = FreeModeController.Action.valueOf(command);
        ((FreeModeController) controller).handle(action);
    }

}
