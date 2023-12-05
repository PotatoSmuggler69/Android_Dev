


public class J01_hwl{
    public static void main(String[] args) {
        System.out.println("Hello world");
        Parent p = new Child();
        p.dis();
    }
}


class Parent{
    void dis(){
        System.out.println("I am the parent");
    }
}

class Child extends Parent{
    @Override
    void dis(){
        System.out.println("I am the child");
    }
}