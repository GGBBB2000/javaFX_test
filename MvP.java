import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MvP extends Application {
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Move Pointer");
        //Pane myPane_top = (Pane)FXMLLoader.load(getClass().getResource("MvP.fxml"));
        Scene myScene = new Scene(/*myPane_top*/FXMLLoader.load(getClass().getResource("MvPController.fxml")
));
	primaryStage.setScene(myScene);
	primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
