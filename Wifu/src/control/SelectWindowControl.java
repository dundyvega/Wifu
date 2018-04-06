package control;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linker.FileAdministrator;

public class SelectWindowControl implements Initializable {
	
	private Canvas rootImageView;
	
	private String pathName;
	
	private Label invoker;
	@FXML
	private TextField resizeT;
	
	@FXML
	private TextField resizeP;
	
	private int x = 50;
	private int y = 100;
	
	@FXML
	private ListView<NiceImage> listView2;

	@FXML
	private ImageView littleImageView;
	
    @FXML
    void keyPressedOnList(KeyEvent event) {
    	try {
    		painting();
    	} catch(Exception e) {}

    }
    
    @FXML
    void rOnAction(ActionEvent e) {
    	
    	NiceImage pot = listView2.getSelectionModel().getSelectedItem();
    	
    	System.out.println("eredeti: " + pot.getHeight());
    	
    	NiceImage img = new NiceImage(pot.getFile(), pot.getWidth() + 300, pot.getHeight() + 300, true, true, true);
    	
    	painting();
    	
    	int index = listView2.getSelectionModel().getSelectedIndex();
    	
    	  listView2.fireEvent(new ListView.EditEvent<NiceImage>(listView2,
		    		ListView.editCommitEvent(), img, index));
    	  
    }

    @FXML
    void keyReleasedOnList(KeyEvent event) {
    	try {
    		painting();
    	} catch(Exception e) {}

    }

    @FXML
    void mouseClickedOnList(MouseEvent event) {
    	try {
    		painting();
    	} catch(Exception e) {}

    }
    
    @FXML 
    void felbutton(ActionEvent e) {
    	x = x - 15;
    	
    	painting();
    }
    
    @FXML 
    void lebutton(ActionEvent e) {
    	x = x + 15;
    	
    	painting();
    }
    
    @FXML 
    void balrabutton(ActionEvent e) {
    	y = y - 15;
    	painting();
    }
    
    @FXML 
    void jobbrabutton(ActionEvent e) {
    	y = y + 15;
    	painting();
    }
    
    
    @FXML
    void cOnAction(ActionEvent e) {
    	System.out.println("szinek");
    	
    	Scene scene = new Scene(new HBox(20), 400, 100);
        HBox box = (HBox) scene.getRoot();
    	
    	final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);
        
        ImageView wievke = new ImageView(listView2.getSelectionModel().getSelectedItem());
        
        Text f = new Text();
        f.setFont(Font.font ("Verdana", 20));
        
        
        f.setFill(colorPicker.getValue());
        
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                f.setFill(colorPicker.getValue());  
                
            }
        });
        
        
        box.getChildren().addAll(colorPicker, f);
        
        Stage stage = new Stage();
        
        stage.setScene(scene);
        
        stage.show();
    }
    
    public void painting() {
    	littleImageView.setImage(listView2.getSelectionModel().getSelectedItem());
    	
    	System.out.println(listView2.getSelectionModel().getSelectedItem());
    	
    	GraphicsContext gc = rootImageView.getGraphicsContext2D();

    	gc.drawImage(listView2.getSelectionModel().getSelectedItem(), y, x);
    	//rootImageView.setImage(listView2.getSelectionModel().getSelectedItem());
    	
    	//listView2.getSelectionModel().getSelectedItem().
    	
    	NiceImage img;
    	
    }



	public Canvas getRootImageView() {
		return rootImageView;
	}

	public void setRootImageView(Canvas rootImageView) {
		this.rootImageView = rootImageView;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public Label getInvoker() {
		return invoker;
	}

	public void setInvoker(Label invoker) {
		this.invoker = invoker;
	}
	
	public void start() {
		
		ArrayList<NiceImage> files = FileAdministrator.getFilesFrom(pathName);
		
		listView2.getItems().clear();
    	listView2.getItems().addAll(files);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
	}

}
