
// abcde.java
import java.io.*;

class A {
    public A monA;

    public void maMethode() {
        imprimer(" A ");
    }

    public void saMethode() {
        monA.maMethode();
    }

    public void imprimer(String s) {
        System.out.println(s);
    }
}

class B extends A {
    public C monC;

    public void saMethode() {
        monC.maMethode();
    }
}

class C extends A {
    public B monB;

    public void maMethode() {
        imprimer(" C ");
    }

    public void saMethode() {
        monB.maMethode();
    }
}

class D extends B {
    public E monE;

    public void maMethode() {
        imprimer(" D ");
    }

    public void saMethode() {
        monE.maMethode();
    }
}

class E extends B {
    public D monD;

    public void maMethode() {
        imprimer(" E ");
    }
}

class M {
    public static void main(String argv[]) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();
        a.monA = b;
        b.monA = c;
        c.monA = d;
        d.monA = e;
        e.monA = a;
        b.monC = c;
        c.monB = b;
        d.monC = c;
        e.monC = c;
        d.monE = e;
        e.monD = d;
        a.maMethode();
        b.maMethode();
        c.maMethode();
        d.maMethode();
        e.maMethode();
        a.saMethode();
        b.saMethode();
        c.saMethode();
        d.saMethode();
        e.saMethode();
    }
}