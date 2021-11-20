package com.classic75.string;

import java.util.ArrayList;
import java.util.List;

public class encodeAndDecode271 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new ArrayList<>();
        //strs.add("heel");
       // strs.add("_ww");
         //strs.add("qytik1i;l");
        strs.add("BmI3FS~J9#vmk");
//["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
        System.out.println(codec.encode(strs));
        System.out.println(codec.decode(codec.encode(strs)));
    }
}

class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String s : strs) {

            sb.append(s.length());
            sb.append("\t");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length() - 1) {
            int index = s.indexOf("\t", i);
            int len = Integer.valueOf(s.substring(i,index));
            res.add(s.substring(index + 1, index + 1 + len));
            i = index + len + 1;
        }
        return res;
    }
}