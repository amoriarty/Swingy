package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.FightController;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightGUIView extends GUIView implements ActionListener {

    public FightGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val action: FightController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = FightController.Action.valueOf(command);
        ((FightController) controller).handle(action);
    }

}
