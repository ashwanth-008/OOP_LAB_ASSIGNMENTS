interface Function{
    public abstract int evaluate();
}
class Half implements Function{
    public int evaluate(int i){
        return i/2;
    }
}
public class Client{
    public static void main(String[] args){
        int values[]={2,4,6,8,10};
        Half Oper = new Half();
        int i;
        System.out.println("OLD ARRAY");
        for(i=0;i<5;i++){
            System.out.print(values[i]+"\t");
        }
        for(i=0;i<5;i++){
            values[i]=Oper.evaluate(values[i]);
        }
        System.out.println("\nNEW ARRAY");
        for(i=0;i<5;i++){
            System.out.print(values[i]+"\t");
        }
    }
}
