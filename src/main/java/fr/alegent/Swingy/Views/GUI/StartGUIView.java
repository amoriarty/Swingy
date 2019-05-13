package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.StartController;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUIView extends GUIView implements ActionListener {

    public StartGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val action: StartController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = StartController.Action.valueOf(command);
        ((StartController) controller).handle(action);
    }

}
