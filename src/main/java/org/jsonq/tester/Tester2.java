package org.jsonq.tester;

import org.jsonq.core.extras.JSONFile;
import org.jsonq.core.jsonvalue.JSONNumber;
import org.jsonq.core.jsonvalue.JSONString;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile file = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonq\\src\\main\\resources\\j2.json");
//        file.getJSONObject().getJSONArrayOf("nama").addString("wew");
        System.out.println(file.getJSONObject().getJSONArrayOf("nama").getStringAt(0).getLiteralValue());
        file.dump();



    }


}
