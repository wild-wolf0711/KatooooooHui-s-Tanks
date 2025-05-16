package Grammar.Enum;

import java.util.Scanner;

/**
 * @author KatooHui
 * @version 1.0
 * @creats 2025-04-21-16:33
 */

interface func {
    public void show();
}

enum Color implements func {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color() {
    }

    Color(int r, int g, int b) {
        redValue = r;
        greenValue = g;
        blueValue = b;
    }

    public void show() {
        System.out.println("redValue = " + redValue);
        System.out.println("greenValue = " + greenValue);
        System.out.println("blueValue = " + blueValue);
    }
}

class Instance2 {
    public static void main(String[] args) {
        String color;
        Scanner scanner = new Scanner(System.in);
        color = scanner.next();
        Color.valueOf(color).show();

        switch (Color.valueOf(color)) {
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
        }
    }
}
