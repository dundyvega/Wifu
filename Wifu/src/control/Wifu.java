package control;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.ButtonBar.ButtonData;
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
import javafx.stage.Modality;
import linker.FileAdministrator;
import windows.Redefined;

public class Wifu implements Initializable {
	
	private Locale locale = Locale.getDefault();
	
	private ResourceBundle t;
	
	@FXML
	private MenuItem resect;

    @FXML
    private MenuItem openMenu;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private Button button2;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private MenuItem newMenu;

    @FXML
    private ListView<NiceImage> listView1;

    @FXML
    private ListView<String> listView2;

    @FXML
    private Menu helpMenu;

    @FXML
    private MenuItem deletMenu;

    @FXML
    private MenuItem importMenu;

    @FXML
    private MenuItem closeMenu;

    @FXML
    private MenuItem parentMenu;

    @FXML
    private MenuItem saveMenu;

    @FXML
    private MenuItem aboutMenu;

    @FXML
    private Menu editMenu;

    @FXML
    private Button button1;
    
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Menu fileMenu;
    
    @FXML
    private Canvas canvas;
    
    private int xCh = 0;
    private int yCh = 0;
    private int wCh = 0;
    private int hCh = 0;
    private int rCh = 0;
    private int gCh = 0;
    private int bCh = 0;
    private int fCh = 0;
    
    private Color backgroundColor = Color.WHITE;
    
    private final String[] maps = {"accessory_back", "accessory_front", "accessory_middle_back",
			"accessory_middle_front", "backgroundImage", "body_back", "body_front",
			"body_front_color", "eye", "eye_color", "face_back", "face_front", "hair_back",
			"hair_back_accessory", "hair_front", "hair_front_accessory", 
			"head", "legs_back", "legs_header" };

    @FXML
    void comboBox1OnAction(ActionEvent event) {
    	try {
    	
    	String selected = comboBox1.getSelectionModel().getSelectedItem();
    	
    	
    	
    	ArrayList<NiceImage> imgs = FileAdministrator.getFilesFrom(selected);
    	
    	listView1.getItems().clear();
    	
    	if (listView1.getItems() == null)
    		System.out.println("fa");
    	
    	listView1.getItems().addAll(imgs);
    	
    	} catch (Exception ex) {
    		listView1.getItems().clear();
    	}
    	
    	

    }

    public void setParameters(int x, int y, int r, int g, int b, int w, int h, int f) {
    	xCh = x;
    	yCh = y;
    	rCh = r;
    	gCh = g;
    	bCh = b;
    	hCh = h;
    	wCh = w;
    	fCh = f;
    	
    }
    
    @FXML
    void keyPressedOnActionOnListView1(KeyEvent event) {

    	try {
    		
    		painting();

    	} catch (Exception ex) {}
    }
    
    void painting() {
    	//System.out.println("kirajzolva1");
    	FileAdministrator.modifyElementByTag(comboBox1.getSelectionModel().getSelectedItem(),
    			listView1.getSelectionModel().getSelectedItem().toString(), xCh, yCh, rCh, gCh, bCh, fCh, wCh, hCh);
    	
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
    		
    		
    		Color c = Color.rgb(im.getMyR(), im.getMyB(), im.getMyB());
    		
    		ColorAdjust adj= new ColorAdjust();
    		
    		adj.setBrightness(c.getBrightness());
    		adj.setContrast(0.5);
    		adj.setSaturation(c.getSaturation());
    		adj.setHue(c.getHue());
    		
    		ImageView modific = new ImageView();
    		modific.setImage(im);
    		
    		modific.setEffect(adj);
    		
    		Image vega = createImage(modific);
    		
    		
    		
    		
        	gc.drawImage(vega, im.getmyX(), im.getmyX());
        	
        	
    	}
    	
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
    
    
    
    
    @FXML
    void keyReleasedOnActionOnListView1(KeyEvent e) {
    	
    	try {
    		
    		painting();

    	} catch (Exception ex) {}
    }

    @FXML
    void mouseClickedOnActionOnListView1(MouseEvent event) {
    	
    	try {
    		
    		painting();

    	} catch (Exception ex) {}
    }

    @FXML
    void button1OnAction(ActionEvent event) {
    	//alertSliders();
    	Redefined rd = new Redefined(listView1, comboBox1, this);
    	rd.setResizable(false);
    }

