package CLI;

import java.util.ArrayList;

public class Parser {
    private String[] args;
    private String cmd;
    private ArrayList<String> LOC = new ArrayList<String>();
    private int counter;

    Parser() {
        args = new String[2];
        cmd = null;
        counter = 0;
        LOC.add("cd");
        LOC.add("ls");
        LOC.add("cp");
        LOC.add("cat");
        LOC.add("more");
        LOC.add("<");
        LOC.add("<<");
        LOC.add("mkdir");
        LOC.add("rmdir");
        LOC.add("mv");
        LOC.add("rm");
        LOC.add("args");
        LOC.add("date");
        LOC.add("help");
        LOC.add("pwd");
        LOC.add("clear");
    }

    public int size() {
        return counter;
    }

    public boolean validate(String cmd) {
        if (LOC.contains(cmd))
            return true;
        else
            return false;
    }

    public boolean parse(String input) {
        String[] Substrings = input.split(" ", 3);

        for (int i = 0; i < Substrings.length; i++) {
            if (Substrings[i].contains(" ")) {
                System.out.println("error due to an issue in input");
                return false;
            }
        }
        if (Substrings.length > 1) {
            counter = 0;
            for (int i = 0; i < Substrings.length - 1; i++) {
                args[i] = Substrings[i + 1];
                counter++;
            }

        }
        if (validate(Substrings[0])) {
            this.cmd = Substrings[0];
            return true;
        } else {
            return false;
        }
    }

    public String getCmd() {
        return cmd;
    }

    public String[] getArguments() {
        return args;
    }
}

