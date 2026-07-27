package com.cutlet;

import javax.swing.SwingUtilities;
import com.cutlet.ui.MainFrame;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MainFrame frame = new MainFrame();
            frame.setVisible(true);

        });

    }

}