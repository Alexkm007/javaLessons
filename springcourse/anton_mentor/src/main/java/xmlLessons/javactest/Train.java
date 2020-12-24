package xmlLessons.javactest;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Train {

    private String from;
    private String to;
    private Date depatrureTime;

    public Train(String from, String to, Date depatrureTime) {
        super();
        this.from = from;
        this.to = to;
        this.depatrureTime = depatrureTime;
    }

    public Train() {
    }

    @XmlElement
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    @XmlJavaTypeAdapter(TrainsDateFormater.class)
    public Date getDepatrureTime() {
        return depatrureTime;
    }

    public void setDepatrureTime(Date depatrureTime) {
        this.depatrureTime = depatrureTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");

        return "Train{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", depatrureTime=" + sdf.format(depatrureTime) +
                '}';
    }
}
