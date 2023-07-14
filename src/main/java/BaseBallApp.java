import db.DBInit;

public class BaseBallApp {
    public static void main(String[] args) {
        // 1. TearDown
        DBInit.teardown();
    }
}