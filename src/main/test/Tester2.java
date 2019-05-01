import org.jsonku.core.extras.JSONFile;
import org.jsonku.core.jsonvalue.JSONObject;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile jsonFile = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonku\\src\\main\\test\\j1.json");
        JSONFile j2 = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonku\\src\\main\\test\\j2.json");


        JSONObject oj1 = jsonFile.getJSONObject();
        JSONObject oj2 = j2.getJSONObject();

        oj1.createObjectFrom("orang_lain", oj2);

        System.out.println(oj1.toString());
        jsonFile.update(oj1);
        jsonFile.dump();

    }
}
