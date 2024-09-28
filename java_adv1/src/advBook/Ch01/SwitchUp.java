package advBook.Ch01;

public class SwitchUp {
    public static void main(String[] args) {
        classicSwitch(9);
        classicSwitchGrouping(9);
        expressionWithYield(9);
        expressionWithNewLabelling(9);
    }

    // 1. 전통적인 switch
    public static void classicSwitch(int month) {
        switch(month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            // ... and so on
            case 9:
                System.out.println("September");
                break;
            // ... and so forth
        }
    }

    // 2. switch 그룹핑
    public static void classicSwitchGrouping(int month) {
        switch(month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter, brrrr");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring has sprung!");
                break;
            // ... and so on
        }
    }

    // 3. 자바14에서 도입된 문법
    // yield를 사용하여 case에서 반횐된 값을 사용합니다.
    public static void expressionWithYield(int month) {
        String message = switch(month) {
            case 12:
            case 1:
            case 2:
                yield "Winter, brrrr";
            case 3:
            case 4:
            case 5:
                yield "Spring has sprung!";
            case 6:
            case 7:
            case 8:
                yield "Summer is here!";
            case 9:
            case 10:
            case 11:
                yield "Fall has descended on us";
            default:
                throw new IllegalArgumentException("Oops, that's not a month");
        };
        System.out.println(message);
    }

    // 4. 자바 14에서 도입된 문법
    // ->(화살표) 구문을 사용하여 더 간결하게 작성할 수 잇습니다.
    public static void expressionWithNewLabelling(int month) {
        String message = switch(month) {
            case 1, 2, 12  -> "Winter, brrrr";
            case 3, 4, 5   -> "Spring has sprung!";
            case 6, 7, 8   -> "Summer is here!";
            case 9, 10, 11 -> "Fall has descended on us";
            // If we exclude default, code won't compile as the switch misses branches
            default -> { throw new IllegalArgumentException("Oops, that's not a month"); }
        };
        System.out.println(message);
    }
}
