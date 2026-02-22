class A{
    int a;
    char demo;
    String demo1;
    A(int a,char demo,String demo1){
        this.a = a;
        this.demo = demo;
        this.demo1=demo1;
    }
}
public class B extends A{
    int b;
    int demo3;
    B(int b,int demo3,int a,char demo,String demo1)
    {
        super(a,demo,demo1); //ACCESSES THE CONSTRUCTOR OF PARENT CLASS A
        this.b=b; //THIS REFERS TO CURRENT VALUE OF b
        this.demo3= demo3;
    }
    void display() {
        System.out.println("b: " + b);
        System.out.println("demo3: " + demo3);
        System.out.println("a: " + a);
        System.out.println("demo: " + demo);
        System.out.println("demo1: " + demo1);
    }
    public static void main(String[] args){
        B object = new B(12,15,17,'R',"Demo");
        object.display();
    }
}
