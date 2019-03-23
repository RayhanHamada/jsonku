package org.jsonq;

import org.jsonq.core.customtools.JSONPair;
import org.jsonq.core.jsonvalue.JSONNumber;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<JSONPair> jp = new ArrayList<>();

        System.out.println(new JSONPair("q", new JSONNumber("1")).equals(new JSONPair("q", new JSONNumber("1"))));
    }
}
