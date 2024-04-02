package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI {


    public static class TicTacToeGUI {
        private JFrame frame;
        private JButton[][] buttons;
        private char currentPlayer;
        //сделать поля игры final
        private boolean AIUsage;
        private int[] AIMove = new int[2];

        public TicTacToeGUI(boolean AIUsage) {
            this.AIUsage = AIUsage;

            frame = new JFrame("Крестики-нолики");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setLayout(new GridLayout(3, 3));

            buttons = new JButton[3][3];

            currentPlayer = 'X';

            initializeButtons();

            frame.setVisible(true);
        }

        private void initializeButtons() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    JButton button = new JButton("");
                    buttons[i][j] = button;
                    button.setFont(new Font("Arial", Font.PLAIN, 40));

                    int finalI = i;
                    int finalJ = j;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (button.getText().isEmpty()) {
                                button.setText(String.valueOf(currentPlayer));
                                if (checkWin()) {
                                    if(AIUsage)
                                        JOptionPane.showMessageDialog(frame, "Вы победили!");
                                    else
                                        JOptionPane.showMessageDialog(frame, "Игрок " + currentPlayer + " победил!");
                                    frame.dispose();
                                    resetBoard();
                                } else if(!checkDraw()) {
                                        JOptionPane.showMessageDialog(frame, "Ничья!");
                                        frame.dispose();
                                        resetBoard();
                                        } else if(AIUsage) {
                                            AIMove = AI.getAIMove(buttons);
                                            buttons[AIMove[0]][AIMove[1]].setText(String.valueOf('O'));
                                            if (checkWin()) {
                                                JOptionPane.showMessageDialog(frame, "Компьютер победил :(");
                                                frame.dispose();
                                                resetBoard();
                                            }
                                        } else
                                            switchPlayer();

                            }
                        }
                    });

                    frame.add(button);
                }
            }
        }

        private void switchPlayer() {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        private boolean checkGroup(JButton a, JButton b, JButton c) {
            return !a.getText().isEmpty() && a.getText().equals(b.getText()) && a.getText().equals(c.getText());
        }

        private boolean checkWin() {
            // Проверка по строкам
            for (int i = 0; i < 3; i++) {
                if (checkGroup(buttons[i][0], buttons[i][1], buttons[i][2])) {
                    return true;
                }
            }

            // Проверка по столбцам
            for (int j = 0; j < 3; j++) {
                if (checkGroup(buttons[0][j], buttons[1][j], buttons[2][j])) {
                    return true;
                }
            }

            // Проверка по диагоналям
            if (checkGroup(buttons[0][0], buttons[1][1], buttons[2][2]) || checkGroup(buttons[0][2], buttons[1][1], buttons[2][0])) {
                return true;
            }

            return false;
        }
        private boolean checkDraw(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(buttons[i][j].getText().isEmpty())
                        return true;
                }
            }
            return false;
        }
        private void resetBoard() {
            new StartMenuGUI();
        }

    }
}
