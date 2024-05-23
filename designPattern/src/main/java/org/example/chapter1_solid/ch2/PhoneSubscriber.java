package org.example.chapter1_solid.ch2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhoneSubscriber extends Subscriber{

    // 언제든 수정이 가능하다.
    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();

        // 계산 결과
        return (double) (totalDuration * baseRate) /100;
    }
}