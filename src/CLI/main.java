package CLI;
import java.util.Scanner;
public class main {

    public static void main (String args[]){
        String defPath = "D:\\";
        Parser obj=new Parser();
        System.out.println(defPath+">");
        Scanner input=new Scanner(System.in);
        String command=input.nextLine();
        System.out.println(obj.parse(command));
        System.out.println(obj.getCmd());
        String [] argss=obj.getArguments();
//       System.out.println(argss[0]);
       System.out.println(argss.length);

    }
}
