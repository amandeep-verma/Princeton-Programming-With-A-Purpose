/* *****************************************************************************
 Write a code fragment to multiply two rectangular matrices that are not necessarily square.
 Note: For the dot product to be well defined, the number of columns in the first matrix must
 be equal to the number of rows in the second matrix. Print an error message if the dimensions
 do not satisfy this condition.
 **************************************************************************** */

public class MatrixMultiplication {
    public static void main(String[] args) {

        int[][] matrix1 = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 }
        };
        int[][] matrix2 = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 }
        };

        int matrix1Columns = matrix1[0].length;
        int matrix2Rows = matrix2.length;
        if (matrix1Columns == matrix2Rows) {
            int[][] product = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int k = 0; k < matrix2[0].length; k++) {
                    for (int j = 0; j < matrix1Columns; j++) {
                        // System.out.println("trace " + i + " " + k);
                        product[i][k] += matrix1[i][j] * matrix2[j][k];
                    }
                    System.out.print(product[i][k] + "\t");
                }
                System.out.println();
            }

        }
        else {
            System.out.println("error : dimensions do not satisfy this condition");
        }

    }
}
