package com.homework;

public class hw2 {
    public static void main(String[] args) {
        int n = 6;
        //method0(n);
        //method2(n);
        //method4(4);
        //method5(10000);
        //method4(4);
        //method6(4);
    }

    public static void method1(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Operation " + counter);
                counter++;
            }
        }
    }

    public static void method2(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("Operation " + counter);
                    counter++;
                }
            }
        }
    }

    //private static int count = 1;
    public static void method3(int n) {
        int counter = 1;
        int count = 1;
        while (counter < n) {
            System.out.println("Operation " + count);
            counter = counter * 2;
            count++;
        }
    }

    public static void method4(int n) {
        int counter;
        int count = 1;
        for (int i = 0; i < n; i++) {
            counter = 1;
            while (counter < n) {
                counter = counter * 2;
                System.out.println(count);
                count++;
            }
        }

    }

    private static int count = 1;

    public static void method5(int n) {
        int counter = 1;
        int m = 1;
        while (m < n) {
            m = m * 2;
            while (counter < (Math.log(n) / Math.log(2))) {
                counter = counter * 2;
                System.out.println("Operation " + count);
                count++;
            }
        }
    }

    private static int coun = 1;

    public static int method6(int n) {
        if (n == 1) {
            System.out.println(coun);
            coun++;
            return 1;
        }
        System.out.println(coun);
        coun++;
        return method6(n - 1) + method6(n - 1);
    }
}