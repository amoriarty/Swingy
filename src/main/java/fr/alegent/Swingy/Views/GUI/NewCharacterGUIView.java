package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.NewCharacterController;
import fr.alegent.Swingy.Models.Origin;
import fr.alegent.Swingy.Services.ResourcesService;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCharacterGUIView extends GUIView implements ActionListener, View {
    private final JComboBox selector;
    private final JTextField name;

    public NewCharacterGUIView() throws Exception {
        val origins = ResourcesService.shared.get("origins.json", Origin[].class);
        selector = new JComboBox<>(origins);
        name = new JTextField();

        val confirm = new JButton("Confirm");
        val field = new FieldView("Name", name);
        val origin = new FieldView("Origin", selector);
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);

        add(field);
        add(origin);
        add(confirm);
        setLayout(layout);
        confirm.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        val name = this.name.getText();
        val origin = (Origin) selector.getSelectedItem();
        ((NewCharacterController) controller).create(name, origin);
    }

}
