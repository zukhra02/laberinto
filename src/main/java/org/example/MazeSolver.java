package org.example;

import java.util.LinkedList;

/**
 * Класс MazeSolver -это лабиринт, в виде двумерной сетки, где:
 * 0 - стена, через которую нельзя пройти.
 * 1 - путь, по которому можно двигаться.
 * 2 - пункт назначения, к которому нужно добраться.
 *  Начинаем в левом верхнем углу лабиринта и ищем путь к пункту назначения.
 */

public class MazeSolver {
    /**
     * Cхема лабиринта.
     * Пункт назначения (2) находится в позиции (0, 3).
     */
    private static final int[][] MAZE = {
            {1, 0, 1, 2}, // El destino (2) está en la posición (0, 3)
            {1, 1, 0, 1},
            {0, 1, 1, 1}
    };

    /**
     * All positions.
     */
    private final LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();
        Position p = new Position(0, 0); // Inicialización en la posición (0, 0)

        // 0 = wall
        // 1 = path
        // 2 = destination

        solver.path.push(p);
        MAZE[p.getY()][p.getX()] = 0; // Marcando la posición inicial como visitada

        while (true) {
            int y = solver.path.peek().getY();
            int x = solver.path.peek().getX();

            // Down
            if (y + 1 < MAZE.length && MAZE[y + 1][x] == 2) {
                System.out.println("You won");
                return;
            } else if (y + 1 < MAZE.length && MAZE[y + 1][x] == 1) {
                System.out.println("Moved down");
                solver.path.push(new Position(y + 1, x));
                MAZE[y + 1][x] = 0;
                continue;
            }

            // Left
            if (x - 1 >= 0 && MAZE[y][x - 1] == 2) {
                System.out.println("You won");
                return;
            } else if (x - 1 >= 0 && MAZE[y][x - 1] == 1) {
                System.out.println("Moved left");
                solver.path.push(new Position(y, x - 1));
                MAZE[y][x - 1] = 0;
                continue;
            }

            // Up
            if (y - 1 >= 0 && MAZE[y - 1][x] == 2) {
                System.out.println("You won");
                return;
            } else if (y - 1 >= 0 && MAZE[y - 1][x] == 1) {
                System.out.println("Moved up");
                solver.path.push(new Position(y - 1, x));
                MAZE[y - 1][x] = 0;
                continue;
            }

            // Right
            if (x + 1 < MAZE[0].length && MAZE[y][x + 1] == 2) {
                System.out.println("You won");
                return;
            } else if (x + 1 < MAZE[0].length && MAZE[y][x + 1] == 1) {
                System.out.println("Moved right");
                solver.path.push(new Position(y, x + 1));
                MAZE[y][x + 1] = 0;
                continue;
            }

            solver.path.pop();
            if (solver.path.isEmpty()) {
                System.out.println("No more path");
                return;
            }
        }
    }

}










