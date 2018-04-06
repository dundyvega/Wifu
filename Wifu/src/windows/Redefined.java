package windows;

import java.io.File;

import application.WaifuApplication;
import control.AlertControl;
import control.SelectWindowControl;
import control.Wifu;
import control.WifuControlClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Redefined extends Stage {
	
	private Canvas cv;
	
	private String listView;
	
	private Label invoker;
	
	private ListView lv;
	private Wifu control;
	private AlertControl controller;
	private ComboBox cb;
	
	public void start() {
		
		Parent root = null;
    	
		try {
    	
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("Redefined.fxml"));
			
			root = fxml.load();
			
			controller = (AlertControl)fxml.getController();
			
			controller.set(lv, cb, control);
    
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
       
       
       
	}
       
	public Redefined(ListView lv, ComboBox cb, Wifu control) {

		this.lv = lv;
		this.control = control;
		this.cb = cb;
		
		start();
		
	}

}
