package CLI;


import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Terminal {

    public void redirect(String argument,File arr[],String fileName) throws IOException {
        String path=search(arr,fileName);
        if (path.equals("Not Found")) {
            System.out.println("File :" + fileName + " is not found!");
            return;
        }
        File Myfile= new File(path);

        if(argument.equals(">")){
            FileWriter fr=new FileWriter(Myfile,false);
        }
        else if(argument.equals(">>")){

        }
        else{
            System.out.println("error");
        }
    }
    public File cd(String str, File fx) {
        if (str.substring(1, 2).equals(":")) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        } else {
            File[] listOfFiles = fx.listFiles();
            for (File file : listOfFiles) {
                if (!fx.getPath().endsWith("\\")) {
                    if (file.getAbsolutePath().equals(fx.getAbsolutePath() + str)) {
                        return file;
                    }
                } else {
                    if (file.getAbsolutePath().equals(fx.getAbsolutePath() + str.substring(1))) {
                        return file;
                    }
                }
            }
        }
        return fx;
    }

    public void ls(File fx) {
        File[] listOfFiles = fx.listFiles();
        for (File file : listOfFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void cp(String seek_path, String org_path) {
        try{
            File file = new File(org_path);
            File temp = new File(seek_path);

            FileWriter fw = new FileWriter(seek_path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                fw.write(myReader.nextLine());
            }
            fw.close();
            myReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public void cat(File arr[], String fileName) {

        String path = search(arr, fileName);

        if (path.equals("Not Found")) {
            System.out.println("File :" + fileName + " is not found!");
            return;
        }
        File MyFile = new File(path);

        try {

            Scanner read = new Scanner(MyFile);
            FileWriter fw=new FileWriter("D:\\mm.txt");
            String line;
            while (read.hasNextLine()) {
                line=read.nextLine();
                System.out.println(line);
                fw.write(line);
                fw.write("\n");
            }
            read.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
   /* public void cat2file(File arr[],String fileName1,String fileName2){
        String path1=search(arr,fileName1);
        String path2=search(arr,fileName2);
        if(path1.equals("Not Found")){
            System.out.println("File :"+fileName1+" is not found!");
        }else if(path2.equals("Not Found")){
            System.out.println("File :"+fileName2+" is not found!");

        }
        File f1=new File(path1);
        File f2=new File(path2);
        StringBuilder FullFile= new StringBuilder();
        try{
            Scanner read=new Scanner(f1);
            while(read.hasNextLine()){
                FullFile.append(read.nextLine());
                FullFile.append("\n");
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        try{
            Scanner read=new Scanner(f2);
            while(read.hasNextLine()){
                FullFile.append(read.nextLine());
                FullFile.append("\n");
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        try{
            Files.write(f2.toPath(),FullFile.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
        }
    */

    public void more(String path, String realpath) {

        File MyFile = new File(realpath + "\\" + path);
        if (MyFile.exists()) {
            try {
                int counter = 0, in = 0;
                String line;
                FileInputStream f = new FileInputStream(MyFile);
                BufferedReader read = new BufferedReader(new InputStreamReader(f));
                Scanner input = new Scanner(System.in);

                while ((line = read.readLine()) != null) {
                    System.out.println(line);
                    counter++;

                    if (counter % 10 == 0) {
                        System.out.println(".......................................... More press 1 exit press 2");
                        in = input.nextInt();
                        if (in == 2)
                            break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    public String mkdir(String path, File fx) {
        if (path.substring(1, 2).equals(":")) {
            File file = new File(path);
            boolean flag = file.mkdir();
            if (flag) {
                return "Directory Has been created successfully";
            } else {
                return "Directory couldn't be created!";
            }
        } else {
            if (path.substring(0, 1).equals("\\")) {
                File file;

                file = new File(fx.getAbsolutePath() + path);

                boolean flag = file.mkdir();
                if (flag) {
                    return "Directory Has been created successfully";
                } else {
                    return "Directory couldn't be created!";
                }
            } else {
                return "Directory couldn't be created!";
            }
        }
    }

    public void rmdir(File arr[], String fileName) {
        String path = search(arr, fileName);
        if (path.equals("Not Found")) {
            System.out.println("File :" + fileName + " is not found!");
            return;
        }
        File MyFile = new File(path);
        if (MyFile.isDirectory()) {
            if (!MyFile.delete()) {
                System.out.println("can't remove, it's not an empty directory!");
            }
        }
    }

    public void mv(String org_path, String seek_path)  {
        try{
        File file = new File(org_path);
        File temp = new File(seek_path);

        FileWriter fw = new FileWriter(seek_path);
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            fw.write(myReader.nextLine());


        }
            fw.close();
            myReader.close();
            file.delete();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void rm(File arr[], String fileName) {
        String path = search(arr, fileName);
        if (path.equals("Not Found")) {
            System.out.println("File :" + fileName + " is not found!");
            return;
        }
        File MyFile = new File(path);
        System.out.println(path);
        if (!MyFile.isDirectory()) {
            MyFile.delete();
        } else {
            System.out.println("can't remove, it's not a file!");
        }

    }

    public void args() {
        try {
            File commands = new File("command.txt");
            File arguments = new File("args.txt");
            Scanner reader1 = new Scanner(commands);
            Scanner reader2 = new Scanner(arguments);
            while (reader1.hasNextLine()) {
                String Data1 = reader1.nextLine();
                String Data2 = reader2.nextLine();
                System.out.println(Data1 + " -->> " + Data2);
            }
            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
            e.printStackTrace();
        }
    }

    public void date() {
        Date date = new Date();
        System.out.println(date);
    }

    public void help() {
        System.out.println("Cat   ---> Display files");
        System.out.println("Clear ---> Clear the screen");
        System.out.println("Args  ---> List all command arguments");
        System.out.println("Rm    ---> Remove each specified file");
        System.out.println("Pwd   ---> Display current user directory");
        System.out.println("Is    ---> List each file or directory name");
        System.out.println("Rmdir ---> Remove each given empty directory");
        System.out.println("Date  ---> Display the current date and time");
        System.out.println("Mkdir ---> Create a directory with each given name");
        System.out.println("Cd    ---> Change the current directory to another");
        System.out.println(" >    ---> Redirect the input to be taken from a file");
        System.out.println("More  ---> Display the output in one directory only L by L ");
        System.out.println(" |    ---> Redirect the output of the previous command as in input to another command");
        System.out.println("Mv    ---> Move each other given file into a file with the same name in the directory ");
        System.out.println("Copy  ---> Copy each other given file into a file with the same name in that directory");
        System.out.println(" >>   ---> Redirect the stdout of the program before and appends it to the given file after");
        System.out.println("Exit  ---> Stop all");
    }

    public void pwd(File fx) {
        System.out.println(fx.getPath());
    }

    public void clear() {

        for (int i = 0; i < 9; i++) {
            System.out.println();
        }
    }

    public String search(File arr[], String fileName) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equals(fileName))
                return arr[i].getAbsolutePath();
        }
        return "Not Found";
    }

}