    @FXML
    void comboBox2OnAction(ActionEvent event) {
    	
    	try {
    	
    	String selected = comboBox2.getSelectionModel().getSelectedItem();
    	
    	ArrayList<NiceImage> imgs = FileAdministrator.getFilesFrom(selected);
    	
    	
    	listView2.getItems().clear();
    	
    	
    	
    	
    	for (NiceImage img: imgs) {
    		listView2.getItems().add(img.toString());
    		
    	}
    	
    	
    	/*itt jön a checkboxolás */
    	
    	
    	
        ObservableSet<String> selectedToppings = FXCollections.observableSet();

        listView2.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(String item) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected) -> {
                    if (isNowSelected) {
                        selectedToppings.add(item);
                        
                        FileAdministrator.addAccessoryByTagName(comboBox2.getSelectionModel().getSelectedItem(), 
                        		item, 0, 0, 0, 0, 0, 0, 0, 0);
                        
                        //System.out.println(comboBox2.getSelectionModel().getSelectedItem() + "/" + item);
                        		painting2();
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
        }));
    	
    	
    	
    	
    	
    	} catch (Exception ex) {listView2.getItems().clear();}

    }

    @FXML
    void onKeyPressedOnListView2(KeyEvent event) {

    }
    
    @FXML
    void resectOnAction(ActionEvent e) {
    	
    	alertResize();
    }

    @FXML
    void mouseClickedOnListView2(MouseEvent event) {

    }

    @FXML
    void button2OnAction(ActionEvent event) {

    }

    @FXML
    void newMenuOnAction(ActionEvent event) {

    }

    @FXML
    void openMenuOnAction(ActionEvent event) {

    }

    @FXML
    void saveMenuOnAction(ActionEvent event) {

    }

    @FXML
    void importMenuOnAction(ActionEvent event) {
    	
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
    void closeMenuOnAction(ActionEvent event) {
    	
    	System.exit(0);
    	Platform.exit();

    }

    @FXML
    void parentMenuOnAction(ActionEvent event) {
    	
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
    		
			newMenu.setDisable(false);
			saveMenu.setDisable(false);
			openMenu.setDisable(false);
			importMenu.setDisable(false);
			resect.setDisable(false);
			comboBox1.setDisable(false);
			listView1.setDisable(false);
			listView2.setDisable(false);
			comboBox2.setDisable(false);
			button1.setDisable(false);
			button2.setDisable(false);
			
			setWhiteCanvas(400, 400);
			
			
    		
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
    
    
    void setWhiteCanvas(int w, int h) {
    	
    	canvas.setWidth(w);
    	canvas.setHeight(h);
    	
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	
    	 gc.setFill(Color.WHITE);
    	gc.fillRect(0, 0, w, h);
    	
    	//painting();
    	
    	


    }

    @FXML
    void deleteMenuOnAction(ActionEvent event) {

    }
    
    void setComboBoxes() {
    	/*{"accessory_back", "accessory_front", "accessory_middle_back",
			"accessory_middle_front", "backgraundImage", "body_back", "body_front",
			"body_front_color", "eye", "eye_color", "face_back", "face_front", "hair_back",
			"hair_back_accessory", "hair_front", "hair_front_accessory", 
			"head", "legs_back", "legs_header" };*/
    	
    	comboBox2.getItems().add("accessory_back");
    	comboBox2.getItems().add("accessory_front");
    	comboBox2.getItems().add("accessory_middle_back");
    	comboBox2.getItems().add("accessory_middle_front");
    	comboBox2.getItems().add("hair_back_accessory");
    	comboBox2.getItems().add("hair_front_accessory");
    	
    	
    	comboBox1.getItems().add("backgroundImage");
    	comboBox1.getItems().add("hair_back");
    	comboBox1.getItems().add("hair_front");
    	comboBox1.getItems().add("body_back");
    	comboBox1.getItems().add("body_front");
    	comboBox1.getItems().add("body_front_color");
    	comboBox1.getItems().add("head");
    	comboBox1.getItems().add("face_back");
    	comboBox1.getItems().add("face_front");
    	comboBox1.getItems().add("eye");
    	comboBox1.getItems().add("eye_color");
    	comboBox1.getItems().add("legs_back");
    	comboBox1.getItems().add("legs_header");
    	
    	
    	
    	
    }

    @FXML
    void aboutMenuOnAction(ActionEvent event) {

    }
    
    
    public void alertSliders() {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	
         alert.setTitle("key.elementparamteres");
       	 
       	 ButtonType okButton = new ButtonType("key.ok", ButtonData.OK_DONE);
       	 
       	 ButtonType cancelButton = new ButtonType("key.cancel", ButtonData.CANCEL_CLOSE);
       	 
       	 alert.getDialogPane().getButtonTypes().clear();
       	 
       	 //alert.getDialogPane().getButtonTypes().remove(1);
       	 
       	 alert.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
       	 
       	 GridPane gridP = new GridPane();
       	 
       	 gridP.setHgap(100);
       	 gridP.setVgap(100);
       	 
       	 gridP.setPadding(new Insets(200, 150, 150, 150));
       	 
       	 //rgb
       	 Slider sr = new Slider();
       	 //Slider sg = new Slider();
       	 //Slider sb = new Slider();
       	 
       	 //xy
       	 
       	Slider slider = new Slider(0, 255, 0.5);
      	 slider.setShowTickMarks(true);
      	 slider.setShowTickLabels(true);
      	 slider.setMajorTickUnit(0.25f);
      	 slider.setBlockIncrement(0.1f);
      	 
      	Slider slider2 = new Slider(0, 255, 0.5);
     	 slider2.setShowTickMarks(true);
     	 slider2.setShowTickLabels(true);
     	 slider2.setMajorTickUnit(0.25f);
     	 slider2.setBlockIncrement(0.1f);
     	 
     	Slider slider3 = new Slider(0, 255, 0.5);
    	 slider3.setShowTickMarks(true);
    	 slider3.setShowTickLabels(true);
    	 slider3.setMajorTickUnit(0.25f);
    	 slider3.setBlockIncrement(0.1f);
      	 
      	 Label label1 = new Label();
      	Label label2 = new Label();
      	Label label3 = new Label();
      	Label label4 = new Label();
       	 
       	 CheckBox cf = new CheckBox();
       	 gridP.getChildren().addAll(slider, label1, slider2, label2, slider3, label3);
       	 alert.getDialogPane().setContent(gridP);
       	 
       	 
       	 alert.showAndWait();
       	 
       	 
    	
    }
    
    
    public void alertResize() {
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
   	 
   	 height.setText(400 + "");
   	 
   	 weight.setText(300 + "");
   	 
   	 Optional<ButtonType> result = alert.showAndWait();
   	 
   	 if (result.get() == okButton){
   		 
   		 
   		 int sz = Integer.parseInt(weight.getText());
   		 
   		 int magas = Integer.parseInt(height.getText());
   		 
   		 //itt lesz egy hibaüzenet
   		 
   		
   		 setWhiteCanvas(sz, magas);
   		 
   		 if (FileAdministrator.allImageFromRoot() != null)
   			 this.painting();
   	 }
    }
 
    
    
	@Override
	public void initialize(URL location, ResourceBundle rs) {
	
		t = ResourceBundle.getBundle("resources/MessageBundle", locale);
		
		fileMenu.setText(t.getString("key.fileMenu"));
		newMenu.setText(t.getString("key.newMenu"));
		saveMenu.setText(t.getString("key.saveMenu"));
		openMenu.setText(t.getString("key.openMenu"));
		editMenu.setText(t.getString("key.editMenu"));
		parentMenu.setText(t.getString("key.parentMenu"));
		importMenu.setText(t.getString("key.importMenu"));
		closeMenu.setText(t.getString("key.closeMenu"));
		deletMenu.setText(t.getString("key.deletMenu"));
		aboutMenu.setText(t.getString("key.aboutMenu"));
		helpMenu.setText(t.getString("key.helpMenu"));
		resect.setText(r("key.resectMenu"));
		
		setComboBoxes();
		
		if (FileAdministrator.configFileCreated()) {
			//enabled same menu
			newMenu.setDisable(false);
			saveMenu.setDisable(false);
			openMenu.setDisable(false);
			importMenu.setDisable(false);
			resect.setDisable(false);
			comboBox1.setDisable(false);
			listView1.setDisable(false);
			listView2.setDisable(false);
			comboBox2.setDisable(false);
			button1.setDisable(false);
			button2.setDisable(false);
			
			
			FileAdministrator.createNew();
			
			setWhiteCanvas(400, 400);
			
		} 
		
		
		
		colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                backgroundColor = colorPicker.getValue();  
                painting2();
            }
        });
		
		
	}
	
	public String r(String s) {
		return t.getString(s);
	}

}
