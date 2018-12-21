import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML; //FXMLをコード内で利用するためのもの
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
            new KeyFrame(
                Duration.millis(1000),
                event -> {
                    time.setText(String.format("00:%02d", count));
                    if (count-- < 0) {
                        try {
                            /* Timelineを止めておかないと切り替え後にも
                             * 動いてしまう*/
                            t.stop();
                            MvP.changeSceneByFXML("MvPController.fxml");
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
