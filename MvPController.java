import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
public class MvPController{
	private double x;
	private double y;
	private double mouseX = 0;
	private double mouseY = 0;
	private double circle1X = 20;
	private double circle1Y = 20;

	@FXML
	private Circle circle, circle1;
	
	@FXML
	void initialize(){
		final Timeline tl = new Timeline();
		tl.setCycleCount(Animation.INDEFINITE);
		tl.getKeyFrames().add(new KeyFrame(
					Duration.millis(100),
					ActionEvent -> {
						double x = circle1X;
						double y = circle1Y;
						System.out.printf("x:%f, y:%f\n", x, y);
						setCircle1Position(x, y);
					}
					));
		tl.play();
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
		mouseX = e.getX();
		mouseY = e.getY();
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
		System.out.println("hoge");
	}

	void setCircle1Position(double x, double y){
		double circleX = mouseX;
		double circleY = mouseY;
		System.out.printf("circleX:%f", circleX);
		if(x > circleX){
			if(y > circleY){
				setCircle(circle1, x, y + 5);
				circle1Y += 5;
			}else{
				setCircle(circle1, x, y - 5);
				circle1Y -= 5;
			}
			setCircle(circle1, x + 5, y);
			circle1X += 5;
		}else{
			if(y > circleY){
				setCircle(circle1, x, y + 5);
				circle1Y += 5;
			}else{
				setCircle(circle1, x, y - 5);
				circle1Y -= 5;
			}
			setCircle(circle1, x - 5, y);
			circle1X -= 5;
		}
	}
}
