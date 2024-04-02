package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuGUI {
    private JFrame frame;

    public StartMenuGUI() {
        frame = new JFrame("Стартовое меню");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(2, 1));

        JButton vsComputerButton = new JButton("Игра против компьютера");
        JButton vsHumanButton = new JButton("2 Игрока");

        vsComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.TicTacToeGUI(true);
                frame.dispose(); // Закрываем стартовое меню
            }
        });

        vsHumanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.TicTacToeGUI(false);
                frame.dispose(); // Закрываем стартовое меню
            }
        });

        frame.add(vsComputerButton);
        frame.add(vsHumanButton);

        frame.setVisible(true);
    }
}
