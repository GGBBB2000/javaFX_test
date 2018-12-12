import javafx.scene.shape.Circle;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.fxml.FXML; //FXMLをコード内で利用するためのもの
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
public class TestController{
    @FXML
    void initialize(){
	System.out.println("hoge");
    }
}
