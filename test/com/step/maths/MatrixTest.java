package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
  private Matrix testMatrix1;
  private Matrix testMatrix2;
  private Matrix testMatrix3;
  private Matrix testMatrix4;
  private Matrix testMatrix5;

  @Before
  public void initiateTestMatrices() {
    int[][] array1 = { { 1, 2 }, { 3, 4 } };
    int[][] array2 = { { 3, 4 }, { 1, 2 } };
    int[][] array3 = { { 3, 4 }, { 1, 2 } };
    int[][] array4 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[][] array5 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

    this.testMatrix1 = new Matrix(array1, 2, 2);
    this.testMatrix2 = new Matrix(array2, 2, 2);
    this.testMatrix3 = new Matrix(array3, 2, 2);
    this.testMatrix4 = new Matrix(array4, 3, 3);
    this.testMatrix5 = new Matrix(array5, 3, 2);
  }

  @Test
  public void shouldAddIfMatricesHaveSameDimension() {
    int[][] expectedValues = { { 4, 6 }, { 4, 6 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);
    assertEquals(expectedMatrix, this.testMatrix1.add(this.testMatrix2));
  }

  @Test
  public void shouldNotAddIfMatricesHaveDifferentDimensions() {
    assertNull(this.testMatrix1.add(this.testMatrix4));
  }

  @Test
  public void shouldSubtractIfMatricesHaveSameDimension() {
    int[][] expectedValues = { { -2, -2 }, { 2, 2 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);
    assertEquals(expectedMatrix, this.testMatrix1.subtract(this.testMatrix2));
  }

  @Test
  public void shouldNotSubtractIfMatricesHaveDifferentDimensions() {
    assertNull(this.testMatrix1.subtract(this.testMatrix4));
  }

  @Test
  public void shouldMultiplyIfFirstMatrixRowsCountAndSecondMatrixColumnCountMatches() {
    int[][] expectedValues = { { 15, 22 }, { 7, 10 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);
    assertEquals(expectedMatrix, this.testMatrix3.multiply(this.testMatrix5));
  }

  @Test
  public void shouldNotMultiplyIfFirstMatrixRowsCountAndSecondMatrixColumnCountNotMatches() {
    assertNull(this.testMatrix4.multiply(this.testMatrix5));
  }

  @Test
  public void shouldFindDeterminantOfSingleElementMatrix() {
    int[][] array1 = { { 3 } };
    Matrix matrix1 = new Matrix(array1, 1, 1);
    assertEquals(3, matrix1.determinant());
  }

  @Test
  public void shouldFindDeterminantOfMatrixOfSizeTwo() {
    assertEquals(-2, this.testMatrix1.determinant());
  }

  @Test
  public void shouldFindDeterminantOfMatrixOfSizeMoreThanTwo() {
    assertEquals(0, this.testMatrix4.determinant());
  }

  @Test
  public void shouldReturnTrueForMatricesOfSameDimension() {
    assertTrue(this.testMatrix1.areSameDimensions(this.testMatrix2));
  }

  @Test
  public void shouldReturnTrueForMatricesOfDifferentDimension() {
    assertFalse(this.testMatrix1.areSameDimensions(this.testMatrix4));
  }

  @Test
  public void toStringShouldGiveMatrixStringRepresentation() {
    String expected = "Matrix [2][2]\n1 2 \n3 4 \n";
    assertEquals(expected, this.testMatrix1.toString());
  }

  @Test
  public void equalsShouldReturnTrueForSameReference() {
    assertTrue(this.testMatrix1.equals(this.testMatrix1));
  }

  @Test
  public void equalsShouldReturnFalseForNonMatrixInstance() {
    Object otherObject = new Object();
    assertFalse(this.testMatrix1.equals(otherObject));
  }

  @Test
  public void equalsShouldReturnFalseForDifferentDimensions() {
    assertFalse(this.testMatrix1.equals(this.testMatrix4));
  }

  @Test
  public void equalsShouldReturnFalseForSameDimensionDifferentContent() {
    assertFalse(this.testMatrix1.equals(this.testMatrix2));
  }

  @Test
  public void equalsShouldReturnTrueForEqualMatrices() {
    assertTrue(this.testMatrix2.equals(this.testMatrix3));
  }
}
