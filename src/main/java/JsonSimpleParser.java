import model.People;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Root;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {

    public Root parse(String fileName) {
        Root root = new Root();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            JSONObject rootObject = (JSONObject) parser.parse(reader);

            String name = (String) rootObject.get("name");
            JSONArray peopleArray = (JSONArray) rootObject.get("people");

            List<People> peopleList = new ArrayList<>();
            for (Object item : peopleArray) {
                JSONObject peopleObject = (JSONObject) item;

                String nameObject = (String) peopleObject.get("name");
                long ageObject = (Long) peopleObject.get("age");

                People people = new People(nameObject, (int) ageObject);
                peopleList.add(people);
            }

            root.setName(name);
            root.setPeople(peopleList);

            return root;
        } catch (Exception ex) {
            System.out.println("Parsing error: " + ex.toString());
        }

        return null;
    }
}
