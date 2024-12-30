package tests.api2.controller;

public class Controller1 {
    
    public static int length(String data){
        return data.length();
    }

    public static int lengthT(String data){
        char[] table = data.toCharArray();
        return table.length;
    }

    public static String concat(String s1, String s2) {
        return (s1.compareTo(s2) < 0) ? s1.concat(s2) : s2.concat(s1);
    }

    public static boolean estEgal(char[] t1,char[] t2){
        if(t1.length != t2.length){
            return    false;
        }
        for(int i = 0; i < t1.length ; i++){
            if(t1[i] != t2[i]){
                return false;
            }
        }
        return true;
        // return Arrays.equals(t1, t2);
        // String.valueOf(t1).equalsIgnoreCase(String.valueOf(t1));
    }

}
