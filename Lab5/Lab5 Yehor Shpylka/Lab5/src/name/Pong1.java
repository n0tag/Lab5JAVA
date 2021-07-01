package name;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.Name;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import java.util.Random;
public class Pong1 extends Application
{
    //tworzenie pola
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double ARENAWIDTH = WIDTH - 2 * MARGIN;
    private static final double ARENAHEIGHT = HEIGHT - 2 * MARGIN;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;
    private static final double R = 10;



    private static final int LICZBAKULEK = 13;
    private Kula[] kulki = new Kula[LICZBAKULEK];
    private double[] x = new double[LICZBAKULEK];
    private double[] y = new double[LICZBAKULEK];
    private double[] vx = new double[LICZBAKULEK];
    private double[] vy = new double[LICZBAKULEK];

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        primaryStage.setTitle("Kulki!");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();

        t.play();
        this.iniKula();
    }

    private void run(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDTH, ARENAHEIGHT);
        for (int i = 0; i < LICZBAKULEK; i++) {
            kulki[i].checkBoundaryCollision(ARENAX1, ARENAY1, ARENAX2, ARENAY2);
            kulki[i].update();
            kulki[i].draw(gc);
        }
    }

    private void iniKula()
    {
            Random lott = new Random();
            for (int i = 0; i < LICZBAKULEK; i++)
            {

                kulki[i] = new Rugby(
                        lott.nextDouble() * ARENAWIDTH + ARENAX1,
                        lott.nextDouble() * ARENAHEIGHT + ARENAY1,
                        5 + lott.nextDouble() * 20,
                        5 + lott.nextDouble() * 20,
                        10,
                        15,
                15);



            }
        }

             public static void main (String[] args){
                 launch(args);
             }

         }


