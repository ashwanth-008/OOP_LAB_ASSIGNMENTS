package comparetwonos;
public class CompareNumbers {
    public String compare(int a,int b){
        if(a>b){
            return a+" is larger.";
        }
        else if(a<b){
            return b+" is larger.";
        }
        else{
            return "Numbers are equal.";
        }
        }
    }
