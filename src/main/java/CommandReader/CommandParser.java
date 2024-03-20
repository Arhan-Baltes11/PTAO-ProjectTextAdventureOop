package src.main.java.CommandReader;

public class CommandParser {
    public void commandRead(String command) {
        String[] parsedInfo = command.split(" ");
        System.out.println(parsedInfo);
        if (parsedInfo[0] == "Go") {
            go();
        } else if (parsedInfo[0] == "Attack") {
            attackEnemy();
        }
    }

    public void commandResolve(Object action) {
        System.out.println(action.getClass().getCanonicalName());
    }
    private String go() {
        return null;
    }

    private void attackEnemy() {

    }
}
