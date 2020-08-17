package com.javarush.task.task24.task2413;

public class Brick extends BaseObject{
    //картинка для отрисовки

        //картинка для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Brick(double x, double y)
    {
        super(x,y,3);
    }

    /**
     * Рисуем себя на холсте
     */
    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    /**
     * Ничего не делаем - кирпич неподвижен
     */
    @Override
    public void move()
    {
        //do nothing
    }
}
