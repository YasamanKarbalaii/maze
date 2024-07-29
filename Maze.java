import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Maze {
    private int Size;
    private int[][] Matrix;
    public Maze() {
    }

    //O(matrix.length*matrix.length)
    void File(String name) {
        int k = 0;
        String s;
        try {
            FileReader fr = new FileReader(name);
            Scanner fin = new Scanner(fr);
            Size = Integer.parseInt(fin.nextLine());
            Matrix = new int[Size + 2][Size + 2];
            for (int j = 0; j < Matrix.length; j++) {
                Matrix[0][j] = 1;
            }
            for (int j = 0; j < Matrix.length; j++) {
                Matrix[Matrix.length - 1][j] = 1;
            }
            for (int i = 0; i < Matrix.length; i++) {
                Matrix[i][0] = 1;
            }
            for (int i = 0; i < Matrix.length; i++) {
                Matrix[i][Matrix.length - 1] = 1;
            }
            for (int i = 1; i < Matrix.length - 1; i++) {
                s = fin.nextLine();
                for (int j = 1; j < Matrix.length - 1; j++) {
                    Matrix[i][j] = Integer.parseInt(String.valueOf(s.charAt(k)));
                    if (k < s.length()) {
                        k++;
                    }
                }
                k = 0;
            }
        } catch (Exception var12) {
            System.out.println(var12.getMessage());
        }

    }

    //O(matrix.length*matrix.length)
    void Write() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("** Write matrix **");
        int size, k = 0,p=1;
        String s;
        Scanner in = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("Maze.txt");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Enter size of matrix: ");
            size = in.nextInt();
            fw.write(size + "\n");
            while (p != size+1) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Enter the line " + p + ":");
                s = in.next();
                fw.write(s + "\n");
                p++;
            }
            fw.close();
            File("Maze.txt");
        } catch (Exception var12) {
            System.out.println(var12.getMessage());
        }
    }

    //O(matrix.length)
    void Move() {
        Stack i = new Stack((Size + 2) * (Size + 2));
        Stack j = new Stack((Size + 2) * (Size + 2));
        int row = 1, col = 1;
        boolean yes = false;
        Matrix[1][1] = 2;
        while (row < Matrix.length - 1 && col < Matrix.length - 1) {
            if (Matrix[row - 1][col] == 0) {
                yes = true;
                row--;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row][col + 1] == 0) {
                yes = true;
                col++;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row + 1][col] == 0) {
                yes = true;
                row++;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row][col - 1] == 0) {
                yes = true;
                col--;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row - 1][col + 1] == 0) {
                yes = true;
                row--;
                col++;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row + 1][col + 1] == 0) {
                yes = true;
                row++;
                col++;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row + 1][col - 1] == 0) {
                yes = true;
                row++;
                col--;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            } else if (Matrix[row - 1][col - 1] == 0) {
                yes = true;
                row--;
                col--;
                i.push(row);
                j.push(col);
                Matrix[row][col] = 2;
            }
            if (yes == false) {
                Matrix[row][col] = 3;
                i.pop();
                j.pop();
                row = i.pop();
                col = j.pop();
                i.push(row);
                j.push(col);
            }
            if (row == Matrix.length - 2 && col == Matrix.length - 2) {
                break;
            }
            yes = false;
        }
    }

    //O(matrix.length*matrix.length)
    void Print() {
        System.out.println("--------------------------------------------------------------------");
        for (int i = 0; i < Matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < Matrix.length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println(" ]");
        }
    }
}