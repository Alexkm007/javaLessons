package homework9.jsonhw;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Massege {
    private String from;
    private String to;
    private String text;
    private Date dateSend;

    public Massege() {
    }

    public Massege(String from, String to, String text, Date dateSend) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.dateSend = dateSend;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh:mm");
        this.dateSend = dateSend;
    }

    @Override
    public String toString() {
        return "Massege{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                ", dateSend=" + dateSend +
                '}';
    }
}
