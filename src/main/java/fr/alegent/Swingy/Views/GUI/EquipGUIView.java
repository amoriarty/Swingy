package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.EquipController;
import fr.alegent.Swingy.Models.Item;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipGUIView extends GUIView implements ActionListener {
    private final JComboBox<Item> selector = new JComboBox();

    public EquipGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        val items = new FieldView("Items", selector);
        setLayout(layout);
        add(items);

        for (val action: EquipController.Action.values()) {
            val button = new JButton(action.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void start() {
        val items = ((EquipController) controller).getItems();

        for (val item: items) {
            selector.addItem(item);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val action = EquipController.Action.valueOf(command);
        val controller = (EquipController) this.controller;

        switch (action) {
            case RETURN:
                controller.previous();
                break;
            case EQUIP:
                val item = (Item) selector.getSelectedItem();
                if (item == null) break;
                controller.equip(item);
                break;
        }
    }

}
