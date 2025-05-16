package Grammar.SomeBase;

import java.util.Objects;
import java.util.Scanner;
public class StringEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int run = 1;
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入你的用户名");
            String user = scanner.next();
            if (user.equals("donk")) {
                System.out.println("请输入你的密码");
                String key = scanner.next();
                if (Objects.equals(key, "666")) {
                    System.out.println("密码正确");
                    run = 0;
                    break;
                } else {
                    System.out.println("密码错误，你还有" + (2 - i) + "次机会");
                }
            } else {
                System.out.println("用户名错误，你还有" + (2 - i) + "次机会");
            }
        }
        if(run == 1)
          System.out.println("你已被封锁");
    }
}