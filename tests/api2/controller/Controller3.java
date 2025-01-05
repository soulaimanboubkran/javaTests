package tests.api2.controller;

public class Controller3 {
    public static void afficher(String chaine)
    {
       StringBuilder ligne1=new StringBuilder(),ligne2=new StringBuilder();       
       for(int i=0;i<chaine.length();i++)
       {
         if(   ! String.valueOf(chaine.charAt(i)).trim().isEmpty() )
         {
             if(i %2 ==0 )
            //  ligne1=ligne1.concat(String.valueOf(chaine.charAt(i)));
             
                  ligne1.append(chaine.charAt(i));
             else
            //   ligne2=ligne2.concat(String.valueOf(chaine.charAt(i)));
               ligne2.append(chaine.charAt(i));           
           }
       }
        System.out.println(ligne1);
        System.out.println(ligne2);
    }    
}
