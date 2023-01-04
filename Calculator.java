package operators;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args)
    {
        System.out.println("Introduceti prima cifra:");
        Scanner inp= new Scanner(System.in);
        int a,b;
        a = inp.nextInt();
        System.out.println("Introduceti a doua cifra:");
        b = inp.nextInt();
        System.out.println("Operatia: 1)  +  2)  - 3)  *  4) / 5) ^ ");
        int choose;
        choose = inp.nextInt();
        switch (choose){
            case 1:
                System.out.println(Math.addExact( a,b));
                break;
            case 2:
                System.out.println(Math.subtractExact( a,b));
                break;
            case 3:
                System.out.println(Math.multiplyExact( a,b));
                break;
            case 4:
                System.out.println(Math.divideExact( a,b));
                break;
            case 5:
                System.out.println(Math.pow( a,b));
                break;
            default:
                System.out.println("Operatie imposibila");
        }
    }
}