public class CircleRadius {

    public static void main(String[] args) {

        int circleCenterX = 5;
        int circleCenterY = 5;
        int radius = 2;
        double turningStep = 90; // угол поворота

        while (radius > 0) {

            while (turningStep <= 360) {

                double x = circleCenterX + radius * (Math.cos(Math.toRadians(turningStep)));
                double y = circleCenterY + radius * (Math.sin(Math.toRadians(turningStep)));

                turningStep = turningStep + 90;
                System.out.println(" (X ; Y)");
                System.out.println("("+x + ";" + y+")");
                System.out.println();
            }
            radius = radius - 1; // уменьшаю радиус и нахожу его точки
            turningStep = 90;
        }
    }
}
/*
Задан круг с радиусом r с центром в точке (x,y).
Вернуть список точек с целочисленными координатами которые попадают в круг.
        */

