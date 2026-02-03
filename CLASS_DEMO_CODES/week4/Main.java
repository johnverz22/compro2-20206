import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        StringBuilder  sb = new StringBuilder();
        //try-with-resource
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter a message: ");
            sb.append(sc.nextLine());
            System.out.print("Enter another message:");
            sb.append("Any message..");
            sb.append(sc.nextLine());
            sb.append("\n");
            sb.append(sc.nextInt());
        }catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }

        //try-catch
        try{
            FileWriter fw = new FileWriter("data.txt");
            fw.write(sb.toString());
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}