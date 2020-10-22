package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void testMatrixAdditionEqualDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 4, 5, 6 }, { 1, 2, 3 } };
    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 2, 3);

    int[][] expectedValues = { { 5, 7, 9 }, { 5, 7, 9 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 3);

    assertEquals(
      "Should add two matrices if the dimensions are same",
      expectedMatrix,
      matrix1.add(matrix2)
    );
  }

  @Test
  public void testMatrixAdditionUnequalDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 4, 5, 6 }, { 1, 2, 3 }, { 1, 2, 3 } };
    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 3, 3);

    assertNull(
      "Should not add two matrices if the dimensions are different",
      matrix1.add(matrix2)
    );
  }

  @Test
  public void testMatrixSubtractionSameDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 0, 2, 4 }, { 1, 3, 9 } };

    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 2, 3);

    int[][] expectedValues = { { 1, 0, -1 }, { 3, 2, -3 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 3);

    assertEquals(
      "Should subtract two matrices if the dimensions are same",
      expectedMatrix,
      matrix1.subtract(matrix2)
    );
  }

  @Test
  public void testMatrixSubtractionDifferentDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 4, 5, 6 }, { 1, 2, 3 }, { 1, 2, 3 } };
    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 3, 3);

    assertNull(
      "Should not subtract two matrices if the dimensions are different",
      matrix1.subtract(matrix2)
    );
  }

  @Test
  public void testMatrixMultiplicationProperDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 0, 2 }, { 1, 3 }, { 5, 7 } };

    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 3, 2);

    int[][] expectedValues = { { 17, 29 }, { 35, 65 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);

    assertEquals(
      "Should multiply two matrices if the dimensions are proper",
      expectedMatrix,
      matrix1.multiply(matrix2)
    );
  }

  @Test
  public void testMatrixMultiplicationImproperDimension() {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 0, 2, 1 }, { 3, 5, 7 } };

    Matrix matrix1 = new Matrix(array1, 2, 3);
    Matrix matrix2 = new Matrix(array2, 2, 3);

    assertNull(
      "Should not multiply two matrices if the dimensions are not proper",
      matrix1.multiply(matrix2)
    );
  }

  @Test
  public void testMatrixDeterminantSingleElement() {
    int[][] array1 = { { 3 } };
    Matrix matrix1 = new Matrix(array1, 1, 1);

    assertEquals(
      "Should calculate determinant of a single element matrix",
      matrix1.determinant(),
      3
    );
  }

  @Test
  public void testMatrixDeterminantOfSizeTwo() {
    int[][] array1 = { { 6, 3 }, { 6, 9 } };
    Matrix matrix1 = new Matrix(array1, 2, 2);

    assertEquals(
      "Should calculate determinant of a matrix of size two",
      matrix1.determinant(),
      36
    );
  }

  @Test
  public void testMatrixDeterminantOfSizeMoreThanTwo() {
    int[][] array1 = { { 6, 3, 0 }, { 1, 6, 9 }, { 1, 4, 7 } };
    Matrix matrix1 = new Matrix(array1, 3, 3);

    assertEquals(
      "Should calculate determinant of a matrix of size more than two",
      matrix1.determinant(),
      42
    );
  }
}
