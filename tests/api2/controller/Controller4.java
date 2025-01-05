package tests.api2.controller;




public class Controller4 {

    //Purpose: This method creates and returns a string consisting of the character caractere repeated nbrefois times.
    public static  String build(char caractere,int nbrefois)
    {
        
        StringBuffer cumulateur=new StringBuffer();
        if(nbrefois>0)
                for(int i=1;i<=nbrefois;i++)
                {
                    cumulateur.append(caractere);
                }
        
        return cumulateur.toString();
    }
    public static String combine(char car1,char car2,int nbre1,int nbre2)
    {
        StringBuffer cumulateur=new StringBuffer();
         cumulateur.append(build(car1, nbre1));
         cumulateur.append(build(car2, nbre2));
         cumulateur.append(build(car1, nbre1));
       return cumulateur.toString();
    }
    
}





