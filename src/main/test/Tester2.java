import org.jsonku.core.extras.JSONFile;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile jsonFile = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonku\\src\\main\\test\\j1.json");
        jsonFile.getJSONArray().addNumbers(1,2,3);
        System.out.println(jsonFile.getContent());
        jsonFile.dump();


    }
}
