package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.UnequipController;
import fr.alegent.Swingy.Models.Item;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnequipGUIView extends GUIView implements ActionListener {
    private final JComboBox selector = new JComboBox<Item>();

    public UnequipGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(selector);

        for (val action: UnequipController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void start() {
        super.start();
        val items = ((UnequipController) controller).getItems();

        for (val item: items) {
            //noinspection unchecked
            selector.addItem(item);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = UnequipController.Action.valueOf(command);
        val controller = (UnequipController) this.controller;

        switch (action) {
            case UNEQUIP:
                val item = (Item) selector.getSelectedItem();
                if (item == null) break;
                controller.unequip(item);
                break;
            case RETURN:
                controller.previous();
                break;
        }
    }

}
