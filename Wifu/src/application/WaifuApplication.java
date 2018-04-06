package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import windows.SelectWindow;


@SuppressWarnings("unused")
public class WaifuApplication extends Application {
	private static Locale locale = Locale.getDefault();
	private static ResourceBundle rb;
	//private static Locale locale = Locale.getDefault();
	@Override
	public void start(Stage stage) {
		Parent root = null;
    	try {
    		
    		root = FXMLLoader.load(getClass().getResource("Application.fxml"));
    		
    	} catch(Exception ex) {
    		System.out.println(ex);
    		Alert alert = new Alert(Alert.AlertType.ERROR);
        	alert.setTitle("Hiba");
        	alert.setHeaderText(null);
        	
        	System.exit(1);

    	}
    	//control.setStage(stage);
        stage.setTitle(rb.getString("key.titleBar"));
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        
        stage.getIcons().add(new Image(WaifuApplication.class.getResource("/images/fv_1_4.png").toExternalForm()));
        stage.getIcons().add(new Image(WaifuApplication.class.getResource("/images/fv_1_3.png").toExternalForm()));
        stage.getIcons().add(new Image(WaifuApplication.class.getResource("/images/fv_1_2.png").toExternalForm()));
        stage.getIcons().add(new Image(WaifuApplication.class.getResource("/images/fv_1_1.png").toExternalForm()));

       stage.show();
       
       stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    	    @Override
    	    public void handle(WindowEvent event1) {
    	        try {
    	           System.out.println("zárom");
    	           System.exit(0);
    	           Platform.exit();
    	        }catch (Exception ex) {
    	            
    	        }
    	    }
    	});
       }
		
		
	
	public static void main(String[] args) {
		
		if (args.length == 2) {
			locale = new Locale(args[0], args[1]);
		}
		
		
		rb = ResourceBundle.getBundle("resources/MessageBundle", locale);
		launch(args);
		
	}
}
