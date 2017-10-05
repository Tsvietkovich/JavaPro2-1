package pro.lecture_2.Trains;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class TrainsCreater {
    public static void main(String[] args) {
        String path = "E:\\JAVA\\Projects\\OOP\\src\\pro\\lecture_2\\Trains\\trains.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("trains");

            Element train1 = createTrain(doc,"1","Kiev","Donetsk","19.12.2017","15:00");
            root.appendChild(train1);

            Element train2 = createTrain(doc,"2","Lviv","Donetsk","19.12.2017","19:15");
            root.appendChild(train2);
            doc.appendChild(root);

            createXMLDoc(path,doc);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static Element createTrain (Document doc, String id, String fromCity, String toCity, String dat, String time){
        Element train = doc.createElement("train");
        train.setAttribute("id", id);
        Element from = doc.createElement("from");
        from.setTextContent(fromCity);
        train.appendChild(from);
        Element to = doc.createElement("to");
        to.setTextContent(toCity);
        train.appendChild(to);
        Element date = doc.createElement("date");
        date.setTextContent(dat);
        train.appendChild(date);
        Element departure = doc.createElement("departure");
        departure.setTextContent(time);
        train.appendChild(departure);
        return train;
    }
    public static void createXMLDoc (String path, Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File(path));
        transformer.transform(source, file);
    }
}
