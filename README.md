# Tasks
public class TasksTsvietkovich {
    public static void main(String[] args) {
        int n = 7654321;
        System.out.println(n / 10_000 % 10);
        System.out.println(n / 1_000 % 10);
        System.out.println(n / 100 % 10);
        System.out.println(n / 10 % 10);
        System.out.println(n % 10);
    }
}
public class TaskAboutAvg {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int average;
        average = (a+b)/2;
        System.out.println("The average of 2 and 3 is : " + average);
        
     }
}
public class YearsMonthDays {
    public static void main(String[] args) {
        int days = 550;
        int day, year, month;
        year=days/360+1;
        month=days%360/30+1;
        day=days%360%30;
        System.out.println("Years" + " " + year);
        System.out.println("Monthes" + " " + month);
        System.out.println("Days" + " " + day);
    }
}
