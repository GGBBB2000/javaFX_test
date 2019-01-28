import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MvP extends Application {
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Move Pointer");
        changeSceneByFXML("MvPController.fxml");
    }

    public static void changeSceneByFXML(String name) throws IOException {
        changeScene(new Scene(getFXMLLoader(name).load()));
    }

    public static void changeScene(Scene s) {
        stage.setScene(s);
        stage.show();
    }

    public static Scene getCurrentScene() {
        return stage.getScene();
    }

    public static FXMLLoader getFXMLLoader(String name) {
        return new FXMLLoader(MvP.class.getResource(name));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
