package saves;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;



public class SaveManager {

    public SaveNumber[] saveNumbers = new SaveNumber[4];

    public void SaveLoader() {
        try {
            String file = "resources/save.json";
            String json = readFileAsString(file);
            //System.out.println(json);
            JsonParser parser = Json.createParser(new StringReader(json));
            JsonParser.Event e;
            int sn = 0;
            boolean active;
            while (parser.hasNext()) {
                e = parser.next();

                if (e.equals(JsonParser.Event.KEY_NAME) ||
                       e.equals(JsonParser.Event.VALUE_STRING)) {
                    //System.out.println(parser.getString());
                }

                // Checks which save is currently loading into object & if its active
                if (e.equals(JsonParser.Event.KEY_NAME)){
                    if (parser.getString().equals("save")){
                        parser.next();
                        parser.next();
                        parser.next();
                        sn = Integer.parseInt(parser.getString());
                        //System.out.println(sn);

                        parser.next();
                        parser.next();
                        active = Boolean.parseBoolean(parser.getString());
                        //System.out.println(active);
                        //saveNumbers[sn].setActive(active);
                    }
                    if (parser.getString().equals("name")){
                        parser.next();
                        //saveNumbers[sn].sc[0].setName(parser.getString());
                    }
                    if (parser.getString().equals("isAlive")){
                        parser.next();
                        //saveNumbers[sn].sc[0].setAlive(Boolean.parseBoolean(parser.getString()));
                    }
                    if (parser.getString().equals("location")){
                        parser.next();
                        parser.next();
                        //saveNumbers[sn].sc[0].setLocationX(Integer.parseInt(parser.getString()));
                        parser.next();
                        //saveNumbers[sn].sc[0].setLocationY(Integer.parseInt(parser.getString()));
                    }
                    if (parser.getString().equals("metrics")){
                        parser.next();
                        parser.next();
                        //saveNumbers[sn].sc[0].setHealth(Integer.parseInt(parser.getString()));
                        parser.next();
                        //saveNumbers[sn].sc[0].setStamina(Integer.parseInt(parser.getString()));
                    }
                }




            }

        } catch (Exception e) {
            System.out.println("No file found");
        }
    }

    public void SaveBuilder() throws IOException {
        JsonObject value = Json.createObjectBuilder()
                .add("save", Json.createObjectBuilder()
                        .add("ID" , "1")
                        .add("isActive", saveNumbers[0].isActive())
                        .add("char", Json.createObjectBuilder()
                                .add("name", saveNumbers[0].sc[0].getName())
                                .add("isAlive", saveNumbers[0].sc[0].isAlive())
                                .add("location", Json.createArrayBuilder()
                                        .add(saveNumbers[0].sc[0].getLocationX(), saveNumbers[0].sc[0].getLocationY()))
                                .add("metrics", Json.createArrayBuilder()
                                        .add(saveNumbers[0].sc[0].getHealth(), saveNumbers[0].sc[0].getStamina()))))
                .add("ID" , "2")
                .add("isActive", saveNumbers[1].isActive())
                .add("char", Json.createObjectBuilder()
                        .add("name", saveNumbers[1].sc[0].getName())
                        .add("isAlive", saveNumbers[1].sc[0].isAlive())
                        .add("location", Json.createArrayBuilder()
                                .add(saveNumbers[1].sc[0].getLocationX(), saveNumbers[1].sc[0].getLocationY()))
                        .add("metrics", Json.createArrayBuilder()
                                .add(saveNumbers[1].sc[0].getHealth(), saveNumbers[1].sc[0].getStamina())))
                .add("ID" , "3")
                .add("isActive", saveNumbers[2].isActive())
                .add("char", Json.createObjectBuilder()
                        .add("name", saveNumbers[2].sc[0].getName())
                        .add("isAlive", saveNumbers[2].sc[0].isAlive())
                        .add("location", Json.createArrayBuilder()
                                .add(saveNumbers[2].sc[0].getLocationX(), saveNumbers[2].sc[0].getLocationY()))
                        .add("metrics", Json.createArrayBuilder()
                                .add(saveNumbers[2].sc[0].getHealth(), saveNumbers[2].sc[0].getStamina())))

                .build();

        saveToFile(value);



    }

    public void saveToFile(JsonObject json)
            throws IOException {
        String str = json.toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/save.json"));
        writer.write(str);
        writer.close();
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


}
