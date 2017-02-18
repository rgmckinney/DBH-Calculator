import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/calc-gui.fxml"));
        Pane root = loader.load();
        primaryStage.setTitle("DBH Calculator");
        Scene scene = new Scene(root, 568, 320);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/css/app.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
            launch(args);
        }
}

