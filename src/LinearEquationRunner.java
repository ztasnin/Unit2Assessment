import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        // variables and abbreviations :
        String cd1; //coordinate 1
        String cd2; //coordinate 2
        int ioc1; //index of comma in first coordinate
        int ioc2; //index of comma in second coordinate

        System.out.println("Welcome!");

        //coordinate 1 info
        System.out.print("Enter the first coordinate: ");
        cd1 = scan.nextLine();
        ioc1 = cd1.indexOf(",");
        int x1 = Integer.parseInt(cd1.substring(1, ioc1));
        int y1 = Integer.parseInt(cd1.substring(ioc1+2, cd1.length()-1));

        //coordinate 2 info
        System.out.print("Enter the second coordinate: ");
        cd2 = scan.nextLine();
        ioc2 = cd2.indexOf(",");
        int x2 = Integer.parseInt(cd2.substring(1, ioc2));
        int y2 = Integer.parseInt((cd2.substring(ioc2+2, cd2.length()-1)));


        if (x1 == x2){ //checking for vertical lines
            System.out.println("These points are on a vertical line: x = " + x1);
        } else {
           LinearEquation equation1 = new LinearEquation(x1, y1, x2, y2);
           System.out.println(equation1.lineInfo());

           System.out.print("Enter a value for x: ");
           double trialx = scan.nextDouble();
           System.out.println("The point on the line is: " + equation1.coordinateForX(trialx));
        }


    }
}
