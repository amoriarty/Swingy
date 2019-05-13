package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.LoadCharacterController;
import fr.alegent.Swingy.Models.Save;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadCharacterGUIView extends GUIView implements ActionListener {
    private final JComboBox<Save> selector = new JComboBox<>();

    public LoadCharacterGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(selector);

        for (val action: LoadCharacterController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void start() {
        val saves = ((LoadCharacterController) controller).getSaves();

        for (val save: saves) {
            selector.addItem(save);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val controller = (LoadCharacterController) this.controller;
        val command = event.getActionCommand();
        val action = LoadCharacterController.Action.valueOf(command);

        switch (action) {
            case LOAD:
                val save = (Save) selector.getSelectedItem();
                if (save == null) return;
                controller.load(save.player);
                break;
            case RETURN:
                controller.previous();
                break;
        }
    }

}
