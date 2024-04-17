import java.util.*;

public class Matrix {

  public static int determinant(int[][] matrix) {
    int n = matrix.length;
    if (n == 1) {
      return matrix[0][0];
    }

    int[][] tmp = new int[n - 1][n - 1];
    for (int i = 1; i < n; i++) {
      tmp[i - 1] = Arrays.copyOfRange(matrix[i], 1, n);
    }
    int determinant = matrix[0][0] * determinant(tmp);
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        tmp[j - 1][i - 1] = matrix[j][i - 1];
      }
      if (i % 2 == 0) {
        determinant += matrix[0][i] * determinant(tmp);
      } else {
        determinant -= matrix[0][i] * determinant(tmp);
      }
    }

    return determinant;
  }
}
