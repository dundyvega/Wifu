package control;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import linker.FileAdministrator;

public class WifuControlClass  implements Initializable {
	
	private int globalW = 700;
	private int globalH = 400;

    @FXML
    private Button accessory_front_resize;

    @FXML
    private ListView<String> accessory_middle_back;

    @FXML
    private Button hair_front_resize;

    @FXML
    private ListView<String> accessory_middle_front;

    @FXML
    private ListView<String> hair_front_accessory;

    @FXML
    private MenuItem saveMenu;

    @FXML
    private Button body_front_resize;

    @FXML
    private ListView<String> hair_front;

    @FXML
    private Button accessory_back_resize;

    @FXML
    private Button accessory_middle_back_colored;

    @FXML
    private ListView<String> accessory_back;

    @FXML
    private MenuItem SaveAs;

    @FXML
    private Canvas canvas;

    @FXML
    private Button legs_back_resize;

    @FXML
    private Button backgroundImage_resize;

    @FXML
    private Button hair_front_colored;

    @FXML
    private Button eye_color_colored;

    @FXML
    private Button body_back_colored;

    @FXML
    private ListView<String> hair_back_accessory;

    @FXML
    private Button hair_front_accessory_colored;

    @FXML
    private ListView<String> accessory_front;

    @FXML
    private Button eye_colored;

    @FXML
    private Button legs_header_colored;

    @FXML
    private MenuItem ResizeMenu;

    @FXML
    private ListView<String> legs_header;

    @FXML
    private ListView<String> eye;

    @FXML
    private Button eye_color_resize;

    @FXML
    private ListView<String> legs_back;

    @FXML
    private Button face_front_colored;

    @FXML
    private Button face_front_resize;

    @FXML
    private Button body_front_color_resize;

    @FXML
    private Button backgroundImage_colored;

    @FXML
    private ListView<String> body_back;

    @FXML
    private Button accessory_back_colored;

    @FXML
    private Button body_back_resize;

    @FXML
    private Button legs_header_resize;

    @FXML
    private ListView<String> backgroundImage;

    @FXML
    private Button accessory_middle_front_resize;

    @FXML
    private Button face_back_colored;

    @FXML
    private ListView<String> body_front;

    @FXML
    private ListView<String> face_front;

    @FXML
    private MenuItem Open;

    @FXML
    private ListView<String> head;

    @FXML
    private ListView<String> eye_color;

    @FXML
    private Button legs_back_colored;

    @FXML
    private Button hair_back_accessory_colored;

    @FXML
    private Button accessory_front_colored;

    @FXML
    private ListView<String> hair_back;

    @FXML
    private Button hair_back_colored;

    @FXML
    private Button accessory_middle_front_colored;

    @FXML
    private Button accessory_middle_back_resize;

    @FXML
    private Button eye_resize;
    
    private Color backgroundColor = Color.WHITE;

    @FXML
    private MenuItem newMenu;

    @FXML
    private MenuItem setParentMenu;
    
    @FXML
    private MenuItem CloseMenu;
    
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ListView<String> face_back;

    @FXML
    private Button hair_back_accessory_resize;

    @FXML
    private Button hair_front_accessory_resize;

    @FXML
    private Button head_resize;

    @FXML
    private Button body_front_color_colored;

    @FXML
    private Button hair_back_resize;

    @FXML
    private Button face_back_resize;

    @FXML
    private Button head_colored;

    @FXML
    private ListView<String> body_front_color;

    @FXML
    private Button body_front_colored;
    
    @FXML
    private CheckBox bodyBackUp;

    @FXML
    private CheckBox eyeBackUp;
    
    @FXML
    void upCheckBox(ActionEvent event) {

    }
    
    
    
    private final String[] maps = {"accessory_back", "accessory_front", "accessory_middle_back",
			"accessory_middle_front", "backgroundImage", "body_back", "body_front",
			"body_front_color", "eye", "eye_color", "face_back", "face_front", "hair_back",
			"hair_back_accessory", "hair_front", "hair_front_accessory", 
			"head", "legs_back", "legs_header" };

	    

