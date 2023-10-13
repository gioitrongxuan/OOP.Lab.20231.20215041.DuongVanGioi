import java.util.Scanner;
//khi nhập ma trận, nhập hết phần tử hàng trước rồi sẽ tới hàng tiếp theo
public class AddMatrices {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Number of rows : "); 
       int row = scanner.nextInt();
       System.out.println("Number of columns : ");
       int column = scanner.nextInt();
       int[][] matrix1 = new int[row][column];
       int[][] matrix2 = new int[row][column];

       System.out.println("Matrix1 :");
       for (int i = 0; i < row; i++) {
              for (int j = 0; j < column; j++) {
                    matrix1[i][j] = scanner.nextInt();
              }
       }
       System.out.println("Matrix2 :");
       for (int i = 0; i < row; i++) {
              for (int j = 0; j < column; j++) {
                    matrix2[i][j] = scanner.nextInt();
              }
       }

       //addition of matrices.
       int[][] resultMatix = new int[row][column];
       for (int i = 0; i < row; i++) {
              for (int j = 0; j < column; j++) {
                    resultMatix[i][j] = matrix1[i][j] + matrix2[i][j];
              }
       }

       System.out.println("\nMatrix 1 : ");
       for (int i = 0; i < row; i++) {
              for (int j = 0; j < column; j++) {
                    System.out.print(matrix1[i][j] + " ");
              }
              System.out.println();
       }
 
           System.out.println("\nMatrix 2 : ");
           for (int i = 0; i < row; i++) {
                  for (int j = 0; j < column; j++) {
                        System.out.print(matrix2[i][j] + " ");
                  }
                  System.out.println();
           }
 
           System.out.println("\nThe sum of the two matrices is : ");
           for (int i = 0; i < row; i++) {
                  for (int j = 0; j < column; j++) {
                        System.out.print(resultMatix[i][j] + " ");
                  }
                  System.out.println();
           }
    }
    
}