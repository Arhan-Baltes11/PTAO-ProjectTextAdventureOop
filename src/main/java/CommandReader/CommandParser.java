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

    private String go() {
        return null;
    }

    private void attackEnemy() {

    }
}
