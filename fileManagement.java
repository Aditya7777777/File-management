package FileManagementSystem;
import java.io.*;
import java.util.Scanner;

public class fileManagement{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("File management System");
            System.out.println("1.Create a file");
            System.out.println("2.Read a file");
            System.out.println("3.Update a file");
            System.out.println("4.Delete a file");
            System.out.println("5.Exit");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();//Consume the newline character

            switch(choice){
                case 1:
                  createFile();
                  break;

                case 2:
                    readFile();
                    break;
                case 3:
                    updateFile();
                    break;
                case 4:
                    deleteFile();
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    return;
                default:
                    System.out.println("Invalid option.Please try again");


            }


        }



    }

    private static void createFile(){
        System.out.print("Enter teh name of teh file to create");
        String fileName = sc.nextLine();

        try(FileWriter writer = new FileWriter(fileName)){
            System.out.println("Enter content to write to the file");
            String content = sc.nextLine();
            writer.write(content);
            System.out.println("File is created successfully");
        }catch(IOException e){
            System.out.println("An error occurred while creating an file ");
            e.printStackTrace();
        }
    }

    private static void readFile(){
        System.out.println("Enter the name of the file to read");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if(!file.exists()){
            System.out.println("File not found");
            return;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            System.out.println("File contents");
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("An error occurred while reading the file ");
            e.printStackTrace();
        }
    }

    private static void updateFile(){
        System.out.print("Enter the name of the file to update");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if(file.exists()){
            System.out.println("File not found");
            return;
        }

        try(FileWriter writer = new FileWriter(file,true)){
            System.out.print("Enter content to append to the file ");
            String content = sc.nextLine();
            writer.write(content + System.lineSeparator());
            System.out.println("File updated successfully");
        }catch(IOException e){
            System.out.println("An error occurred while updating the file ");
            e.printStackTrace();
        }
    }

    private static void deleteFile(){
        System.out.println("Enter the name of the file to delete");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if(file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.out.println("Failed to delete the file or file not found.");
        }
    }


}