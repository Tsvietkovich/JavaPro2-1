package pro.lecture_2.Trains;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class TrainsSercher {
    private final List<Train> listOftrains;
    private String path;

    public TrainsSercher(String path) {
        this.listOftrains = parseXMLfile(path);
        this.path = path;
    }

    public  String getTrainsByDeparture (String from, String to) {
        List<Train> currentList = new ArrayList<>();
        int hourFrom = Train.makeTime(from).getHour();
        int hourTo = Train.makeTime(to).getHour();
        listOftrains.removeIf(train -> train.getDeparture().getHour()>hourTo);
        listOftrains.removeIf(train -> train.getDeparture().getHour()<hourFrom);
        return listOftrains.toString();
    }


    public String getPath() {
        return path;
    }

    public List<Train> getListOftrains() {
        return listOftrains;
    }

    public void setPath(String path) {
        this.path = path;
    }

        private static List<Train> parseXMLfile (String path){
            List<Train> trainList = new ArrayList<>();
            Train train = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            try {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
                while (reader.hasNext()) {
                    XMLEvent xmlEvent = reader.nextEvent();
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();
                        if (startElement.getName().getLocalPart().equals("train")) {
                            train = new Train();
                            Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                            if (idAttr != null) {
                                train.setID(Integer.parseInt(idAttr.getValue()));
                            }
                        } else if (startElement.getName().getLocalPart().equals("from")) {
                            xmlEvent = reader.nextEvent();
                            train.setFrom(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("to")) {
                            xmlEvent = reader.nextEvent();
                            train.setTo(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("date")) {
                            xmlEvent = reader.nextEvent();
                            train.setDate(xmlEvent.asCharacters().getData());
                        }else if (startElement.getName().getLocalPart().equals("departure")){
                            xmlEvent = reader.nextEvent();
                            train.setDeparture(xmlEvent.asCharacters().getData());
                        }
                    }
                    if (xmlEvent.isEndElement()) {
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals("train")) {
                            trainList.add(train);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
            return trainList;
        }
    }
