package fr.alegent.Swingy.Views.GUI;

import fr.alegent.Swingy.Controllers.Controller;

import javax.swing.*;

abstract class GUIView extends JPanel {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

}