package com.example.quarts.quarts.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

@Component
public class TriggersGlobalListener implements TriggerListener {
    @Override
    public String getName() {
        // 리스너의 이름을 반환합니다. 이 이름은 리스너를 식별하는 데 사용됩니다.
        return "MyTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        // 트리거가 발동됐을 때 호출됩니다.
        System.out.println("Trigger fired: " + trigger.getKey());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        // 작업 실행 여부를 결정합니다. true를 반환하면 작업 실행이 거부됩니다.
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        // 미발동된 트리거에 대해 호출됩니다.
        System.out.println("Trigger misfired: " + trigger.getKey());
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context,
                                Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        // 트리거 작업이 완료된 후 호출됩니다.
        System.out.println("Trigger completed: " + trigger.getKey());
    }
}
