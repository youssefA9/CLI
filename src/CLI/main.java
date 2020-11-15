package CLI;

import java.util.Scanner;
import java.io.File;
import java.util.Vector;


public class main {
    public static File ex (boolean parse, String cmd, Vector<String> arguments, File[] arr, File file) {

        Terminal terminal = new Terminal();
        if (parse) {
            if (cmd.equals("cat")) {
                if (arguments.size() == 1) {
                    terminal.cat(arr, arguments.get(0));
                } else {

                    /*
                     * cat k.txt
                     * cat >
                     * */


                    terminal.cat(arr, arguments.get(0));
                    terminal.cat(arr, arguments.get(1));

                }
            } else if (cmd.equals("mv")) {
                terminal.mv(arguments.get(0), arguments.get(1));
            } else if (cmd.equals("cp")) {
                terminal.cp(arguments.get(0), arguments.get(1));
            } else if (cmd.equals("cd")) {
                File fx = terminal.cd(arguments.get(0), file);
                if (file.getAbsolutePath().equals(fx.getAbsolutePath()) && !(arguments.get(0).equals(file.getAbsolutePath()))) {
                    System.out.println("Path not found!");
                } else {
                    return fx;
                }

            } else if (cmd.equals("pwd")) {
                terminal.pwd(file);
            } else if (cmd.equals("ls")) {
                terminal.ls(file);
            } else if (cmd.equals("mkdir")) {
                System.out.println(terminal.mkdir(arguments.get(0), file));
            } else if (cmd.equals("clear")) {
                terminal.clear();
            } else if (cmd.equals("rm")) {
                if (arguments.size() == 1) {
                    terminal.rm(arr, arguments.get(0));
                }
            } else if (cmd.equals("date")) {
                terminal.date();
            } else if (cmd.equals("help")) {
                terminal.help();
            } else if (cmd.equals("rmdir")) {
                terminal.rmdir(arr, arguments.get(0));
            } else if (cmd.equals("more")) {
                terminal.more(arguments.get(0), file.getAbsolutePath());
            } else if (cmd.equals("args")) {
                terminal.args();
            } else {
                System.out.println("error");
                // rmdir all directories
                //rm all files
            }

        } else {
            System.out.println("error in parsing");
        }
        return file;

    }

    public static void main(String args[]) {
        //String defPath = "D:\\";

        Parser parser = new Parser();

        String cmd;
        Vector<String> arguments;
        boolean function;
        Scanner input = new Scanner(System.in);
        File file = new File("D:\\");
        while (true) {
            System.out.print("✔");
            File arr[] = file.listFiles();
            function = parser.parse(input.nextLine());
            cmd = parser.getCmd();
            arguments = parser.getArguments();
            file=ex(function,cmd,arguments,arr,file);


        }


    }

}

