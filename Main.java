import java.io.FileReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Maze m=new Maze();
        int i,j;
        String name;
        while (true) {
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Enter 0 to read from file or enter 1 to write matrix : ");
            i = in.nextInt();
            switch (i){
                case 0:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.print("Enter name of file : ");
                    name=in.next();
                    m.File(name+".txt");
                    m.Move();
                    m.Print();
                    break;

                case 1:
                    m.Write();
                    m.Move();
                    m.Print();
                    break;
            }
            System.out.print("Finish or not ?? --> Yes = Enter 1 : ");
            j=in.nextInt();
            if(j==1)break;
        }
    }
}