
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeworkJavaFX extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("My Homework");

        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        test(gc);
    }

    private void test(GraphicsContext gc) {

        gc.setStroke(Color.YELLOW); // цвет линии
        gc.setFill(Color.YELLOW); // заливка
        int diameter = 100;
        gc.fillOval(50, 50, diameter, diameter); // солнце
        gc.strokeOval(50, 50, diameter, diameter);
        gc.setLineWidth(5); // толщина линии
        gc.strokeLine(100, 100, 220, 220);
        gc.strokeLine(100, 100, 250, 100);
        gc.strokeLine(100, 100, 100, 250);
        gc.strokeLine(100, 100, -220, -220);
        gc.strokeLine(100, 100, 100, -250);
        gc.strokeLine(100, 100, -220, 100);
        gc.strokeLine(100, 100, 220, -5);
        gc.strokeLine(100, 100, -5, 220);

        gc.setFill(Color.SKYBLUE);
        gc.setStroke(Color.SKYBLUE);
        int diameterCloud = 80;
        gc.fillOval(550, 70, diameterCloud, diameterCloud); // облако
        gc.strokeOval(550, 70, diameterCloud, diameterCloud);
        gc.fillOval(620, 50, diameterCloud, diameterCloud);
        gc.strokeOval(620, 50, diameterCloud, diameterCloud);
        gc.fillOval(680, 85, diameterCloud, diameterCloud);
        gc.strokeOval(680, 85, diameterCloud, diameterCloud);
        gc.fillOval(620, 110, diameterCloud, diameterCloud);
        gc.strokeOval(620, 110, diameterCloud, diameterCloud);
        gc.fillOval(500, 75, diameterCloud, diameterCloud);
        gc.strokeOval(500, 75, diameterCloud, diameterCloud);
        gc.fillOval(500, 65, diameterCloud, diameterCloud);
        gc.strokeOval(500, 65, diameterCloud, diameterCloud);

        gc.setFill(Color.LIGHTPINK);
        gc.setStroke(Color.LIGHTPINK);
        gc.fillOval(220, 300, 30, 30); // голова человека
        gc.strokeOval(220, 300, 30, 30);

        gc.strokeLine(235, 330, 235, 400); //тело


        gc.strokeLine(235, 330, 265, 390); // руки
        gc.strokeLine(235, 330, 205, 390);

        gc.strokeLine(235, 400, 265, 460); // ноги
        gc.strokeLine(235, 400, 205, 460);

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeRect(500, 350, 200, 150); // дом

        gc.setStroke(Color.GRAY);
        gc.setFill(Color.BEIGE);
        gc.fillRect(625, 380, 50, 60); // заливка окна
        gc.strokeRect(625, 380, 50, 60); // окно

        gc.setStroke(Color.GRAY);
        gc.setFill(Color.BEIGE);
        gc.fillRect(525, 380, 60, 120); // заливка двери
        gc.strokeRect(525, 380, 60, 120); // дверь

        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);
        gc.fillPolygon(new double[]{470, 730, 600}, // заливка крыши
                new double[]{350, 350, 250}, 3);

        gc.strokePolygon(new double[]{470, 730, 600}, // крыша треугольник
                new double[]{350, 350, 250}, 3);
             }
        }



