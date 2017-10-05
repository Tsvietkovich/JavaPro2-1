package pro.lecture_2.Trains;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
public class Train {

    private Integer ID;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime departure;

    public Train() {
    }

    public Train(Integer ID, String from, String to, String date, String departure) {
        this.ID = ID;
        this.from = from;
        this.to = to;
        this.date = makeDate(date);
        this.departure = makeTime(departure);
    }



    public static LocalTime makeTime(String time){
        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime leettime = LocalTime.parse(time, germanFormatter);
        return leettime;
    }

    public static LocalDate makeDate (String date){
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse(date, germanFormatter);
        return xmas;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = makeDate(date);
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = makeTime(departure);
    }

    @Override
    public String toString() {
        return "Train{" +
                "ID='" + ID + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", departure=" + departure +
                '}';
    }
}


