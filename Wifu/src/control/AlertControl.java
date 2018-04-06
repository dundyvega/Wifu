package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import linker.FileAdministrator;

public class AlertControl implements Initializable {

    @FXML
    private Slider resizeY;

    @FXML
    private Slider resizeX;

    @FXML
    private Slider rSlider;

    @FXML
    private TextField xLesh;

    @FXML
    private TextField yLesh;

    @FXML
    private Slider bSlider;

    @FXML
    private Slider gSlider;

    private Wifu control;
    private ListView<NiceImage> lv;
    
    private int originalX = 0;
    private int originalY = 0;

	private ComboBox<String> cb;
	
	 @FXML
	   void xLeshOn(ActionEvent event) {
	    	resize();
	    	System.out.println("kacsa");
	    }
    
    @FXML
    void yLeshOn(ActionEvent event) {
    	
    	System.out.println("text");
    	resize();

    }



    
    void resize() {
    	
    
    	int h = (int) ((int) lv.getSelectionModel().getSelectedItem().getHeight());
    	
    	int w = (int) (lv.getSelectionModel().getSelectedItem().getWidth());
    
    	if (resizeX.getValue() < 100) {
    		h = (int)(h + resizeX.getValue());
    	} else 
    		h = (int)(h + resizeX.getValue() - 100);
    	
    	
    	
    	
    	originalX  = originalX + Integer.parseInt(xLesh.getText());
    	int x = originalX;
    
    	
    	originalY  = originalY + Integer.parseInt(yLesh.getText());
    	int y = originalY;
    	
    
    	
    	int r = (int)rSlider.getValue();
    	
    	int g = (int)gSlider.getValue();
    	
    	int b = (int)bSlider.getValue();
    	
    	int f = 0;
    	
    	System.out.println("eltolás: " + x + " " + y +"\nösszehúzás: " + w + " " + h + " \nrgb: " + r+ " " + g + " "+  b);
    	
    	
    	FileAdministrator.modifyElementByTag(cb.getSelectionModel().getSelectedItem(),
    			lv.getSelectionModel().getSelectedItem().toString(), 0, 0, r, g, b, f, 0, 0);
    	
    	control.painting2();
    	
    	
    
    }

	public void set(ListView<NiceImage> lv, ComboBox<String> cb, Wifu control) {
		// TODO Auto-generated method stub
		this.control = control;
		this.lv = lv;
		this.cb = cb;
		
		setSliders();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		resizeX.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	//System.out.println("észleltem, köszi");
		       resize();
		       
		      // System.out.println("Value: " + resizeX.getValue());
		    }
		});
		
		
		resizeY.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	//System.out.println("észleltem, köszi");
		       resize();
		    }
		});
		
		
		rSlider.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	//System.out.println("észleltem, köszi");
		    	
		    	
		    	resize();
		    	
		       //resize();
		    }
		});
		
		gSlider.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	//System.out.println("észleltem, köszi");
		       repaintImage();
		    }
		});
		
		bSlider.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	//System.out.println("észleltem, köszi");
		       resize();
		    }
		});
		
		
		
		
		
		
	}
	
	
	
	public void setSliders() {
		Image image = lv.getSelectionModel().getSelectedItem();
		PixelReader pixelReader = image.getPixelReader();
		int width = (int) image.getWidth();
		int height = (int) image.getHeight();
		
		boolean atlatszo = true;
		Color color = Color.RED;
		
		for (int y = 0; y < height && atlatszo; ++y) {
			for (int x = 0; x < width && atlatszo; ++x) {
				//color = pixelReader.getColor(x, y);
				
				System.out.println(color);
				if (color.getOpacity() !=  0)
					atlatszo = false;
			}
		}
		
		rSlider.setValue(color.getRed());
		gSlider.setValue(color.getGreen());
		bSlider.setValue(color.getBlue());
		
	
		
	}
	
	
	public void repaintImage() {
		

	}
	


}
