package linker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import control.NiceImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class FileAdministrator {
	
	private static File containerFile;
	private static File torolheto;
	private static int globalID;
	
	final static String []map = {"hair_back_accessory", "hair_front_accessory", "accessory_back", "accessory_front", "accessory_middle_back", "accessory_middle_front"};
	
	
	public static boolean isAccessory(String s) { 
		
		boolean is = false;
		for (int i = 0; i < map.length && !is; ++i) {
			if (map[i].equals(s)) {
				is = true;
			}
		}
		return is;
	}
	
	public static void setContainerFile(File file) {
		
		containerFile = file;
		File config = new File ("wifu.conf");
		
		
		
		try {
		
			BufferedWriter br = new BufferedWriter(new FileWriter("wifu.conf"));
			
			br.write(file.toString());
			
			
			br.close();
	} catch (Exception ex) {}
	}
	
	public static ArrayList<NiceImage> getFilesFrom(String s) {
		
		File plFile = new File(containerFile.toString() + "/" + s);
		//System.out.println(plFile.toString());
		File [] allfiles = plFile.listFiles();
		
		ArrayList<NiceImage> list = new ArrayList<NiceImage>();
		
		
		for (File f : allfiles) {
			//System.out.println(f.toString());
			list.add(new NiceImage("file:" + f, 500, 500, true, true, true));
			
			
		}
		
		return list;
	}
	
	public static void createRoot(File filek)  {
		  try {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("Characters");
				doc.appendChild(rootElement);

				rootElement.appendChild(addNewCharacterToXML(doc, 1, 0, 0));
				
				
				

				// write the content into xml file
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(filek);
				//containerFile = filek;

				// Output to console for testing
				// StreamResult result = nElement id = (Element)elem.getElementsByTagName("animeID").item(0);ew StreamResult(System.out);

				transformer.transform(source, result);

				System.out.println("File saved!");

			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			  }
	}
	
	public static Element addNewCharacterToXML(Document doc, int id, int x, int y) {
		
		try {
			
			doc.getDocumentElement().normalize();
			
			
			// staff elements, id, x, y chords
			Element staff = doc.createElement("character");
			
			
			Attr attr = doc.createAttribute("id");
			attr.setValue(id + "");
			
			staff.setAttributeNode(attr);
			
			Attr characterX = doc.createAttribute("x");
			characterX.setValue(x + "");
			
			Attr characterY = doc.createAttribute("y");
			characterY.setValue(y + "");
			
			staff.setAttributeNode(characterX);
			staff.setAttributeNode(characterY);
			
			
			
			Element background = doc.createElement("backgroundImage");
			staff.appendChild(background);
			
			Attr backgroundLink = doc.createAttribute("link");
			backgroundLink.setValue("----link----");
			
			Attr xbackground = doc.createAttribute("x");
			xbackground.setValue("0");
			
			Attr ybackground = doc.createAttribute("y");
			ybackground.setValue("0");
			
			Attr wbackground = doc.createAttribute("w");
			wbackground.setValue("0");
			
			Attr hbackground = doc.createAttribute("h");
			hbackground.setValue("0");
			
			Attr rbackground = doc.createAttribute("r");
			rbackground.setValue("0");
			
			Attr gbackground = doc.createAttribute("g");
			gbackground.setValue("0");
			
			Attr bbackground = doc.createAttribute("b");
			bbackground.setValue("255");
			
			Attr fbackground = doc.createAttribute("f");
			fbackground.setValue("0");
			
			background.setAttributeNode(backgroundLink);
			background.setAttributeNode(xbackground);
			background.setAttributeNode(ybackground);
			background.setAttributeNode(wbackground);
			background.setAttributeNode(hbackground);
			background.setAttributeNode(rbackground);
			background.setAttributeNode(gbackground);
			background.setAttributeNode(bbackground);
			background.setAttributeNode(fbackground);
			
			
			//"hair_back"
			
			Element hair_back = doc.createElement("hair_back");
			staff.appendChild(hair_back);
			
			Attr hairLink = doc.createAttribute("link");
			hairLink.setValue("----link----");
			
			Attr xHair = doc.createAttribute("x");
			xHair.setValue("0");
			
			Attr yHair = doc.createAttribute("y");
			yHair.setValue("0");
			
			Attr wHair = doc.createAttribute("w");
			wHair.setValue("0");
			
			Attr hHair = doc.createAttribute("h");
			hHair.setValue("0");
			
			Attr rHair = doc.createAttribute("r");
			rHair.setValue("0");
			
			Attr gHair = doc.createAttribute("g");
			gHair.setValue("0");
			
			Attr bHair = doc.createAttribute("b");
			bHair.setValue("255");
			
			Attr fHair = doc.createAttribute("f");
			fHair.setValue("0");
			
			hair_back.setAttributeNode(hairLink);
			hair_back.setAttributeNode(xHair);
			hair_back.setAttributeNode(yHair);
			hair_back.setAttributeNode(wHair);
			hair_back.setAttributeNode(hHair);
			hair_back.setAttributeNode(rHair);
			hair_back.setAttributeNode(gHair);
			hair_back.setAttributeNode(bHair);
			hair_back.setAttributeNode(fHair);
			
			
			
			
	
			
			
	//---------------------------------------------------------------------------------------------------		
			Element hair_back_accessory = doc.createElement("hair_back_accessory");
			
			Attr hair_back_accessoryAttr = doc.createAttribute("link");
			hair_back_accessoryAttr.setValue("----link----");
			hair_back_accessory.setAttributeNode(hair_back_accessoryAttr);
			
			
			Attr hair_back_accessoryAttr2 = doc.createAttribute("idS");
			hair_back_accessoryAttr2.setValue("1");
			hair_back_accessory.setAttributeNode(hair_back_accessoryAttr2);
			staff.appendChild(hair_back_accessory);
			
  //----------------------------------------------------------------------------	
			
//---------------------------------------------------------------------------------------------------		
			Element accessory_back = doc.createElement("accessory_back");
			
			Attr accessory_backAttr = doc.createAttribute("link");
			accessory_backAttr.setValue("----link----");
			accessory_back.setAttributeNode(accessory_backAttr);
			
			
			Attr accessory_backAttr2 = doc.createAttribute("idS");
			accessory_backAttr2.setValue("2");
			accessory_back.setAttributeNode(accessory_backAttr2);
			staff.appendChild(accessory_back);
			
			
		
			
  //---------------------------------------------------------------------------------------------------	
			
			
			
			//"hair_back"
			
			Element body_back = doc.createElement("body_back");
			staff.appendChild(body_back);
			
			Attr bodyLink = doc.createAttribute("link");
			bodyLink.setValue("----link----");
			
			Attr xBody = doc.createAttribute("x");
			xBody.setValue("0");
			
			Attr yBody = doc.createAttribute("y");
			yBody.setValue("0");
			
			Attr wBody = doc.createAttribute("w");
			wBody.setValue("0");
			
			Attr hBody = doc.createAttribute("h");
			hBody.setValue("0");
			
			Attr rBody = doc.createAttribute("r");
			rBody.setValue("0");
			
			Attr gBody = doc.createAttribute("g");
			gBody.setValue("0");
			
			Attr bBody = doc.createAttribute("b");
			bBody.setValue("255");
			
			Attr fBody = doc.createAttribute("f");
			fBody.setValue("0");
			
			body_back.setAttributeNode(bodyLink);
			body_back.setAttributeNode(xBody);
			body_back.setAttributeNode(yBody);
			body_back.setAttributeNode(wBody);
			body_back.setAttributeNode(hBody);
			body_back.setAttributeNode(rBody);
			body_back.setAttributeNode(gBody);
			body_back.setAttributeNode(bBody);
			body_back.setAttributeNode(fBody);
			
			
			
			
///"legs_back_back"
			
			Element legs_back = doc.createElement("legs_back");
			staff.appendChild(legs_back);
			
			Attr legs_backLink = doc.createAttribute("link");
			legs_backLink.setValue("----link----");
			
			Attr xlegs_back = doc.createAttribute("x");
			xlegs_back.setValue("0");
			
			Attr ylegs_back = doc.createAttribute("y");
			ylegs_back.setValue("0");
			
			Attr wlegs_back = doc.createAttribute("w");
			wlegs_back.setValue("0");
			
			Attr hlegs_back = doc.createAttribute("h");
			hlegs_back.setValue("0");
			
			Attr rlegs_back = doc.createAttribute("r");
			rlegs_back.setValue("0");
			
			Attr glegs_back = doc.createAttribute("g");
			glegs_back.setValue("0");
			
			Attr blegs_back = doc.createAttribute("b");
			blegs_back.setValue("255");
			
			Attr flegs_back = doc.createAttribute("f");
			flegs_back.setValue("0");
			
			legs_back.setAttributeNode(legs_backLink);
			legs_back.setAttributeNode(xlegs_back);
			legs_back.setAttributeNode(ylegs_back);
			legs_back.setAttributeNode(wlegs_back);
			legs_back.setAttributeNode(hlegs_back);
			legs_back.setAttributeNode(rlegs_back);
			legs_back.setAttributeNode(glegs_back);
			legs_back.setAttributeNode(blegs_back);
			legs_back.setAttributeNode(flegs_back);
			
			
//"legs_header_back"
			
			Element legs_header = doc.createElement("legs_header");
			staff.appendChild(legs_header);
			
			Attr legs_headerLink = doc.createAttribute("link");
			legs_headerLink.setValue("----link----");
			
			Attr xlegs_header = doc.createAttribute("x");
			xlegs_header.setValue("0");
			
			Attr ylegs_header = doc.createAttribute("y");
			ylegs_header.setValue("0");
			
			Attr wlegs_header = doc.createAttribute("w");
			wlegs_header.setValue("0");
			
			Attr hlegs_header = doc.createAttribute("h");
			hlegs_header.setValue("0");
			
			Attr rlegs_header = doc.createAttribute("r");
			rlegs_header.setValue("0");
			
			Attr glegs_header = doc.createAttribute("g");
			glegs_header.setValue("0");
			
			Attr blegs_header = doc.createAttribute("b");
			blegs_header.setValue("255");
			
			Attr flegs_header = doc.createAttribute("f");
			flegs_header.setValue("0");
			
			legs_header.setAttributeNode(legs_headerLink);
			legs_header.setAttributeNode(xlegs_header);
			legs_header.setAttributeNode(ylegs_header);
			legs_header.setAttributeNode(wlegs_header);
			legs_header.setAttributeNode(hlegs_header);
			legs_header.setAttributeNode(rlegs_header);
			legs_header.setAttributeNode(glegs_header);
			legs_header.setAttributeNode(blegs_header);
			legs_header.setAttributeNode(flegs_header);

			
		
					
	
			
			
			
			
//"head_back"
			
			Element head = doc.createElement("head");
			staff.appendChild(head);
			
			Attr headLink = doc.createAttribute("link");
			headLink.setValue("----link----");
			
			Attr xhead = doc.createAttribute("x");
			xhead.setValue("0");
			
			Attr yhead = doc.createAttribute("y");
			yhead.setValue("0");
			
			Attr whead = doc.createAttribute("w");
			whead.setValue("0");
			
			Attr hhead = doc.createAttribute("h");
			hhead.setValue("0");
			
			Attr rhead = doc.createAttribute("r");
			rhead.setValue("0");
			
			Attr ghead = doc.createAttribute("g");
			ghead.setValue("0");
			
			Attr bhead = doc.createAttribute("b");
			bhead.setValue("255");
			
			Attr fhead = doc.createAttribute("f");
			fhead.setValue("0");
			
			head.setAttributeNode(headLink);
			head.setAttributeNode(xhead);
			head.setAttributeNode(yhead);
			head.setAttributeNode(whead);
			head.setAttributeNode(hhead);
			head.setAttributeNode(rhead);
			head.setAttributeNode(ghead);
			head.setAttributeNode(bhead);
			head.setAttributeNode(fhead);
			
			
			
//"face_back_back"
			
			Element face_back = doc.createElement("face_back");
			staff.appendChild(face_back);
			
			Attr face_backLink = doc.createAttribute("link");
			face_backLink.setValue("----link----");
			
			Attr xface_back = doc.createAttribute("x");
			xface_back.setValue("0");
			
			Attr yface_back = doc.createAttribute("y");
			yface_back.setValue("0");
			
			Attr wface_back = doc.createAttribute("w");
			wface_back.setValue("0");
			
			Attr hface_back = doc.createAttribute("h");
			hface_back.setValue("0");
			
			Attr rface_back = doc.createAttribute("r");
			rface_back.setValue("0");
			
			Attr gface_back = doc.createAttribute("g");
			gface_back.setValue("0");
			
			Attr bface_back = doc.createAttribute("b");
			bface_back.setValue("255");
			
			Attr fface_back = doc.createAttribute("f");
			fface_back.setValue("0");
			
			face_back.setAttributeNode(face_backLink);
			face_back.setAttributeNode(xface_back);
			face_back.setAttributeNode(yface_back);
			face_back.setAttributeNode(wface_back);
			face_back.setAttributeNode(hface_back);
			face_back.setAttributeNode(rface_back);
			face_back.setAttributeNode(gface_back);
			face_back.setAttributeNode(bface_back);
			face_back.setAttributeNode(fface_back);
			
			
			
//"face_front_back"
			
			Element face_front = doc.createElement("face_front");
			staff.appendChild(face_front);
			
			Attr face_frontLink = doc.createAttribute("link");
			face_frontLink.setValue("----link----");
			
			Attr xface_front = doc.createAttribute("x");
			xface_front.setValue("0");
			
			Attr yface_front = doc.createAttribute("y");
			yface_front.setValue("0");
			
			Attr wface_front = doc.createAttribute("w");
			wface_front.setValue("0");
			
			Attr hface_front = doc.createAttribute("h");
			hface_front.setValue("0");
			
			Attr rface_front = doc.createAttribute("r");
			rface_front.setValue("0");
			
			Attr gface_front = doc.createAttribute("g");
			gface_front.setValue("0");
			
			Attr bface_front = doc.createAttribute("b");
			bface_front.setValue("255");
			
			Attr fface_front = doc.createAttribute("f");
			fface_front.setValue("0");
			
			face_front.setAttributeNode(face_frontLink);
			face_front.setAttributeNode(xface_front);
			face_front.setAttributeNode(yface_front);
			face_front.setAttributeNode(wface_front);
			face_front.setAttributeNode(hface_front);
			face_front.setAttributeNode(rface_front);
			face_front.setAttributeNode(gface_front);
			face_front.setAttributeNode(bface_front);
			face_front.setAttributeNode(fface_front);
			
			
			Element eye_color = doc.createElement("eye_color");
			staff.appendChild(eye_color);
			
			Attr eye_colorLink = doc.createAttribute("link");
			eye_colorLink.setValue("----link----");
			
			Attr xeye_color = doc.createAttribute("x");
			xeye_color.setValue("0");
			
			Attr yeye_color = doc.createAttribute("y");
			yeye_color.setValue("0");
			
			Attr weye_color = doc.createAttribute("w");
			weye_color.setValue("0");
			
			Attr heye_color = doc.createAttribute("h");
			heye_color.setValue("0");
			
			Attr reye_color = doc.createAttribute("r");
			reye_color.setValue("0");
			
			Attr geye_color = doc.createAttribute("g");
			geye_color.setValue("0");
			
			Attr beye_color = doc.createAttribute("b");
			beye_color.setValue("255");
			
			Attr feye_color = doc.createAttribute("f");
			feye_color.setValue("0");
			
			eye_color.setAttributeNode(eye_colorLink);
			eye_color.setAttributeNode(xeye_color);
			eye_color.setAttributeNode(yeye_color);
			eye_color.setAttributeNode(weye_color);
			eye_color.setAttributeNode(heye_color);
			eye_color.setAttributeNode(reye_color);
			eye_color.setAttributeNode(geye_color);
			eye_color.setAttributeNode(beye_color);
			eye_color.setAttributeNode(feye_color);
			
		
			
			
			
			
			//"eye_back"
			
			Element eye = doc.createElement("eye");
			staff.appendChild(eye);
			
			Attr eyeLink = doc.createAttribute("link");
			eyeLink.setValue("----link----");
			
			Attr xeye = doc.createAttribute("x");
			xeye.setValue("0");
			
			Attr yeye = doc.createAttribute("y");
			yeye.setValue("0");
			
			Attr weye = doc.createAttribute("w");
			weye.setValue("0");
			
			Attr heye = doc.createAttribute("h");
			heye.setValue("0");
			
			Attr reye = doc.createAttribute("r");
			reye.setValue("0");
			
			Attr geye = doc.createAttribute("g");
			geye.setValue("0");
			
			Attr beye = doc.createAttribute("b");
			beye.setValue("255");
			
			Attr feye = doc.createAttribute("f");
			feye.setValue("255");
			
			eye.setAttributeNode(eyeLink);
			eye.setAttributeNode(xeye);
			eye.setAttributeNode(yeye);
			eye.setAttributeNode(weye);
			eye.setAttributeNode(heye);
			eye.setAttributeNode(reye);
			eye.setAttributeNode(geye);
			eye.setAttributeNode(beye);
			eye.setAttributeNode(feye);
			
			
			
			
//"body_front_color_back"
			
			Element body_front_color = doc.createElement("body_front_color");
			staff.appendChild(body_front_color);
			
			Attr body_front_colorLink = doc.createAttribute("link");
			body_front_colorLink.setValue("----link----");
			
			Attr xbody_front_color = doc.createAttribute("x");
			xbody_front_color.setValue("0");
			
			Attr ybody_front_color = doc.createAttribute("y");
			ybody_front_color.setValue("0");
			
			Attr wbody_front_color = doc.createAttribute("w");
			wbody_front_color.setValue("0");
			
			Attr hbody_front_color = doc.createAttribute("h");
			hbody_front_color.setValue("0");
			
			Attr rbody_front_color = doc.createAttribute("r");
			rbody_front_color.setValue("0");
			
			Attr gbody_front_color = doc.createAttribute("g");
			gbody_front_color.setValue("0");
			
			Attr bbody_front_color = doc.createAttribute("b");
			bbody_front_color.setValue("255");
			
			Attr fbody_front_color = doc.createAttribute("f");
			fbody_front_color.setValue("255");
			
			body_front_color.setAttributeNode(body_front_colorLink);
			body_front_color.setAttributeNode(xbody_front_color);
			body_front_color.setAttributeNode(ybody_front_color);
			body_front_color.setAttributeNode(wbody_front_color);
			body_front_color.setAttributeNode(hbody_front_color);
			body_front_color.setAttributeNode(rbody_front_color);
			body_front_color.setAttributeNode(gbody_front_color);
			body_front_color.setAttributeNode(bbody_front_color);
			body_front_color.setAttributeNode(fbody_front_color);
			
			
//"body_front_back"
			
		
			
			
			Element body_front = doc.createElement("body_front");
			staff.appendChild(body_front);
			
			Attr body_frontLink = doc.createAttribute("link");
			body_frontLink.setValue("----link----");
			
			Attr xbody_front = doc.createAttribute("x");
			xbody_front.setValue("0");
			
			Attr ybody_front = doc.createAttribute("y");
			ybody_front.setValue("0");
			
			Attr wbody_front = doc.createAttribute("w");
			wbody_front.setValue("0");
			
			Attr hbody_front = doc.createAttribute("h");
			hbody_front.setValue("0");
			
			Attr rbody_front = doc.createAttribute("r");
			rbody_front.setValue("0");
			
			Attr gbody_front = doc.createAttribute("g");
			gbody_front.setValue("0");
			
			Attr bbody_front = doc.createAttribute("b");
			bbody_front.setValue("255");
			
			Attr fbody_front = doc.createAttribute("f");
			fbody_front.setValue("0");
			
			body_front.setAttributeNode(body_frontLink);
			body_front.setAttributeNode(xbody_front);
			body_front.setAttributeNode(ybody_front);
			body_front.setAttributeNode(wbody_front);
			body_front.setAttributeNode(hbody_front);
			body_front.setAttributeNode(rbody_front);
			body_front.setAttributeNode(gbody_front);
			body_front.setAttributeNode(bbody_front);
			body_front.setAttributeNode(fbody_front);
			
			
			

			
			
//---------------------------------------------------------------------------------------------------		
			
			
			

			
			
			
//"hair_front_back"
			
			Element hair_front = doc.createElement("hair_front");
			staff.appendChild(hair_front);
			
			Attr hair_frontLink = doc.createAttribute("link");
			hair_frontLink.setValue("----link----");
			
			Attr xhair_front = doc.createAttribute("x");
			xhair_front.setValue("0");
			
			Attr yhair_front = doc.createAttribute("y");
			yhair_front.setValue("0");
			
			Attr whair_front = doc.createAttribute("w");
			whair_front.setValue("0");
			
			Attr hhair_front = doc.createAttribute("h");
			hhair_front.setValue("0");
			
			Attr rhair_front = doc.createAttribute("r");
			rhair_front.setValue("0");
			
			Attr ghair_front = doc.createAttribute("g");
			ghair_front.setValue("0");
			
			Attr bhair_front = doc.createAttribute("b");
			bhair_front.setValue("255");
			
			Attr fhair_front = doc.createAttribute("f");
			fhair_front.setValue("0");
			
			hair_front.setAttributeNode(hair_frontLink);
			hair_front.setAttributeNode(xhair_front);
			hair_front.setAttributeNode(yhair_front);
			hair_front.setAttributeNode(whair_front);
			hair_front.setAttributeNode(hhair_front);
			hair_front.setAttributeNode(rhair_front);
			hair_front.setAttributeNode(ghair_front);
			hair_front.setAttributeNode(bhair_front);
			hair_front.setAttributeNode(fhair_front);
			
			
			//---------------------------------------------------------------------------------------------------		
			Element accessory_middle_back = doc.createElement("accessory_middle_back");
			
			Attr accessory_middle_backAttr = doc.createAttribute("link");
			accessory_middle_backAttr.setValue("----link----");
			accessory_middle_back.setAttributeNode(accessory_middle_backAttr);
			
			
			Attr accessory_middle_backAttr2 = doc.createAttribute("idS");
			accessory_middle_backAttr2.setValue("3");
			accessory_middle_back.setAttributeNode(accessory_middle_backAttr2);
			staff.appendChild(accessory_middle_back);
			
  //-----------}----------------------------------------------------------------------------------------	
			
			
	
			
			
			
			//"eye_color_back"
			Element accessory_middle_front = doc.createElement("accessory_middle_front");
			
			Attr accessory_middle_frontAttr = doc.createAttribute("link");
			accessory_middle_frontAttr.setValue("----link----");
			accessory_middle_front.setAttributeNode(accessory_middle_frontAttr);
			
			
			Attr accessory_middle_frontAttr2 = doc.createAttribute("idS");
			accessory_middle_frontAttr2.setValue("4");
			accessory_middle_front.setAttributeNode(accessory_middle_frontAttr2);
			staff.appendChild(accessory_middle_front);
			
			
		
			
  //---------------------------------------------------------------------------------------------------	
	
	
			
			
			
			//---------------------------------------------------------------------------------------------------		
			Element accessory_front = doc.createElement("accessory_front");
			
			Attr accessory_frontAttr = doc.createAttribute("link");
			accessory_frontAttr.setValue("----link----");
			accessory_front.setAttributeNode(accessory_frontAttr);
			
			
			Attr accessory_frontAttr2 = doc.createAttribute("idS");
			accessory_frontAttr2.setValue("5");
			accessory_front.setAttributeNode(accessory_frontAttr2);
			staff.appendChild(accessory_front);
			
		
			
  //---------------------------------------------------------------------------------------------------	
	
	
				
			
			
//---------------------------------------------------------------------------------------------------		
			Element hair_front_accessory = doc.createElement("hair_front_accessory");
			
			Attr hair_front_accessoryAttr = doc.createAttribute("link");
			hair_front_accessoryAttr.setValue("----link----");
			hair_front_accessory.setAttributeNode(hair_front_accessoryAttr);
			
			
			Attr hair_front_accessoryAttr2 = doc.createAttribute("idS");
			hair_front_accessoryAttr2.setValue("6");
			hair_front_accessory.setAttributeNode(hair_front_accessoryAttr2);
			staff.appendChild(hair_front_accessory);	
			
  //---------------------------------------------------------------------------------------------------	
	
			
			
			

				
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		
		return staff;
		
		} catch (Exception ex) {}
		return doc.createElement("character");
	}
	
	public static void addNewCharacterToXML(File filek, int x, int y) {
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filek);
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			Element rootElement = doc.getDocumentElement();
			
			doc.getDocumentElement().normalize();
			
			NodeList accounts = doc.getElementsByTagName("character");
			Element lastAccount = (Element)accounts.item(accounts.getLength()-1);    
			String phone = lastAccount.getAttribute("id");
			
			
			int newId = Integer.parseInt(phone) + 1;
			
			doc.normalize();
			rootElement.appendChild(addNewCharacterToXML(doc, newId, x, y));
			
			// write the content into xml file
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(filek);
			
			
			//containerFile = filek;

			// Output to console for testing
			// StreamResult result = nElement id = (Element)elem.getElementsByTagName("animeID").item(0);ew StreamResult(System.out);

			transformer.transform(source, result);

			
		} catch (Exception ex) {System.out.println(ex.getMessage());}
	}
	
	
	public static Element getElementByAtribute(Document doc, int id) {
		try {
			//DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			//DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			Element rootElement = doc.getDocumentElement();
			
			NodeList accounts = doc.getElementsByTagName("character");
			
			boolean talalt = false;
			
			Element elek;
			
			for (int i = 0; i < accounts.getLength() && !talalt; ++i) {
				
				elek = (Element)accounts.item(i);
				
				if (elek.getAttribute("id").equals("" + id)) {
					talalt = true;
				}
				
				if (talalt) {
					return elek;
				}
			}
			
			doc.getDocumentElement().normalize();
		} catch (Exception ex) {System.out.println(ex);}
		
		return null;
	}
	
	public static void modifyElementByTag(String tagName, String url, int x, int y, int w, int h, int r, int g, int b, int f, Document doc, int id) {
		
		doc.normalize();
		
		//System.out.println("tagtag " + tagName + " " + url);
		
		Element staff = getElementByAtribute(doc, id); 
		
		Element el = (Element)(staff.getChildNodes()).item(0);
		f = Integer.parseInt(el.getAttribute("f"));
		
		
		NodeList accounts = staff.getElementsByTagName(tagName);
		
		
		Element elek = (Element)accounts.item(0);
		
		
		
		elek.getAttributeNode("x").setValue(x + "");
		elek.getAttributeNode("y").setValue(y + "");
		elek.getAttributeNode("w").setValue(w + "");
		elek.getAttributeNode("h").setValue(h + "");
		elek.getAttributeNode("r").setValue(r + "");
		elek.getAttributeNode("g").setValue(g + "");
		elek.getAttributeNode("b").setValue(b + "");
		elek.getAttributeNode("f").setValue(f + "");
		
		if (elek.getAttribute("link").equals(url)) {
			elek.getAttributeNode("link").setValue("----link----");
		}
		else
		elek.getAttributeNode("link").setValue(url + "");
		
		
	}
	

	
	
	public static void modifyElementByTag(String tagName, String url, int x, int y, int w, int h, int r, int g, int b, int f, File filek, int id) {
		try {
			
			
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(filek);
		
		FileAdministrator.modifyElementByTag(tagName, url, x, y, w, h, r, g, b, f, doc, id);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();;
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(filek);
		transformer.transform(source, result);
		//System.out.println("nodositas ok");
		
		
		} catch (Exception ex) {System.out.println(ex);}
	}
	
	public static Element getElement(Document doc, int id, String tagName) {
		return (Element)FileAdministrator.getElementByAtribute(doc, id).getElementsByTagName(tagName).item(0);
	}
	
	public static Element getElement(File filek, int id, String tagName) {
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(filek);
		doc.normalize();
		return  FileAdministrator.getElement(doc, id, tagName);
		} catch (Exception Ex) {}
		
		return null;
	}
	
	

	public static boolean configFileCreated() {
		// TODO Auto-generated method stub
		
		File config = new File ("wifu.conf");
		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader("wifu.conf"));
			
			String line = br.readLine();
			
			setContainerFile(new File(line));
			
			br.close();
			
			return true;
		
		} catch (Exception ex) {
			
			return false;
		}
		
	}

	public static void createNew() {
		// TODO Auto-generated method stub
		torolheto = new File("torolheto.nya");
		FileAdministrator.createRoot(torolheto);
		globalID = 1;
		
		
	}

	//tagName, url, x, y, w, h, r, g, b, f, doc, id);
	
	public static void modifyElementByTag(String tagName, String url, int x, int y, int r, int g,
			int b, int f, int w, int h) {
		// TODO Auto-generated method stub
		
		if (torolheto != null) {
			//System.out.println("kacsa");
		}
		
		modifyElementByTag(tagName, url, x, y, w, h, r, g, b, f, torolheto, globalID);
		
		//System.out.println("megtörtént");
		
	}
	
	
	public static ArrayList<NiceImage> allImageFromRoot() {
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(torolheto);
		
		ArrayList<NiceImage> imgs = new ArrayList<NiceImage>();
		
		for (int k = 1; k <= globalID; ++k) {
		
		Element myRoot = FileAdministrator.getElementByAtribute(doc, k);
		
		Element elek;
		
		String fullURL = "";
		
		final String constans = "----link----";
		
		NodeList nList = myRoot.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); ++i) {
			
			//System.out.print(" i");
			
			elek = (Element)nList.item(i);
			String nezd = elek.getAttribute("link");
			
			if (!nezd.equals(constans)) {
				//System.out.print("minus");
				fullURL = "file:"+  containerFile + "/" + elek.getTagName() + "/" + nezd;
				int x = Integer.parseInt(elek.getAttribute("x"));
				int y = Integer.parseInt(elek.getAttribute("y"));
				int r = Integer.parseInt(elek.getAttribute("r"));
				int g = Integer.parseInt(elek.getAttribute("g"));
				int b = Integer.parseInt(elek.getAttribute("b"));
				int f = Integer.parseInt(elek.getAttribute("f"));
				int w = Integer.parseInt(elek.getAttribute("w"));
				int h = Integer.parseInt(elek.getAttribute("h"));
				
				NiceImage img = new NiceImage(fullURL, w, h, false,false, false);
				img.initialize(x, y, w, h, r, g, b, f);
				
				imgs.add(img);
				
				//System.out.println("megvan");
			} else {
				
				if (FileAdministrator.isAccessory(elek.getTagName())) {
					NodeList nya = elek.getChildNodes(); 
				if (nya.getLength() > 0) {
					for (int j = 0; j < nya.getLength(); ++j) {
						//System.out.println("faszfej");
						Element peti = (Element)nya.item(j);
						nezd = peti.getAttribute("link");
						fullURL = "file:"+ containerFile + "/" + peti.getTagName() + "/" + nezd;
						int x = Integer.parseInt(peti.getAttribute("x"));
						int y = Integer.parseInt(peti.getAttribute("y"));
						int r = Integer.parseInt(peti.getAttribute("r"));
						int g = Integer.parseInt(peti.getAttribute("g"));
						int b = Integer.parseInt(peti.getAttribute("b"));
						int f = Integer.parseInt(peti.getAttribute("f"));
						int w = Integer.parseInt(peti.getAttribute("w"));
						int h = Integer.parseInt(peti.getAttribute("h"));
						
						NiceImage img = new NiceImage(fullURL, w, h, false,false, false);
						img.initialize(x, y, w, h, r, g, b, f);
						
						imgs.add(img);
						
					}
				//	System.out.println("egy kirajzolva");
				}
					
				}
			}
		}
		}
		
		return imgs;
		
		} catch (Exception ex) {}
		return null;
	}


	public static void mainASF(String[] args) {
		File f = new File("torolheto.nya");
		FileAdministrator.createRoot(f);
				
		//FileAdministrator.modifyElementByTag("head", "kacsa", 10, 20, 50, 40, 30, 50, 20, 1, f, 1);
		
		FileAdministrator.addAccessoryByTagName("hair_back_accessory", "kac1sasult", 1, 1, 2, 3, 4, 5,6, 7, f, 1);
		

		FileAdministrator.addAccessoryByTagName("hair_back_accessory", "kacs2asult", 1, 1, 2, 3, 4, 5,6, 7, f, 1);
		

		FileAdministrator.addAccessoryByTagName("hair_back_accessory", "kacsa3sult", 1, 1, 2, 3, 4, 5,6, 7, f, 1);
		

		FileAdministrator.addAccessoryByTagName("hair_back_accessory", "kacsas4ult", 1, 1, 2, 3, 4, 5,6, 7, f, 1);
		//addNewCharacterToXML(f, 7, 8);
	}

	public static void addAccessoryByTagName(String tagName, String url, int x, int y, int r, int g, int b, int f,
			int w, int h, File filek, int id) {
		 // TODO Auto-generated method stub
		  // System.out.println("kezdődik");
		   try {
			   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   Element fRootElement = FileAdministrator.getElementByAtribute(doc, id);
			   Element el = (Element)(fRootElement.getChildNodes()).item(0);
				f = Integer.parseInt(el.getAttribute("f"));
			   
			   
			   
			   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
			   
			   doc.normalize();
	
			    Element legs_header = doc.createElement(tagName);
				rootElement.appendChild(legs_header);
				
				
				Attr legs_headerLink = doc.createAttribute("link");
				legs_headerLink.setValue(url);
				
				Attr xlegs_header = doc.createAttribute("x");
				xlegs_header.setValue(x + "");
				
				
				Attr ylegs_header = doc.createAttribute("y");
				ylegs_header.setValue(y + "");
				
				//System.out.println("segg");
				
				Attr wlegs_header = doc.createAttribute("w");
				wlegs_header.setValue(w + "");
				
				
				
				Attr hlegs_header = doc.createAttribute("h");
				hlegs_header.setValue(h + "");
				
				Attr rlegs_header = doc.createAttribute("r");
				rlegs_header.setValue(r + "");
				
				Attr glegs_header = doc.createAttribute("g");
				glegs_header.setValue(g + "");
				
				Attr blegs_header = doc.createAttribute("b");
				blegs_header.setValue(b + "");
				
				Attr flegs_header = doc.createAttribute("f");
				flegs_header.setValue(f + "");
				
				
				
				legs_header.setAttributeNode(legs_headerLink);
				legs_header.setAttributeNode(xlegs_header);
				legs_header.setAttributeNode(ylegs_header);
				legs_header.setAttributeNode(wlegs_header);
				legs_header.setAttributeNode(hlegs_header);
				legs_header.setAttributeNode(rlegs_header);
				legs_header.setAttributeNode(glegs_header);
				legs_header.setAttributeNode(blegs_header);
				legs_header.setAttributeNode(flegs_header);
				
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();;
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(filek);
				transformer.transform(source, result);
			   
			
			  
		   } catch (Exception ex) {System.out.println(ex);}
		
	}
	
	
		

		public static void addAccessoryByTagName(String tagName, String url, int x, int y, int r, int g,
			int b, int f, int w, int h) {
			
			//System.out.println(tagName + "   " + url);
		// TODO Auto-generated method stub
			//System.out.println(tagName +" " + url );
			//System.out.println(x);
		FileAdministrator.addAccessoryByTagName(tagName, url, x, y, r, g, b, f, w, h, torolheto, globalID);
		
	}	
		
	
		public static void removeAccessoryByTagName(String tagName, String url) {
			
			removeAccessoryByTagName(tagName, url, torolheto, globalID);
		}

		private static void removeAccessoryByTagName(String tagName, String url, File filek, int id) {
			// TODO Auto-generated method stub
			
			  try {
				   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				   Document doc = dBuilder.parse(filek);
				   
				   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
				   
				   
				   NodeList nList = rootElement.getChildNodes();
				   
				   boolean deleted = false;
				   
				   int i = 0;
				   
				   while (!deleted && i < nList.getLength()) {
					   Element e = (Element)nList.item(i);
					   if (e.getAttribute("link").equals(url)) {
						   rootElement.removeChild(e);
						   deleted = true;
					   } else 
					   {
						   ++i;
					   }
				   }
				   
				   
				   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(filek);
					transformer.transform(source, result);
				   
				   
				   
			  } catch (Exception ex) {}
			
			
		}

		public static String getURL(String tagName) {
			// TODO Auto-generated method stub
			return getURL(tagName, torolheto, globalID);
		}
		
		public static String getURL(String tagName, File filek, int id) {
			try {
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(filek);
				Element rootElement = FileAdministrator.getElement(doc, id, tagName);
				return rootElement.getAttribute("link");
				
			} catch (Exception ex) {}
			return null;
		}

		public static void move(String tagName, String url, int x, int y, boolean accessory) {
			move(tagName, url,torolheto, globalID, x, y, accessory);
			
			//System.out.println(tagName + "/"+ url + " moved  " + x + "/" + y);
			
		}

		private static void move(String tagName, String url, File filek, int id, int x, int y, boolean accessory) {
			/*moded to xy*/
			try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
			   
			   
			   
			   if (accessory) {
				   System.out.println(accessory);
				   rootElement = (Element)rootElement.getChildNodes().item(rootElement.getChildNodes().getLength() - 1);  
			   }
			   
			   String xString = rootElement.getAttribute("x"); int xR = Integer.parseInt(xString); x = x + xR; 
			   String yString = rootElement.getAttribute("y"); int yY = Integer.parseInt(yString);y = y + yY;
			   
			//   System.out.println(x + "ferike");
			   
			   rootElement.getAttributeNode("x").setValue("" + x);
			   rootElement.getAttributeNode("y").setValue("" + y);
			   
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(filek);
				transformer.transform(source, result);
			   
			} catch (Exception ex) {}
			
		}

		public static void resize(String tagName, String url, int w, int h, boolean accessory) {
			// TODO Auto-generated method stub
			resize(tagName, url, torolheto, globalID, w, h, accessory);
			
		}

		private static void resize(String tagName, String url, File filek, int id, int w, int h, boolean accessory) {
			// TODO Auto-generated method stub
			try {
				  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				   Document doc = dBuilder.parse(filek);
				   
				   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
				   
				   
				   if (accessory) {
					   System.out.println(accessory);
					   rootElement = (Element)rootElement.getChildNodes().item(rootElement.getChildNodes().getLength() - 1);  
				   }
				   
				   
				   rootElement.getAttributeNode("w").setValue("" + w);
				   rootElement.getAttributeNode("h").setValue("" + h);
				   
				   
				   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(filek);
					transformer.transform(source, result);
				   
				} catch (Exception ex) {}
			
			
		}

		public static void setColor(String tagName, String url, int red, int green, int blue, boolean accessory) {
			// TODO Auto-generated method stub
			setColor(tagName, url, red, green, blue, torolheto, globalID, accessory);
			
		}

		private static void setColor(String tagName, String url, int red, int green, int blue, File filek,
				int id, boolean accessory) {
			
			try {
			// TODO Auto-generated method stub
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
			   
			   
			   if (accessory) {
				  // System.out.println(accessory);
				   rootElement = (Element)rootElement.getChildNodes().item(rootElement.getChildNodes().getLength() - 1);  
			   }
			   
			   rootElement.getAttributeNode("r").setValue(red + "");
			   rootElement.getAttributeNode("g").setValue("" + green);
			   rootElement.getAttributeNode("b").setValue("" + blue);
			   
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(filek);
				transformer.transform(source, result);
				
				//System.out.println("red" + red);
			   
			} catch (Exception ex) {}
			
		}

		public static void modifyByLink(String string, String item) {
			// TODO Auto-generated method stub
			modifyByLink(string, item, torolheto, globalID);
			
		}

		private static void modifyByLink(String tagName, String url, File filek, int id) {
			// TODO Auto-generated method stub
			try {
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
			   rootElement.getAttributeNode("link").setValue(url);
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(filek);
				transformer.transform(source, result);
			   
			} catch (Exception ex) {}
			
		}

		public static int[] getWidthHightOfTag(String tagName, boolean accessory) {
			return getWidthHightOfTag(tagName, torolheto, globalID, accessory);
			
		}

		private static int[] getWidthHightOfTag(String tagName, File filek, int id, boolean accessory) {
			// TODO Auto-generated method stub
			try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
			   
			   if (accessory) {
					  // System.out.println(accessory);
					   rootElement = (Element)rootElement.getChildNodes().item(rootElement.getChildNodes().getLength() - 1);  
				   }
			   
			   String url = "file:" + containerFile + "/" + tagName + "/" + rootElement.getAttribute("link");
			   
			   
			   int w = Integer.parseInt(rootElement.getAttribute("w"));
			   int h = Integer.parseInt(rootElement.getAttribute("h"));
			   int wh[] = {0, 0};
			   if (w == 0 || h == 0) {
				  Image img = new Image(url);
				  wh[0] = (int)img.getWidth();
				  wh[1] = (int)img.getHeight();
			   }
			   else 
			   {
				   wh[0] = w;
				   wh[1] = h;
			   }
			   return wh;
			   
			   
			   
			} catch (Exception ex) {}
			return null;
		}

		public static void saveInFile(File file) {
			// TODO Auto-generated method stub
			saveInFile(file, torolheto);
			
		}

		private static void saveInFile(File file, File filek) {
			// TODO Auto-generated method stub
			try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			   Document doc = dBuilder.parse(filek);
			   
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();;
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);
				filek = file;
			   
			} catch (Exception ex) {}
			   
			
		}

		public static void setFile(File file) {
			// TODO Auto-generated method stub
			torolheto = file;
			
		}
		
		
		public static void fit() {
			fit (torolheto, globalID);
		}
		
		public static void fit(File filek, int id ) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(torolheto);
				
				
				Element myRoot = FileAdministrator.getElementByAtribute(doc, id);
				
				Element elek;
				
				
				final String constans = "----link----";
				
				
				NodeList nList = myRoot.getChildNodes();
				
				Element first = (Element)nList.item(0);
				
				int fitNumber = (Integer.parseInt(first.getAttributeNode("f").getValue()) - 180) * (-1);
				

				
				System.out.println("fit number: " + fitNumber);
				
				for (int i = 0; i < nList.getLength(); ++i) {
					
					//System.out.print(" i");
					
					elek = (Element)nList.item(i);
					String nezd = elek.getAttribute("link");
					
					if (!nezd.equals(constans)) {
						elek.getAttributeNode("f").setValue(fitNumber + "");
						
						
						//System.out.println("megvan");
					} else {
						
						if (FileAdministrator.isAccessory(elek.getTagName())) {
							NodeList nya = elek.getChildNodes(); 
						if (nya.getLength() > 0) {
							for (int j = 0; j < nya.getLength(); ++j) {
								//System.out.println("faszfej");
								Element peti = (Element)nya.item(j);
								peti.getAttributeNode("f").setValue(fitNumber + "");
								
							}
						//	System.out.println("egy kirajzolva");
						}
							
						} else {
							elek.getAttributeNode("f").setValue(fitNumber + "");
						}
					}
				}
				
				
				 TransformerFactory transformerFactory = TransformerFactory.newInstance();;
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(filek);
					transformer.transform(source, result);
				
				
				
				} catch (Exception ex) {}	
		}

		public static int[] getRGB(String tagName, boolean accessory) {
			// TODO Auto-generated method stub
			return getRGB(tagName, accessory, globalID, torolheto);
		}
		
		private static int[] getRGB(String tagName, boolean accessory, int id, File filek) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				   Document doc = dBuilder.parse(filek);
				   
				   Element rootElement = FileAdministrator.getElement(doc, id, tagName);
				   
				   if (accessory) {
						  // System.out.println(accessory);
						   rootElement = (Element)rootElement.getChildNodes().item(rootElement.getChildNodes().getLength() - 1);  
					   }
				   
				   String url = "file:" + containerFile + "/" + tagName + "/" + rootElement.getAttribute("link");
				   
				   
				   int r = Integer.parseInt(rootElement.getAttribute("r"));
				   int g = Integer.parseInt(rootElement.getAttribute("g"));
				   int b = Integer.parseInt(rootElement.getAttribute("b"));
				   int wh[] = {r, g, b};
			
				   //System.out.println("r: " + r + "g  " + g + " b " + b);
				   return wh;
				   
				   
				   
				} catch (Exception ex) {}
				return null;
		}
		
		
}
