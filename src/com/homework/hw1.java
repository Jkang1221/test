package com.homework;

import java.util.Arrays;


public class hw1 {
    public static void main(String[] args) {

        BinaryNumber binaryNumber1 = new BinaryNumber("1011");
        BinaryNumber binaryNumber2 = new BinaryNumber("1001");
        binaryNumber1.add(binaryNumber2);
        //binaryNumber2.shiftR(5);
        BinaryNumber binaryNumber3 = new BinaryNumber("1000");
        System.out.println(binaryNumber3.toString());
        binaryNumber1.add(binaryNumber3);
        System.out.println(binaryNumber1.toString());
    }
}

class BinaryNumber {
    private int data[];
    private boolean overflow = false;

    public BinaryNumber() {
    }

    public BinaryNumber(int length) {
        data = new int[length];
        for (int i = 0; i < length; i++) {
            this.data[i] = 0;
        }
    }

    public BinaryNumber(String str) {
        data = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '1') {
                this.data[i] = str.charAt(i) - 48;
            } else {
                throw new IllegalArgumentException("Input should be 0/1");
            }
        }
        //System.out.println(Arrays.toString(data));
        // System.out.println(arg.toString());
    }

    public int getLength() {
        return this.data.length;
    }

    public int getDigit(int index) {
        if (index < 0 || index > this.getLength()) {
            throw new NullPointerException("Please input vaild index!");
        }
        return data[index];
    }

    public int toDecimal() {
        int num = 0;
        for (int i = 0; i < this.data.length; i++) {
            num = (int) ((this.data[i] * Math.pow(2, i)) + num);
        }
        return num;
    }

    public void shiftR(int amount) {
        if (amount < 0) {
            throw new NullPointerException("Please input vaild amount!");
        }
        int[] newData = new int[amount + this.data.length];
        for (int i = 0; i < amount; i++) {
            newData[i] = 0;
        }
        for (int i = amount, j = 0; i < newData.length; i++, j++) {
            newData[i] = this.data[j];
        }
        data = newData;
    }

    public void add(BinaryNumber b2) {
        int len1 = this.getLength();
        int len2 = b2.getLength();
        //int n = Math.abs(len1 - len2);
        //补齐位数
        if (len1 != len2) {
            throw new NumberFormatException("Please input vaild binary number!");
        }
        int flag = 0;
        int[] newData = new int[len1];
        int num;
        for (int i = 0; i < len1; i++) {
            num = flag + b2.getDigit(i) + this.getDigit(i);
            if (num == 2) {
                flag = 1;
                newData[i] = 0;
            } else if (num == 3) {
                flag = 1;
                newData[i] = 1;
            } else {
                flag = 0;
                newData[i] = num;
            }
        }
        if (flag == 1) {
            this.overflow = true;
        }
        if (flag == 0) {
            this.data = newData;
        }

    }

    public void clearOverflow() {
        this.overflow = false;
    }

    @Override
    public String toString() {
        if (this.overflow == false) {
            return "BinaryNumber{" +
                    "data=" + Arrays.toString(this.data) +
                    '}';
        } else {
            this.clearOverflow();
            return "OverFlow";
/*            return "BinaryNumber{" +
                    "data=" + Arrays.toString(this.data) +
                    '}';*/
        }
    }

}

