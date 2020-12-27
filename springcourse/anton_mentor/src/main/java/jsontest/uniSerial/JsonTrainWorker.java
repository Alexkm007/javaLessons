package jsontest.uniSerial;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonTrainWorker implements JsonSerializer<Train>, JsonDeserializer<Train> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy - hh:mm");

    @Override
    public Train deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String from = jsonObject.get("from").getAsString();
        String to   = jsonObject.get("to").getAsString();
        Date date   = new Date();

        try{
        date = sdf.parse(jsonObject.get("depatrureTime").getAsString());}
        catch (ParseException e){
            e.printStackTrace();
        }

        return new Train(from,to,date);
    }

    @Override
    public JsonElement serialize(Train train, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jObject = new JsonObject();
        jObject.addProperty("from",train.getFrom());
        jObject.addProperty("to",train.getTo());
        jObject.addProperty("depatrureTime",sdf.format(train.getDepatrureTime()));
        return jObject;
    }
}
