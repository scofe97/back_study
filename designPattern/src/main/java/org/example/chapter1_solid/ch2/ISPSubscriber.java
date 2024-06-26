package org.example.chapter1_solid.ch2;

import java.util.List;


public class ISPSubscriber extends Subscriber {

    private long freeUsage; // 추가 속성

    @Override
    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(subscriberId);
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();

        long chargeableData = totalData - freeUsage; // 추가 연산

        return (double) (chargeableData * baseRate) /100;
    }
    
}