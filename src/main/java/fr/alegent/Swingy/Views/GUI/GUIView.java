package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Views.View;

import javax.swing.*;

abstract class GUIView extends JPanel implements View {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void start() { }
}
