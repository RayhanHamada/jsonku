package org.jsonq.tester;

import org.jsonq.core.extras.JSONFile;
import org.jsonq.core.jsonvalue.JSONObject;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile file = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonq\\src\\main\\java\\org\\jsonq\\tester\\j2.json");
        file.getJSONObject().getJSONObjectOf("objek").getJSONArrayOf("nama").setStringAt(2, "henlo");
//        System.out.println(file.getStringRepr());

        System.out.println();
        System.out.println(file.getJSONObject().getJSONObjectOf("objek").getJSONArrayOf("nama").getObjectAt(1).getJSONStringOf("orang").getValue());
//        System.out.println(file.getJSONObject().getJSONObjectOf("objek").getJSONArrayOf("nama").getStringAt(2).getValue());
        file.dump();

//        System.out.println(file.getJSONObject().getJSONObjectOf("objek").getJSONArrayOf("nama").getValue());

    }
}
