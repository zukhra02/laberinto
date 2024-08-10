package org.example;

/**
 * Класс Position представляет собой позицию на двумерной плоскости,
 * определяемую координатами x и y.
 */
public class Position {
    /**
     * Координата x позиции.
     */
    private final int x;

    /**
     * Координата y позиции.
     */
    private final int y;

    /**
     * Создает новую позицию с указанными координатами.
     *
     * @param y Координата y позиции.
     * @param x Координата x позиции.
     */
    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату x позиции.
     *
     * @return Значение координаты x.
     */
    public int getX() {
        return x;
    }

    /**
     * Возвращает координату y позиции.
     *
     * @return Значение координаты y.
     */
    public int getY() {
        return y;
    }
}