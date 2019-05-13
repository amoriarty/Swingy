package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.LevelUpController;
import fr.alegent.Swingy.Views.Console.LevelUpConsoleView;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpGUIView extends GUIView implements ActionListener {

    public LevelUpGUIView() {
        val layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        for (val type: LevelUpConsoleView.Type.values()) {
            val button = new JButton(type.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent event) {
        val command = event.getActionCommand();
        val type = LevelUpController.Type.valueOf(command);
        ((LevelUpController) controller).handle(type);
    }

}
