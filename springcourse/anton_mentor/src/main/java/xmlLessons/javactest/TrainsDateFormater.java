package xmlLessons.javactest;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainsDateFormater extends XmlAdapter<String, Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");

    @Override
    public Date unmarshal(String s) throws Exception {
        Date date = new Date();
        try {
        date = sdf.parse(s);
        }catch (ParseException e){
            System.out.println(e);
        }
        return date;
    }

    @Override
    public String marshal(Date date) throws Exception {
        return sdf.format(date);
    }
}
