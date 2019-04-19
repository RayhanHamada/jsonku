import org.jsonq.core.extras.JSONFile;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile file = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonq\\src\\main\\resources\\j2.json");
        System.out.println(file.getStringRepr());
        System.out.println(file.getJSONObject().getJSONObjectOf("objek").getJSONArrayOf("nama").getValueAt(2));

    }
}
