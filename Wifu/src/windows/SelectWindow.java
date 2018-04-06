package windows;

import java.io.File;

import application.WaifuApplication;
import control.SelectWindowControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SelectWindow extends Stage {
	
	private Canvas rootImageView;
	
	private String pathName;
	
	private Label invoker;
	
	private SelectWindowControl controller;
	
	public void start() {
		
		Parent root = null;
    	
		try {
    	
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("Select.fxml"));
			
			root = fxml.load();
			
			controller = (SelectWindowControl)fxml.getController();
			
			controller.setInvoker(invoker);
			
			controller.setPathName(pathName);
			
			controller.setRootImageView(rootImageView);
    
		} catch(Exception ex) {
    	
			System.out.println(ex);
    		
			Alert alert = new Alert(Alert.AlertType.ERROR);
        	
			alert.setTitle("Hiba");
        	
			alert.setHeaderText(null);
        	
			alert.setContentText(ex.toString());
        	
			System.exit(1);

    	}
    	//control.setStage(stage);
        
		setTitle("key.titleBar2");
        
		Scene scene = new Scene(root, 300, 300);
        
		setScene(scene);
        

       show();
       
       controller.start();
       
	}
       
	public SelectWindow(Canvas rootImage, String pathName, Label invoker) {
		
		rootImageView = rootImage;
		
		this.pathName = pathName;
		
		this.invoker = invoker;
		
		
		start();
		
	}

}
