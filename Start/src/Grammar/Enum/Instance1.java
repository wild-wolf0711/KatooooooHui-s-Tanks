package Grammar.Enum;

/**
 * @author KatooHui
 * @version 1.0
 * @creats 2025-04-14:48
 */
public class Instance1 {
    public static void main(String[] args) {
        Week[] days = Week.values();
        for(Week day : days){
            System.out.println(day.getName());
        }
    }
}

enum Week{
    MONDAY("周一"),TUESDAY("周二"),WEDNESDAY("周三"),
    THURSDAY("周四"),FRIDAY("周五"),SATURDAY("周六"),SUNDAY("周日");
    String name;
    private Week(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
