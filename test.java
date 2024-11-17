
// bubu.java
import java.io.*;

class Bubu {
    public int x;

    public Bubu(int a) {
        System.out.println("++ Bubu debut");
        x = a;
        System.out.println("++ Bubu x = " + x);
        System.out.println("++ Bubu fin");
    }

    public void detruire() {
        System.out.println("-- Bubu debut x = " + x);
        System.out.println("-- Bubu fin");
    }
}

class Toto {
    public Bubu bu;
    public int y;

    public Toto(int a, int b) {
        System.out.println("++ Toto debut");
        y = b;
        System.out.println("++ Toto y = " + y);
        bu = new Bubu(a);
        System.out.println("++ Toto fin");
    }

    public void detruire() {
        System.out.println("-- Toto debut y = " + y);
        bu.detruire();
        System.out.println("-- Toto fin");
    }
}

class Titi extends Toto {
    int z;

    Titi(int a, int b, int c) {
        super(a, a + b);
        System.out.println("++ Titi debut");
        z = c;
        System.out.println("++ Titi z = " + z);
        System.out.println("++ Titi fin");
    }

    public void detruire() {
        System.out.println("-- Titi debut z = " + z);
        System.out.println("-- Titi fin");
        super.detruire();
    }
}

class Test {
    public static void main(String argv[]) throws IOException {
        System.out.println("main debut construction");//main debut construction
        System.in.read();
        Toto to = new Toto(1, 2);
        //++ Toto debut
        //++ Toto y = " + 2
        //++ Bubu debut
        //++ Bubu x = " + 1
        //"++ Bubu fin"
        //"++ Toto fin"
        System.out.println("main milieu construction");//main milieu construction
        System.in.read();
        Titi ti = new Titi(3, 4, 5);
        //++ Toto debut
        //++ Toto y = " + 7
        //++ Bubu debut
        //++ Bubu x = " + 3
        //"++ Bubu fin"
        //"++ Toto fin"
        //++ Titi debut
        //++ Titi z = " + 5
        //++ Titi fin
        System.out.println("main fin construction");//main fin construction
        System.out.println("main debut destruction");//main debut destruction
        System.in.read();
        ti.detruire();
        //-- Titi debut z = " + 5
        //-- Titi fin
        //-- Toto debut y = " + 7
        //-- Bubu debut x = " + 3
        //-- Bubu fin
        //-- Toto fin
        ti = null;
        System.out.println("main milieu destruction");//main milieu destruction
        System.in.read();
        to.detruire();
        //-- Toto debut y = " + 2
        //-- Bubu debut x = " + 1
        //-- Bubu fin
        //-- Toto fin
        ti = null;
        System.out.println("main fin destruction");//main fin destruction
        System.in.read();
    }
}
