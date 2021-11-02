package saves;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveLoader {
    public SaveLoader() {
        try {
            String file = "resources/save.json";
            String json = readFileAsString(file);
            //System.out.println(json);
            JsonParser parser = Json.createParser(new StringReader(json));
            JsonParser.Event e;
            while (parser.hasNext()) {
                e = parser.next();
                if (e.equals(JsonParser.Event.START_OBJECT)) {
                    continue;
                }
                if (e.equals(JsonParser.Event.KEY_NAME) ||
                        e.equals(JsonParser.Event.VALUE_STRING)) {
                    System.out.println(parser.getString());
                }
            }

        } catch (Exception e) {
            System.out.println("No file found");
        }
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public void CreateSave()   {

        try {

            // Get the file
            File f = new File("save.json");

            // Create new file
            // if it does not exist
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    }
