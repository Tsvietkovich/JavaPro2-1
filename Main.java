package pro.lecture_2.Trains;

import org.w3c.dom.Element;

import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) {
        try {
        String path = "trains.xml";
        

        TrainsUpdater updater = new TrainsUpdater(path);
        updater.addTrain("3","Odessa","Vinnitsa","19.10.2017","20:00");
        updater.createXMLDocument();

        System.out.println(new TrainsSercher(path).getTrainsByDeparture("15:00", "19:00"));

        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