    @FXML
    void newOnAction(ActionEvent event) {

    }
    
    
    @FXML
    void closeOnAction(ActionEvent event) {
    	
    	System.exit(0);
    	Platform.exit();

    }

    @FXML
    void saveOnAction(ActionEvent event) {
    	
    }

    @FXML
    void saveAsOnAction(ActionEvent event) {
    	
    	
    	FileChooser fileChooser = new FileChooser();
    	
    	 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.xml");
    	 fileChooser.getExtensionFilters().add(extFilter);
    	 
    	 File file = fileChooser.showSaveDialog(null);
    	 
    	 if(file != null){
             try {
                 WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
                 canvas.snapshot(null, writableImage);
                 RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                 ImageIO.write(renderedImage, "png", file);
             } catch (IOException ex) {
                // Logger.getLogger(JavaFX_DrawOnCanvas.class.getName()).log(Level.SEVERE, null, ex);
             }
         }

    }

    @FXML
    void openAction(ActionEvent event) {

    }

    @FXML
    void parentAction(ActionEvent event) {
    	
    	
    	
 	DirectoryChooser chooser = new DirectoryChooser();
    	
    	chooser.setTitle("key.wifuBitmap");
   
    	File selectedDirectory = chooser.showDialog(null);
    	
    	boolean equals = true;
    	
    	if (selectedDirectory != null) {
    		
    		 File[] files = selectedDirectory.listFiles();
    		 
    		 Arrays.sort(files);
    		 
    		 
    		 int n = 0;
    		 
    		 if (files.length == maps.length) {
    			 
	    		 for (int i = 0; i < files.length && equals; ++i) {
	    			 
	    			 equals = files[i].getName().equals(maps[i]);
	    		 }

    		if (equals) {
    			
    		FileAdministrator.setContainerFile(selectedDirectory);
    		
    		setListViews();
			
			setWhiteCanvas(globalW, globalH);
			
			
    		
    	//	System.out.println("equals");
    		
    		} 
    		 } else {
    			 equals = false;
    		 }
    	} else {
    		equals = false;
    	}
    	
    	if (!equals) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
	    	 alert.setTitle("key.error");
	    	 ImageView view= new ImageView();
	    	 view.setImage(new Image(WifuControlClass.class.getResource("/images/error_2.png").toExternalForm()));
	    	 alert.setGraphic(view);
	         alert.setHeaderText(null);
	         alert.setContentText("key.errore");
	         alert.showAndWait();
    	}

    	
    	
    }

    @FXML
    void resizeAction(ActionEvent event) {

    	
    	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	
    	     alert.setTitle("key.elementparamteres");
    	   	 
    	   	 ButtonType okButton = new ButtonType("key.ok", ButtonData.OK_DONE);
    	   	 
    	   	 ButtonType cancelButton = new ButtonType("key.cancel", ButtonData.CANCEL_CLOSE);
    	   	 
    	   	 alert.getDialogPane().getButtonTypes().clear();
    	   	 
    	   	 //alert.getDialogPane().getButtonTypes().remove(1);
    	   	 
    	   	 alert.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
    	   	 
    	   	 alert.setGraphic(new ImageView(WifuControlClass.class.getResource("/images/Alert_quastion2.png").toString()));
    	   	 
    	   	 alert.setHeaderText("key.hwsearch");
    	   	 
    	   	 GridPane gridP = new GridPane();
    	   	 
    	   	 gridP.setHgap(40);
    	   	 
    	   	 gridP.setVgap(40);
    	   	 
    	   	 gridP.setPadding(new Insets(20, 150, 10, 10));
    	   	 
    	   	 gridP.add(new Label("key.weightOfPicture "), 0, 0);
    	   	 
    	   	 TextField weight = new TextField();
    	   	 
    	   	 TextField height = new TextField();
    	   	 
    	   	 gridP.add(weight, 1, 0);
    	   	 
    	   	 gridP.add(new Label("key.height"), 0, 1);
    	   	 
    	   	 gridP.add(height, 1, 1);
    	   	 
    	   	 alert.getDialogPane().setContent(gridP);
    	   	 
    	   	 Node okBut = alert.getDialogPane().lookupButton(okButton);
    	   	 
    	   	 height.setText(globalH+"");
    	   	 
    	   	 weight.setText(globalW+"");
    	   	 
    	   	 Optional<ButtonType> result = alert.showAndWait();
    	   	 
    	   	 if (result.get() == okButton){
    	   		 
    	   		 
    	   		 globalW = Integer.parseInt(weight.getText());
    	   		 
    	   		 globalH = Integer.parseInt(height.getText());
    	   		 
    	   		 //itt lesz egy hibaüzenet
    	   		 
    	   		
    	   		 setWhiteCanvas(globalW, globalH);
    	   		 
    	   		 if (FileAdministrator.allImageFromRoot() != null)
    	   			 this.painting2();
    	   	 }
    	
    	
    	
    }
    
    
   public void painting(String category, String item) {
    	//System.out.println("kirajzolva1");
    	FileAdministrator.modifyElementByTag(category, item
    			, 0,0,0,0,255,0,0,0);
    	
    painting2();
    }
    
    public void painting3() {
    	
    	ArrayList<NiceImage> img = FileAdministrator.allImageFromRoot();
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	gc.setFill(Color.WHITE);
    	gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
    	
    	
    	for (NiceImage im : img) {
    		
        	gc.drawImage(im, im.getmyX(), im.getmyX());
    	}
    }
    
    
    
    public void painting2() {
    	//
    	
    	ArrayList<NiceImage> img = FileAdministrator.allImageFromRoot();
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	gc.setFill(backgroundColor);
    	gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
    
    	
    	for (NiceImage im : img) {
   
    		Color c = Color.rgb(im.getMyB(), im.getMyR(), im.getMyG());
    		
    		//backgroundColor = c;
    		
    	/*	ColorAdjust adj= new ColorAdjust();
    		
    		adj.setBrightness(c.getBrightness());
    		adj.setContrast(0.5);
    		adj.setSaturation(c.getSaturation());
    		adj.setHue(c.getHue());
    		
    		ImageView modific = new ImageView();
    		modific.setImage(im);
    		
    		modific.setEffect(adj);
    		
    		Image vega = createImage(modific);
    		*/
    		
    		 double hueShift = c.getHue();
             double saturationFactor = c.getSaturation();
             double brightnessFactor = c.getBrightness();
             double opacityFactor = c.getOpacity();
             
             PixelReader pixelReader = im.getPixelReader();
             WritableImage dest
                     = new WritableImage(
                             (int) im.getWidth(),
                             (int) im.getHeight());
             PixelWriter pixelWriter = dest.getPixelWriter();
      
             for (int y = 0; y < im.getHeight(); y++) {
                 for (int x = 0; x < im.getWidth(); x++) {
                     Color color = pixelReader.getColor(x, y);
      
                     color = color.deriveColor(
                             hueShift,
                             saturationFactor,
                             brightnessFactor,
                             opacityFactor);
                              
                     pixelWriter.setColor(x, y, color);
                 }
             }
             
             ImageView imageViewDest = new ImageView();
             imageViewDest.setImage(dest);
             
             Image vega = createImage(imageViewDest);
      
             
    		
    		
    		
        	gc.drawImage(vega, im.getmyY(), im.getmyX());
    		
    		
    		
        	
        	//System.out.println("kirajzolva: "+ im.getmyX() + " /" + im.getmyY());
        	
        	
    	}
    	
    }

    
    
    public double calculateColor(double cl, int clG, boolean black) {
    	int color = (int)cl * 256;
    	color = (color >> clG) & 0xff;
    	return color /  256;
    }
    
    
    
    public static Image createImage( Node node) {

        WritableImage wi;

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT); 

        int imageWidth = (int) node.getBoundsInLocal().getWidth();
        int imageHeight = (int) node.getBoundsInLocal().getHeight();

        wi = new WritableImage( imageWidth, imageHeight);
        node.snapshot(parameters, wi);

        return wi;

    }  
    
    
    
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		if (FileAdministrator.configFileCreated()) {
			
			FileAdministrator.createNew();
			
			setListViews();
			
			setWhiteCanvas(globalW, globalH);
		}
		
		
		colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                backgroundColor = colorPicker.getValue();  
                painting2();
            }
        });
		
		
	}

	private void setWhiteCanvas(int height, int width) {
		// TODO Auto-generated method stub
	   	canvas.setWidth(width);
    	canvas.setHeight(height);
    	
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	
    	 gc.setFill(Color.WHITE);
    	gc.fillRect(0, 0, width, height);
    	
    	//painting();
    	
    	
		
	}
	
	


	private void setListViews() {
		// TODO Auto-generated method stub
		createListView("hair_back_accessory", hair_back_accessory, true);
		
		createListView("hair_front_accessory", hair_front_accessory, true);
		
		createListView("accessory_back", accessory_back, true);
		
		createListView("accessory_middle_back", accessory_middle_back, true);
		
		createListView("accessory_front", accessory_front, true);
		
		createListView("accessory_middle_front", accessory_middle_front, true);
		
		createListView("hair_back", hair_back, false);
		
		createListView("hair_front", hair_front, false);
		
		createListView("head", head, false);
		
		createListView("eye", eye, false);
		
		createListView("eye_color", eye_color, false);
		
		createListView("body_back", body_back, false);
		
		createListView("body_front", body_front, false);
		
		createListView("body_front_color", body_front_color, false);
		
		createListView("legs_back", legs_back, false);
		
		createListView("legs_header", legs_header, false);
		
		createListView("face_back", face_back, false);
		
		createListView("face_front", face_front, false);

		createListView("backgroundImage", backgroundImage, false); 
	}
	
	
	private String getTagByAction(ActionEvent e) {
		Button button = (Button)e.getSource();
		String idFault = button.getId();
		String[] idFaultByParts = idFault.split("_");
		
		int length = idFaultByParts.length;
		
		String id = "";
		
		for (int i = 0; i < length - 2; ++i) {
			id += idFaultByParts[i];
			id += "_";
		}
		
		id += idFaultByParts[length - 2];
		
		return id;
		
	}
	
	
	public boolean isAnAccessory(String tag) {
		
		String[] tagParts = tag.split("_");
		
		boolean is = false;
		
		for (int i = 0; i < tagParts.length && !is; ++i) {
			if (tagParts[i].equals("accessory"))
				is = true;
		}
		return is;
	}
	
	@SuppressWarnings("static-access")
	@FXML
	public void resizeButtonOnAction(ActionEvent e) {
		String tagName = getTagByAction(e);
		
		if (!isAnAccessory(tagName)) {
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			
		       alert.setTitle("key.elementparamteres");
		       	 
		       ButtonType okButton = new ButtonType("key.ok", ButtonData.OK_DONE);
		       	 
		       ButtonType cancelButton = new ButtonType("key.cancel", ButtonData.CANCEL_CLOSE);
		       	 
		      alert.getDialogPane().getButtonTypes().clear();
		      
		      alert.setGraphic(new ImageView(WifuControlClass.class.getResource("/images/quast_1.png").toString()));
		       	 
		       	 //alert.getDialogPane().getButtonTypes().remove(1);
		       	 
		       alert.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
		       
		       alert.setHeaderText(null);
		       
		       GridPane grid = new GridPane();
		       
		       grid.setHgap(0);
		       grid.setVgap(0);
		       
		       //grid.setPadding(new Insets(0, 0, 10, 10));
		       
		       
		       Separator sep[] = new Separator[9];
		       for (int i = 0; i < 9; ++i)
		    	   sep[i] = new Separator();
		 /*      
		       grid.setRowIndex(sep[0], 0);
		       grid.setColumnIndex(sep[0], 0);
		       
		       
		       grid.setRowIndex(sep[1], 0);
		       grid.setColumnIndex(sep[1], 2);
		       
		       
		       grid.setRowIndex(sep[2], 1);
		       grid.setColumnIndex(sep[2], 1);
		       
		       grid.setRowIndex(sep[3], 2);
		       grid.setColumnIndex(sep[3], 2);
		       
		       grid.setRowIndex(sep[4], 4);
		       grid.setColumnIndex(sep[4], 0);
		       
		       grid.setRowIndex(sep[5], 4);
		       grid.setColumnIndex(sep[5], 1);
		       
		       grid.setRowIndex(sep[6], 5);
		       grid.setColumnIndex(sep[6], 0);
		       
		       grid.setRowIndex(sep[7], 5);
		       grid.setColumnIndex(sep[7], 1);
		       
		       grid.setRowIndex(sep[8], 5);
		       grid.setColumnIndex(sep[8], 2); */
		       
		       Button up = new Button(" up "); grid.setRowIndex(up, 0); grid.setColumnIndex(up, 1); up.setId("up");
		       Button left = new Button("left"); grid.setRowIndex(left, 1);grid.setColumnIndex(left, 0); left.setId("left");
		       Button right = new Button("right"); grid.setRowIndex(right, 1); grid.setColumnIndex(right, 2); right.setId("right");
		       Button down = new Button("down"); grid.setRowIndex(down, 3); grid.setColumnIndex(down, 1); down.setId("down");
		       
		       TextField height = new TextField("height"); grid.setRowIndex(height, 4); grid.setColumnIndex(height, 0); height.setId("height");
		       TextField width = new TextField("width"); grid.setRowIndex(width, 4); grid.setColumnIndex(height, 1); width.setId("width");
		       
		       Button resizeButton = new Button("OK"); grid.setRowIndex(resizeButton, 4); grid.setColumnIndex(resizeButton, 2);
		       
		       grid.getChildren().addAll(up, down, left, right, height, width, resizeButton);
		       
		       alert.getDialogPane().setContent(grid);

		       EventHandler<ActionEvent> moveHandler = new EventHandler<ActionEvent>() {
		    	    @Override
		    	    public void handle(ActionEvent event) {
		    	        
		    	        Button moveButton = (Button)event.getSource();
		    	        
		    	        
		    	        
		    	       String move = moveButton.getId();
		    	      // System.out.println(move);
		    	       movedNoAccessory(move, tagName);
		    	      // System.out.println(move); 
		    	    }
		    	};
		    	
		    	
		    	
		    	  EventHandler<ActionEvent> resizeHandler = new EventHandler<ActionEvent>() {
			    	    @Override
			    	    public void handle(ActionEvent event) {
			    	    	try {
			    	    		int w = Integer.parseInt(width.getText());
			    	    		int h = Integer.parseInt(height.getText());
			    	    		String url = FileAdministrator.getURL(tagName);
			    	    		
			    	    		//FileAdministrator.resize(tagName, url, w, h);
			    	    		
			    	    		painting2();
			    	    		
			    	    	} catch (Exception ex) {
			    	    		// error exception jön ide
			    	    	}
			    	    }
		    	  };
		    	
		    	
		    	
		    	resizeButton.setOnAction(resizeHandler);
		    	 up.setOnAction(moveHandler);
		    	 down.setOnAction(moveHandler);
		    	 left.setOnAction(moveHandler);
		    	 right.setOnAction(moveHandler);
		       
		       
		       
		       //grid.set
		       
		       alert.showAndWait();
			
		}
	}
	
	
	public void movedNoAccessory(String move, String tagName) {
		
		String url = FileAdministrator.getURL(tagName);
		System.out.println(move);
		//System.out.println(url);
		/*if (move.equals("up")) {
			FileAdministrator.move(tagName, url, -10, 0);
		} else 		
			if (move.equals("down")) {
			FileAdministrator.move(tagName, url, 10, 0);
		} else
			if (move.equals("right")) {
				FileAdministrator.move(tagName, url, 0, 10);
			} 		if (move.equals("left")) {
				FileAdministrator.move(tagName, url, 0, -10);
			}
		
		painting2(); */
		
	}
	
	
	@SuppressWarnings("static-access")
	@FXML
	public void colorButtonOnAction(ActionEvent e) {
		String tagName = getTagByAction(e);
		
		if (!isAnAccessory(tagName)) {
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			
		       alert.setTitle("key.elementparamteres");
		       	 
		       ButtonType okButton = new ButtonType("key.ok", ButtonData.OK_DONE);
		       	 
		       ButtonType cancelButton = new ButtonType("key.cancel", ButtonData.CANCEL_CLOSE);
		       	 
		      alert.getDialogPane().getButtonTypes().clear();
		      
		      alert.setGraphic(new ImageView(WifuControlClass.class.getResource("/images/quast_1.png").toString()));
		       	 
		       	 //alert.getDialogPane().getButtonTypes().remove(1);
		       	 
		       alert.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
		       
		       
		       
		       alert.setHeaderText(null);
		       
		       GridPane grid = new GridPane();
		       grid.setHgap(10);
		       grid.setVgap(10);
		       
		       TextField tr = new TextField();
		       TextField tg = new TextField();
		       TextField tb = new TextField();
		       
		       grid.setRowIndex(tr, 1);
		       grid.setColumnIndex(tr, 2);
		       
		       grid.setRowIndex(tg, 3);
		       grid.setColumnIndex(tg, 2);
		       
		       grid.setRowIndex(tb, 5);
		       grid.setColumnIndex(tb, 2);
		       
		       //Canvas canvas1 = new Canvas();
		       //grid.setRowIndex(canvas1, 6);
		       //grid.setColumnIndex(canvas1, 1);
		       
		       //canvas1.setWidth(100);
		       //canvas1.setHeight(100);
		       
		       
		       
		       Label rl = new Label("red: "); grid.setRowIndex(rl, 1); grid.setColumnIndex(rl, 0);
		       Label gl = new Label("green: "); grid.setRowIndex(gl, 3); grid.setColumnIndex(gl, 0);
		       Label bl = new Label ("blue: "); grid.setRowIndex(bl, 5); grid.setColumnIndex(bl, 0);
		       
		       Slider red = new Slider(0, 255, 0); grid.setRowIndex(red, 1); grid.setColumnIndex(red, 1); red.setId("red");
		       Slider blue = new Slider(0, 255, 255); grid.setRowIndex(blue, 5); grid.setColumnIndex(blue, 1); blue.setId("blue");
		       Slider green = new Slider(0, 255, 0); grid.setRowIndex(green, 3); grid.setColumnIndex(green, 1); green.setId("green");
		       
		       
		     
		       
		       
		       ChangeListener colorListener = new ChangeListener<Number>() {
				    @Override
				    public void changed(ObservableValue<? extends Number> observable,
				            Number oldValue, Number newValue) {
				    	//System.out.println("észleltem, köszi");
				       //resize();
				       int rInt = (int)red.getValue();
				       int gInt = (int)green.getValue();
				       int bInt = (int)blue.getValue();
				       
				     //  Color color = Color.rgb(rInt, gInt, bInt);
				       //GraphicsContext g = canvas1.getGraphicsContext2D();
				     //  g.setFill(color);
				      // g.fillRect(0, 0, 100, 100);
				      
				       
				       
				       tr.setText(rInt + "");
				       tg.setText(gInt + "");
				       tb.setText(bInt + "");
				       
				       
				       String url = FileAdministrator.getURL(tagName);
				       
				      // FileAdministrator.setColor(tagName, url, rInt, gInt, bInt);
				       
				       painting2();
				       
				      // System.out.println("Value: " + resizeX.getValue());
				    //
				   }
				};
		       
		       
				red.valueProperty().addListener(colorListener);
				green.valueProperty().addListener(colorListener);
				blue.valueProperty().addListener(colorListener);
				
		       grid.getChildren().addAll(red, green, blue, rl, bl, gl, tg, tr, tb);
		       
		       alert.getDialogPane().setContent(grid);
		       
		       alert.showAndWait();
		}
			
	}
	

	@SuppressWarnings("unchecked")
	private void createListView(String string, ListView listView, boolean checkable) {
		
		ArrayList<NiceImage> imgs = FileAdministrator.getFilesFrom(string);
		
		Collections.sort(imgs, new Comparator<NiceImage>() {

			@Override
			public int compare(NiceImage o1, NiceImage o2) {
				// TODO Auto-generated method stub
				return o1.toString().compareTo(o2.toString());
				
			}
		});
		
		
		
		
			for (NiceImage img: imgs) {
	    		listView.getItems().add(img.toString());
	    		
	    	}
			
			
			
		if (checkable) {	
			
	        ObservableSet<String> selectedToppings = FXCollections.observableSet();

	        listView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(String item) {
	                BooleanProperty observable = new SimpleBooleanProperty();
	                observable.addListener((obsi, wasSelected, isNowSelected) -> {
	                	
	                
	                    if (isNowSelected) {
	                        selectedToppings.add(item);
	                        /*
	                         * 
	                         * ide jön a bekapcs
	                         * 
	                         * 
	                         */
	                        
	                        FileAdministrator.addAccessoryByTagName(string, 
	                        		item, 0, 0, 0, 0, 255, 0, 0, 0);
	                        
	                       // FileAdministrator.modifyByLink(string, item);
	                        
	                        //System.out.println(comboBox2.getSelectionModel().getSelectedItem() + "/" + item);
	                        		painting2();
	     
	                       
	                        //selectedToppings.remove(item);
	                        
	                        System.out.println("p1");
	                    
	                    } else {
	                    		selectedToppings.remove(item);
	                       		FileAdministrator.removeAccessoryByTagName(string, item);
	                       		painting2();
	                    }
	                    
	                    
	                    
	                    
	                   // System.out.println(selectedToppings.size());

	                }); 
	                
	                
	        
	                

	                observable.set(selectedToppings.contains(item));
	                selectedToppings.addListener((SetChangeListener.Change<? extends String> c) -> 
	                    observable.set(selectedToppings.contains(item)));

	                return observable;
	            }
	        }));	
	        
		} else {
		/*	
			 ObservableSet<String> selectedToppings = FXCollections.observableSet();

		        listView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
		            @Override
		            public ObservableValue<Boolean> call(String item) {
		                BooleanProperty observable = new SimpleBooleanProperty();
		                observable.addListener((obs, wasSelected, isNowSelected) -> {
		                	
		                	  if (isNowSelected) {
		                		  
		                		  for (int i = 0; i <= listView.getSelectionModel().getSelectedItems().size(); ++i) {
		                			  System.out.println(listView.getSelectionModel().getSelectedItems().get(i));
		                		  }
		                		  
		                		  listView.getSelectionModel().clearSelection(1);
		                		  
		                          selectedToppings.add(item);
		                          
		                          painting(string, item);
		                          
		                       
		                      } else {
		                          selectedToppings.remove(item);
		                      }
		                   // System.out.println(selectedToppings.size());

		                });

		                observable.set(selectedToppings.contains(item));
		                selectedToppings.addListener((SetChangeListener.Change<? extends String> c) -> 
		                    observable.set(selectedToppings.contains(item)));

		                return observable;
		            }
		        }));	*/
			
			
			
			
			
			
			listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

		        @Override
		        public void handle(MouseEvent event) {
		           painting(string, listView.getSelectionModel().getSelectedItem().toString());
		        }
		    });
			
			listView.setOnKeyPressed(new EventHandler<KeyEvent> (){

		        @Override
		        public void handle(KeyEvent event) {
		           painting(string, listView.getSelectionModel().getSelectedItem().toString());
		        }
		    });
			
			listView.setOnKeyReleased(new EventHandler<KeyEvent> (){

		        @Override
		        public void handle(KeyEvent event) {
		           painting(string, listView.getSelectionModel().getSelectedItem().toString());
		        }
		    });
			
			
			
			
			
		}
		
	}

}
