import com.google.gson.Gson;
import model.Root;

import java.io.FileReader;

public class GsonParser {
    public Root parse(String fileName) {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {
            Root root = gson.fromJson(reader, Root.class);

            return root;
        } catch (Exception ex) {
            System.out.println("Parsing error: " + ex.toString());
        }

        return null;
    }
}
