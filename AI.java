package Game;

import javax.swing.*;
import java.util.Random;

public class AI {
    private static int[] coordinates = new int[2];
    private static Random rand = new Random();
    public static int[] getAIMove(JButton[][] buttons) {
        // Простая стратегия ИИ: выбор случайной клетки
        do {
            coordinates[0] = rand.nextInt(3);
            coordinates[1] = rand.nextInt(3);
        }while (!buttons[coordinates[0]][coordinates[1]].getText().isEmpty());
        return coordinates;
    }
}
