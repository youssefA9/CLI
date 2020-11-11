package CLI;
import java.util.Scanner;
import java.io.File;
public class main {

    public static void main (String args[]){
        //String defPath = "D:\\";
        File file=new File("D:\\");
        Parser parser=new Parser();
        Terminal terminal=new Terminal();



       // System.out.println(defPath+">");
        String cmd;
        String[] arguments;
        boolean function;
        int size;
        Scanner input=new Scanner(System.in);
        while(true){
            File arr[]=file.listFiles();
            System.out.println(file.getAbsolutePath());
            function =parser.parse(input.nextLine());
            if(function) {
                cmd = parser.getCmd();
                arguments=parser.getArguments();
                size=parser.size();

                if(cmd.equals("cat")){
                 if(size==1){
                    terminal.cat(arr,arguments[0]);}
                   else {

                     terminal.cat(arr,arguments[0]);
                     terminal.cat(arr,arguments[1]);

                 }
                }else if(cmd.equals("clear")){
                    terminal.clear();
                }
                else if (cmd.equals("rm")){
                    if(size==1) {
                        terminal.rm(arr, arguments[0]);
                    }
                    else{
                        System.out.println("error");
                       // rmdir all directories
                        //rm all files
                    }
                }
            }


        }

    }
}
