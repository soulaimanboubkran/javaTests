class Less {
    public int n;

    public Less(int x) {
        n = x;
    }

    public String toString() {
        return "Less ! ";
    }

    public void test1() {
        System.out.println("Less.test1 : " + this.toString());
    }

    public void test2() {
        System.out.println("Less.test2 : " + this.n);
    }
}

class More extends Less {
    public int n;

    public More(int x, int y) {
        super(x);
        this.n = y;
    }

    public String toString() {
        return "More ! ";
    }

    public void test1() {
        super.test1();
        System.out.println(
                "More.test1 : " + this.toString() + super.toString());
    }

    public void test2() {
        super.test2();
        System.out.println("More.test2 : " + this.n + super.n);
    }

    public static void main(String argv[]) {
        More m = new More(1, 2);
        m.test1();
        //Less.test1 : " + Less ! 
        //More.test1 : " + More !  + Less !
        m.test2();
        //Less.test2 : " + 1
        //More.test2 : " + 2 + 1
        Less n = new Less(0);
    
        n.test1();
        //Less.test1 : " + Less ! 
        n.test2();
        //Less.test2 : " + 0
    }
}
