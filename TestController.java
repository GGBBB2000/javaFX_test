import javafx.scene.shape.Circle;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.fxml.FXML; //FXMLをコード内で利用するためのもの
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.text.Text;
public class TestController{
    int count;
    Timeline t;
    @FXML
    Text time;

    @FXML
    void initialize(){
	count = 11;
	/* タイマーの設定 */
	t = new Timeline(
		/* 1000 milli sec　間隔で実行 */
		new KeyFrame(Duration.millis(1000),
		    event -> {
			time.setText(String.format("00:%02d", count));
			if (count-- < 0) {
			    Stage s = (Stage) time.getScene().getWindow();
			    try {
				/* Timelineを止めておかないと切り替え後にも
				 * 動いてしまう*/
				t.stop();
				Scene scene = new Scene(FXMLLoader.load(getClass()
					    .getResource("MvPController.fxml")));
				s.setScene(scene);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}
		}
		)
		);
	/* 何回アニメーションを実行するかの設定(ここでは無限ループ) */
	t.setCycleCount(Animation.INDEFINITE);
	t.play();
    }
}
