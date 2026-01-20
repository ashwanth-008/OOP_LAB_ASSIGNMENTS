/*Create a class called date that include three instance variable 
a) month (type int) 
b) day (type int) and 
c) year (type int). 
Provide a constructer that initialize a three instance variable and assume the value provided are correct. 
Provide a set and a get method for each instance variable.
Provide a method DisplayDate that display the month year and day separated by forward slash and 
write a test application named DateTest that demonstrate date capabilities. */
public class Date {
    private int month, day, year;
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }
    public void setDay(int x){
        this.day=x;
    }
    public void setMonth(int x){
        this.month=x;
    }
    public void setYear(int x){
        this.year=x;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}
