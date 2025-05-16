package Grammar.SomeBase;

import java.util.Scanner;
public class scanner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("your name = ");
        String name = scanner.next();
        System.out.println("your age = ");
        int age = scanner.nextInt();
        System.out.println("your salary = ");
        double sal = scanner.nextDouble();
        System.out.println("name = " + name +"\nage = " + age + "\nsalary = " + sal);
        char ch = scanner.next().charAt(0);
    }
}
