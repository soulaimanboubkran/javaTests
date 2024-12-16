package tests;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
      //  int x=5;
      //  String val=String.valueOf(x);
      //  System.out.println(val);
        String ch = "soul soul 1 43 4";

        String regex = "\\d+";// D means not number
        int count=0;
        int sum=0;
        for(String item :ch.split("")){
            if(item.matches(regex)){
                count++;
                sum += Integer.parseInt(item);
            }
            
        }

System.out.println(count);
System.out.println(sum);
          // String[] blocs = ch.split(" ");
          // System.out.println(Arrays.toString(blocs));
       //int z = new Integer(ch).intValue();
       //System.out.println(z);

       //System.out.println("hello".toUpperCase());



    }
}
