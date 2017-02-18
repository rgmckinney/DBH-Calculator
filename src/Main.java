/**
 * Created by Ryan on 2/18/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calc-gui.fxml"));
        primaryStage.setTitle("BDC Calculator");
        primaryStage.setScene(new Scene(root, 568, 320));
        primaryStage.show();
    }

    public static void main(String[] args) {
            launch(args);
        }
}

