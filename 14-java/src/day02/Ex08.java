package day02;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        char eng;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a character: ");
        eng = in.nextLine().charAt(0);
        System.out.println();
        
        in.close();
        

        switch (eng) {
            case 'a':
                System.out.print("Apple");
                break;
                case 'b':
                    System.out.print("Banana");
                    break;
                    case 'c':
                        System.out.print("Cherry");
                        break;
                        default:
                        System.out.println("Fruit");
                        break;
            }



    }
}
