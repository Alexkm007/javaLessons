package homework9.jsonhw;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MassegeJsonWorker implements JsonSerializer<Massege>, JsonDeserializer<Massege> {
   SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh:mm");

    @Override
    public Massege deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String from = jsonObject.get("from").getAsString();
        String to = jsonObject.get("to").getAsString();
        String text = jsonObject.get("text").getAsString();
        Date dateSend = null;
        try {
            dateSend = sdf.parse(jsonObject.get("dateSend").getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Massege(from,to,text,dateSend);
    }

    @Override
    public JsonElement serialize(Massege massege, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jObject = new JsonObject();
        jObject.addProperty("from",massege.getFrom());
        jObject.addProperty("to",massege.getTo());
        jObject.addProperty("text",massege.getText());
        jObject.addProperty("dateSend",sdf.format(massege.getDateSend()));
        return jObject;
    }
}
