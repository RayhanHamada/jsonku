import org.jsonku.core.extras.JSONFile;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile jsonFile = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonku\\src\\main\\test\\j1.json");

        System.out.println(jsonFile.getJSONArray().getValueWithPointer("1/1/nama").toString());


    }
}
