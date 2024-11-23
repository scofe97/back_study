package org.example.chapter5;

import java.lang.reflect.RecordComponent;

public class TestMain5_1 {
    public static void main(String[] args) {
        Class<UserRecordEx> userRecordExClass = UserRecordEx.class;
        RecordComponent[] recordComponents = userRecordExClass.getRecordComponents();

        Rectangle rectangle = new Rectangle(new Origin(23, 42), 300, 400);

    }
}
