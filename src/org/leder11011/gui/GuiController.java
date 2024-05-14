package org.leder11011.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController {
    private JPanel container;
    private JTextField halloWeltTextField;
    private JButton uebernehmenButton;
    private JLabel outputLabel;
    //region Constants
    //endregion

    //region Attributs
    //endregion

    //region Constructors
    public GuiController() {
        uebernehmenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener - actionPerformed: click!!!");
                outputLabel.setText(halloWeltTextField.getText());
                halloWeltTextField.setText("");
                halloWeltTextField.setVisible(true);

            }
        });
    }
    //endregion

    //region Methods
    public void startW(){
        JFrame mainWindow = new JFrame("Hallo Welt!");
        mainWindow.setLocation(400,  300);
        mainWindow.setSize(400, 300);

        halloWeltTextField.setPreferredSize(new Dimension(100,20));

        outputLabel.setPreferredSize(new Dimension(100, 20));

        GridBagLayout layout = new GridBagLayout();

//        layout.setColumns(2);
//        layout.setConstraints(2);

//        layout.setHgap(20);
//        layout.setVgap(20);

        container.setLayout(layout);

        container.add(halloWeltTextField);
        container.add(uebernehmenButton);
        container.add(outputLabel);

        mainWindow.add(container);

        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainWindow.setVisible(true);

    }
    //endregion


}
