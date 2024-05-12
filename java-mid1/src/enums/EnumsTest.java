package enums;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumsTest {

    public static void main(String[] args) {
        // 모든 요일을 포함하는 EnumSet 생성
        EnumSet<Week> week = EnumSet.allOf(Week.class);


        // 주말만 포함하는 EnumSet 생성
        EnumSet<Week> weekend = EnumSet.of(Week.SATURDAY, Week.SUNDAY);
        System.out.println("Week days: " + week);
        System.out.println("Weekend days: " + weekend);

        // Day 열거 타입을 키로 하고 String을 값으로 하는 EnumMap 생성
        EnumMap<Week, String> weekMap = new EnumMap<>(Week.class);

        // 각 요일에 대한 활동을 맵에 추가
        weekMap.put(Week.MONDAY, "Study Java");
        weekMap.put(Week.TUESDAY, "Work on project");
        weekMap.put(Week.WEDNESDAY, "Attend seminar");
        weekMap.put(Week.THURSDAY, "Write blog post");
        weekMap.put(Week.FRIDAY, "Review code");
        weekMap.put(Week.SATURDAY, "Relax");
        weekMap.put(Week.SUNDAY, "Plan for next week");

// 모든 요일과 해당 활동 출력
        for (Week day : Week.values()) {
            System.out.println(week + ": " + weekMap.get(day));
        }
    }
}
