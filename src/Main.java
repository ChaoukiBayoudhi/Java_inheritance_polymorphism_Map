import java.util.Scanner;

public class Main {
    public static int menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("your choice : ");
            choice = sc.nextInt();
        }while(choice<0);
        return choice;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}