import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.scene.Node;
import java.util.ResourceBundle;
public class MvPController{
	private double x;
	private double y;

	@FXML
	private Circle circle;
	
	@FXML
	void initialize(){
		javafx.application.Platform.runLater(() -> {
			Scene scene = circle.getScene();
			scene.setOnKeyPressed(e -> {
				System.out.println(e.getCode().toString());
				double x = circle.getLayoutX();
				double y = circle.getLayoutY();
				String code = e.getCode().toString();
				if(code.equals("RIGHT")){
					setCircle(circle, x + 5, y);
				}else if(code.equals("LEFT")){
					setCircle(circle, x - 5, y);
				}else if(code.equals("UP")){
					setCircle(circle, x, y - 5);
				}else if(code.equals("DOWN")){
					setCircle(circle, x, y + 5);
				}

			});
		});
	}


	@FXML
	void onMoved(MouseEvent e){
		setCircle(circle, e.getX(), e.getY());
	}

	void keyAction(KeyEvent e){
		System.out.println(e.getCode());
	}

	void setCircle(Circle object, double x, double y){
		double upper = 100;
		double bottom = 100 + 200;
		double left = 200;
		double right = 200 + 200;
		if(x >= left + 10 && x <= right - 10){ 
			if(y >= upper + 10 && y <= bottom - 10){
				object.setLayoutY(y);
			}
			circle.setLayoutX(x);
		}else{
			if(y >= upper + 10 && y <= bottom - 10){
				object.setLayoutY(y);
			}
		}
	}
}
