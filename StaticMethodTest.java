class Parent {
    void display() {
        System.out.println("Static method from Parent class");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Static method from Child class");
    }
}

public class StaticMethodTest {
     public static void main(String[] args) {
        Parent p = new Child();  
        p.display();             

        Child c = new Child();
        c.display();            
    }
}


   