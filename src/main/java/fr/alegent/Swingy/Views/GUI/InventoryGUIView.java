package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.InventoryController;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryGUIView extends GUIView implements ActionListener {

    public InventoryGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val actions: InventoryController.Action.values()) {
            val button = new JButton(actions.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = InventoryController.Action.valueOf(command);
        ((InventoryController) controller).handle(action);
    }

}
