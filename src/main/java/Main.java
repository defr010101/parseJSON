import model.Root;

public class Main {
    public static void main(String[] args) {
        GsonParser parser = new GsonParser();
        Root root = parser.parse("test.json");

        System.out.println(root);
    }
}
