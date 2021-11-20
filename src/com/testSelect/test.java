package com.testSelect;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 7, 1, 1, 5, 3, 5, 2, 1, 1, 1};
        int[] b = new int[]{1, 3, 5};
        int[] c = new int[]{2, 3};
        List res = new ArrayList();
        HashSet hsA = new HashSet();
        HashSet hsB = new HashSet();
        HashSet hsC = new HashSet();
        for (int i = 0; i < a.length; i++) {
            hsA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            hsB.add(b[i]);
        }
        for (int i = 0; i < c.length; i++) {
            hsC.add(c[i]);
        }
        //System.out.println(hsA.toString());
        int start;
        int end = 0;
        String as = Arrays.toString(a);
        as = as.replace(", ","");
        //System.out.println(hsB.toString());
        //System.out.println(hsC.toString());
        for (int i = 0; i < a.length; i++) {
            if (hsB.contains(a[i]) && !hsC.contains(a[i])) {
                //System.out.println(a[i]);
            }
            if (hsB.contains(a[i]) && !hsC.contains(a[i])) {
                start = end;
                end = i;
                res.add(as.substring(start, end));
            }
            //System.out.println(hsB.contains(a[i]));
        }
        System.out.println(res.toString());

    }
}
