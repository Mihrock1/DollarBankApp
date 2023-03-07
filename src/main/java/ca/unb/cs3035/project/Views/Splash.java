package ca.unb.cs3035.project.Views;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * This is my own splash screen, that I made myself.
 *
 */
public class Splash
{
    static Scene splash;
    static Rectangle rect = new Rectangle();
    final private Pane pane;
    final private SequentialTransition seqT;

    public Splash()
    {
        pane = new Pane();
        pane.setStyle("-fx-background-color:#6B5B95");

        splash = new Scene(pane);
        seqT = new SequentialTransition();
    }

    public void show()
    {
        int scale = 40;
        int dur = 400;
        rect = new Rectangle(100 - 2 * scale, 20, scale, scale);
        rect.setFill(Color.FLORALWHITE);

        int[] rotins = {scale, 2 * scale, 3 * scale, 4 * scale, 5 * scale, -6 * scale, -5 * scale, -4 * scale, -3 * scale, -2 * scale};
        int x, y;
        for (int i : rotins) {
            //rotating the square
            RotateTransition rt = new RotateTransition(Duration.millis(dur), rect);
            rt.setByAngle(i / Math.abs(i) * 90);
            rt.setCycleCount(1);
            //moving the square horizontally
            TranslateTransition pt = new TranslateTransition(Duration.millis(dur), rect);
            x = (int) (rect.getX() + Math.abs(i));
            y = (int) (rect.getX() + Math.abs(i) + (Math.abs(i) / i) * scale);
            pt.setFromX(x);
            pt.setToX(y);
            ParallelTransition pat = new ParallelTransition();
            pat.getChildren().addAll(pt, rt);
            pat.setCycleCount(1);
            seqT.getChildren().add(pat);
        }
        //playing the animation
        seqT.play();
        //lambda code sourced from StackOverflow, fades away stage
        seqT.setNode(rect);
        //The text part
        Label label = new Label("Welcome to Dollar Bank!");
        label.setFont(new Font("Verdana", 40));
        label.setStyle("-fx-text-fill:white");
        label.setLayoutX(5);
        label.setLayoutY(70);
        Label lab = new Label("Launching...");
        lab.setFont(new Font("Times New Roman", 15));
        lab.setStyle("-fx-text-fill:white");
        lab.setLayoutX(380);
        lab.setLayoutY(180);

        //now adding everything to position, opening the stage, start the animation
        pane.getChildren().addAll(rect, label, lab);

        seqT.play();
    }

    public Scene getSplashScene()
    {
        return splash;
    }

    public SequentialTransition getSequentialTransition()
    {
        return seqT;
    }
}