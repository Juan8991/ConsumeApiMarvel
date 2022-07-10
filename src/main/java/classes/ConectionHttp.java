package classes;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectionHttp {
    static MessagesWithJboss message = new MessagesWithJboss();
    public void response(String heroName){
        String host="https://gateway.marvel.com:443/v1/public/characters?";
        String service="ts=1&name=";
        String publicApiKey="&apikey=3119d5d28905ba33310fd0d6f24a35be";
        String hash="&hash=a749cdbfb48efd147616b1a64b990703";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(host+service+heroName+publicApiKey+hash)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(ConectionHttp::parse)
                .join();
    }
    public static String parse(String responseBody){
        Gson gson = new Gson();
        try {
            // Convert JSON to Java Object
            GeneralInfo generalInfo = gson.fromJson(responseBody, GeneralInfo.class);
            Object generalObject = generalInfo.getData();
            // Convert Object to JSON
            String generalJson = gson.toJson(generalObject);
            // Convert JSON to Java Object
            Data dataObject = gson.fromJson(generalJson, Data.class);
            Integer heroId = dataObject.getPropertiesList().get(0).getId();
            String heroName = dataObject.getPropertiesList().get(0).getName();
            String heroDescription = dataObject.getPropertiesList().get(0).getDescription();
            message.printMessage("\nHeroe Id: "+heroId+", Nombre:"+heroName+", \nDescripción:"+heroDescription);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
