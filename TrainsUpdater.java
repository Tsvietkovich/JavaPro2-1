package pro.lecture_2.Trains;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.File;
import java.io.IOException;

public class TrainsUpdater {
    private String path;
    private String pathUpdate;
    private final Document document;

    public TrainsUpdater(String path, String pathUpdate) {
        this.path = path;
        this.pathUpdate = pathUpdate;
        this.document = createDocument(path);
    }


    public  void addTrain(String id, String fromCity, String toCity, String dat, String time) {
        Element newNode = TrainsCreater.createTrain(this.document, id,  fromCity,  toCity,  dat, time);
        NodeList root = this.document.getElementsByTagName("trains");
        for (int i = 0; i < root.getLength(); i++) {
            root.item(i).appendChild(newNode);
        }
    }

    private static Document createDocument(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new File(path));
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }

     public void createXMLDocument () throws TransformerException {
        TrainsCreater.createXMLDoc(this.pathUpdate, this.document);
     }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathUpdate() {
        return pathUpdate;
    }

    public void setPathUpdate(String pathUpdate) {
        this.pathUpdate = pathUpdate;
    }
}

