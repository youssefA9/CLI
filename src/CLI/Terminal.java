package CLI;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Terminal {

    public void cd(){}
    public void ls(){}
    public void cp(){}
    public void cat(File arr[],String fileName){

        String path=search(arr,fileName);

        if(path.equals("Not Found")){
            System.out.println("File :"+fileName+" is not found!");
            return;
        }
        File MyFile=new File(path);
        try{
            Scanner read=new Scanner(MyFile);
            while(read.hasNextLine()){
                System.out.println(read.nextLine());
            }
        } catch (FileNotFoundException e){
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

    public void more(){}
    public void mkdir(){}
    public void rmdir(){}
    public void mv(){}
    public void rm(File arr[],String fileName){
        String path=search(arr,fileName);
        if(path.equals("Not Found")){
            System.out.println("File :"+fileName+" is not found!");
            return;
        }
        File MyFile=new File(path);
        System.out.println(path);
       if(!MyFile.isDirectory()){
           MyFile.delete();
       }
        else{
            System.out.println("can't remove, it's not a file!");
       }

    }
    public void args(){}
    public void date(){}
    public void help(){}
    public void pwd(){}
    public void clear(){

        for(int i=0;i<9;i++){
            System.out.println();
        }
    }

    public String search(File arr[],String fileName){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getName().equals(fileName))
                return arr[i].getAbsolutePath();
        }
        return "Not Found";
    }

}
