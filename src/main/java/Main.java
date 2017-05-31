import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Main{
    static final int PORT = 80;

    public static void main(String[] args){
        System.out.println("Server : start port " + PORT);
        Scanner scanner = new Scanner(System.in);
        String echo = scanner.next();

        try{
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                Socket connect = server.accept();
                OutputStreamWriter out = new OutputStreamWriter(connect.getOutputStream());
                out.write(echo);
                out.flush();
                connect.close();
            }
        }
        catch(Exception err){
            System.out.println(err);
        }
    }
}