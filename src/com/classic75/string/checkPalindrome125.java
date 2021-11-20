package com.classic75.string;

public class checkPalindrome125 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }else if (s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }
        }
        StringBuffer sb2 = new StringBuffer(sb.reverse());
        sb.reverse();
        System.out.println(sb.toString());
        if(sb.toString().equals(sb2.toString())){
            return true;
        }else{
            return false;
        }
    }
}
