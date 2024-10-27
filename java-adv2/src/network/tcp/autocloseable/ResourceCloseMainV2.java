package network.tcp.autocloseable;

import java.util.Objects;

public class ResourceCloseMainV2 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("CloseException 예외 처리");
            throw e;
        } finally {
            System.out.println("자원 정리");
            if (Objects.nonNull(resource2)) {
                resource2.closeEx();
            }

            if(Objects.nonNull(resource1)) {
                resource1.closeEx();
            }

        }
    }
}
