import java.util.Scanner;

public class Matrix {


    public int[][] makeMatrix(int num) {
        int[][] mat = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j || i == num - j - 1)
                    mat[i][j] = 1;
            }
        }
        return mat;
    }

    public int enterFromKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int num = scan.nextInt();
        return num;
    }

    public void print(int[][] nums) {
        for (int[] row : nums) {
            for (int i : row) {
                System.out.print(i);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int razm = matrix.enterFromKeyboard();
        matrix.print(matrix.makeMatrix(razm));
    }

}
