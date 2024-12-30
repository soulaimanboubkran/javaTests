package tests.api2.view;
import java.util.Scanner;

import tests.api2.controller.Controller1;
public class view1 {
    public static void main(String[] args) {
        String mot1,mot2;
        Scanner clavier;


        System.out.println("tapez un mot: ");
        clavier = new Scanner(System.in);
        mot1 = clavier.nextLine();

        System.out.println("tapez un mot: ");
        clavier = new Scanner(System.in);
        mot2 = clavier.nextLine();
       
        System.out.println("Concaténation de '" + mot1 + "' et '" + mot2 + "' = " + Controller1.concat(mot1,mot2));
        char[] t1 = {'a', 'b', 'c'};
        char[] t2 = {'a', 'b', 'c'};
        System.out.println(Controller1.estEgal(t1, t2));
        System.out.printf("length of %s = %d \n",mot1,Controller1.length(mot1));

    }
}
