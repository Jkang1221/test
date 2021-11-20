package com.homework.hw3_J_Liang;

public class hw3 {
    public static void main(String[] args) {
        IDLList idlList = new IDLList();
        idlList.add(0, 'c');
        idlList.add(1, 'b');
        idlList.add(1, 'z');
        idlList.add(0, 'a');
        idlList.add(2);
        idlList.append(5);
        System.out.println(idlList.toString());
        System.out.println(idlList.get(3));
        System.out.println(idlList.getHead());
        System.out.println(idlList.getLast());
        System.out.println(idlList.size());
        System.out.println(idlList.remove());
        System.out.println(idlList.toString());
        System.out.println(idlList.removeLast());
        System.out.println(idlList.toString());
        System.out.println(idlList.removeAt(1));
        System.out.println(idlList.toString());
        System.out.println(idlList.remove('b'));
        System.out.println(idlList);
    }
}
