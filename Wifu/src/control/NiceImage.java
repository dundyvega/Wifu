package control;
import java.io.File;
import java.io.InputStream;

import javafx.scene.image.Image;

public class NiceImage extends Image {
	

	private String file;
	private int myX, myY;
	private int myW, myH;
	private int myR, myG, myB;
	private int myF;
	
	public NiceImage(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth,
			boolean backgroundLoading) {
		super(url, requestedWidth, requestedHeight, preserveRatio, smooth, backgroundLoading);
		// TODO Auto-generated constructor stub
		
		file = url;
	}
	
	public void initialize(int x, int y, int w, int h, int r, int g, int b, int f) {
		myX = x;
		myY = y;
		setMyW(w);
		setMyH(h);
		setMyR(r);
		setMyG(g);
		setMyB(b);
		setMyF(f);
	}
	
	public int getmyX() {
		return myX;
	}
	
	public int getmyY() {
		return myY;
	}

	public String getFile() {
		return file;
	}
	
	public String toString() {
		
		return new File(file).getName();
	}

	public int getMyR() {
		return myR;
	}

	public void setMyR(int myR) {
		this.myR = myR;
	}

	public int getMyW() {
		return myW;
	}

	public void setMyW(int myW) {
		this.myW = myW;
	}

	public int getMyH() {
		return myH;
	}

	public void setMyH(int myH) {
		this.myH = myH;
	}

	public int getMyG() {
		return myG;
	}

	public void setMyG(int myG) {
		this.myG = myG;
	}

	public int getMyB() {
		return myB;
	}

	public void setMyB(int myB) {
		this.myB = myB;
	}

	public int getMyF() {
		return myF;
	}

	public void setMyF(int myF) {
		this.myF = myF;
	}

}
