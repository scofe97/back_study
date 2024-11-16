package annotation.validator;

import static util.MyLogger.log;

public class ValidatorV2Main {


    public static void main(String[] args) {
        User user = new User("user1", 11);
        Team team = new Team("user1", 11);

        try {
            log("=== user 검증 ===");
            Validator.validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("=== team 검증 ===");
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
}
