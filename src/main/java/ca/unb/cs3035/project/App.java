package ca.unb.cs3035.project;

import ca.unb.cs3035.project.Models.Model;
import ca.unb.cs3035.project.Views.Splash;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    @Override
    public void start(Stage stage)
    {
        Splash splash = new Splash();
        splash.show();
        stage.setScene(splash.getSplashScene());
        splash.getSequentialTransition().setOnFinished(e -> {
            Timeline timeline = new Timeline();
            KeyFrame key = new KeyFrame(Duration.millis(400),
                    new KeyValue(splash.getSplashScene().getRoot().opacityProperty(), 0));
            timeline.getKeyFrames().add(key);
            timeline.setOnFinished((event) -> {
                stage.close();
                Model.getInstance().getViewFactory().showLoginWindow();
            });
            timeline.play();
        });

        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
