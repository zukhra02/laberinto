package org.example;

import java.util.LinkedList;

public class MazeSolver {

    static int[][] maze = {
            {1, 0, 1, 2}, // El destino (2) está en la posición (0, 3)
            {1, 1, 0, 1},
            {0, 1, 1, 1}
    };

    LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();
        Position p = new Position(0, 0); // Inicialización en la posición (0, 0)

        // 0 = wall
        // 1 = path
        // 2 = destination

        solver.path.push(p);
        solver.maze[p.y][p.x] = 0; // Marcando la posición inicial como visitada

        while (true) {
            int y = solver.path.peek().y;
            int x = solver.path.peek().x;

            // Down
            if (y + 1 < solver.maze.length && solver.maze[y + 1][x] == 2) {
                System.out.println("You won");
                return;
            } else if (y + 1 < solver.maze.length && solver.maze[y + 1][x] == 1) {
                System.out.println("Moved down");
                solver.path.push(new Position(y + 1, x));
                solver.maze[y + 1][x] = 0;
                continue;
            }

            // Left
            if (x - 1 >= 0 && solver.maze[y][x - 1] == 2) {
                System.out.println("You won");
                return;
            } else if (x - 1 >= 0 && solver.maze[y][x - 1] == 1) {
                System.out.println("Moved left");
                solver.path.push(new Position(y, x - 1));
                solver.maze[y][x - 1] = 0;
                continue;
            }

            // Up
            if (y - 1 >= 0 && solver.maze[y - 1][x] == 2) {
                System.out.println("You won");
                return;
            } else if (y - 1 >= 0 && solver.maze[y - 1][x] == 1) {
                System.out.println("Moved up");
                solver.path.push(new Position(y - 1, x));
                solver.maze[y - 1][x] = 0;
                continue;
            }

            // Right
            if (x + 1 < solver.maze[0].length && solver.maze[y][x + 1] == 2) {
                System.out.println("You won");
                return;
            } else if (x + 1 < solver.maze[0].length && solver.maze[y][x + 1] == 1) {
                System.out.println("Moved right");
                solver.path.push(new Position(y, x + 1));
                solver.maze[y][x + 1] = 0;
                continue;
            }

            solver.path.pop();
            if (solver.path.isEmpty()) {
                System.out.println("No more path");
                return;
            }
        }
    }

    // Inner class Position
    public static class Position {
        public int x;
        public int y;

        public Position(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}










