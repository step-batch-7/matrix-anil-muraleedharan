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
  public void testMatrixToString() {
    String expected = "Matrix [2][2]\n1 2 \n3 4 \n";

    assertEquals(
      "Should give string representation of a matrix",
      expected,
      this.testMatrix1.toString()
    );
  }

  @Test
  public void testMatrixEqualsForSameReference() {
    assertTrue(
      "Should give true if both matrices are of same reference",
      this.testMatrix1.equals(this.testMatrix1)
    );
  }

  @Test
  public void testMatrixEqualsForNonMatrixInstance() {
    Object otherObject = new Object();
    assertFalse(
      "Should give false if the given Object is not an instance of Matrix",
      this.testMatrix1.equals(otherObject)
    );
  }

  @Test
  public void testMatrixEqualsForDifferentDimensions() {
    assertFalse(
      "Should give false if both the matrices are of different dimensions",
      this.testMatrix1.equals(this.testMatrix4)
    );
  }

  @Test
  public void testMatrixEqualsForSameDimensionDifferentContent() {
    assertFalse(
      "Should give false if both the matrices are of same dimensions and different content",
      this.testMatrix1.equals(this.testMatrix2)
    );
  }

  @Test
  public void testMatrixEqualsForEqualMatrices() {
    assertTrue(
      "Should give true if both the matrices are of same dimension and content",
      this.testMatrix2.equals(this.testMatrix3)
    );
  }

  @Test
  public void testMatrixAdditionEqualDimension() {
    int[][] expectedValues = { { 4, 6 }, { 4, 6 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);

    assertEquals(
      "Should add two matrices if the dimensions are same",
      expectedMatrix,
      this.testMatrix1.add(this.testMatrix2)
    );
  }

  @Test
  public void testMatrixAdditionUnequalDimension() {
    assertNull(
      "Should not add two matrices if the dimensions are different",
      this.testMatrix1.add(this.testMatrix4)
    );
  }

  @Test
  public void testMatrixSubtractionSameDimension() {
    int[][] expectedValues = { { -2, -2 }, { 2, 2 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);

    assertEquals(
      "Should subtract two matrices if the dimensions are same",
      expectedMatrix,
      this.testMatrix1.subtract(this.testMatrix2)
    );
  }

  @Test
  public void testMatrixSubtractionDifferentDimension() {
    assertNull(
      "Should not subtract two matrices if the dimensions are different",
      this.testMatrix1.subtract(this.testMatrix4)
    );
  }

  @Test
  public void testMatrixMultiplicationProperDimension() {
    int[][] expectedValues = { { 15, 22 }, { 7, 10 } };
    Matrix expectedMatrix = new Matrix(expectedValues, 2, 2);

    assertEquals(
      "Should multiply two matrices if the dimensions are proper",
      expectedMatrix,
      this.testMatrix3.multiply(this.testMatrix5)
    );
  }

  @Test
  public void testMatrixMultiplicationImproperDimension() {
    assertNull(
      "Should not multiply two matrices if the dimensions are not proper",
      this.testMatrix4.multiply(this.testMatrix5)
    );
  }

  @Test
  public void testMatrixDeterminantSingleElement() {
    int[][] array1 = { { 3 } };
    Matrix matrix1 = new Matrix(array1, 1, 1);

    assertEquals(
      "Should calculate determinant of a single element matrix",
      3,
      matrix1.determinant()
    );
  }

  @Test
  public void testMatrixDeterminantOfSizeTwo() {
    assertEquals(
      "Should calculate determinant of a matrix of size two",
      -2,
      this.testMatrix1.determinant()
    );
  }

  @Test
  public void testMatrixDeterminantOfSizeMoreThanTwo() {
    assertEquals(
      "Should calculate determinant of a matrix of size more than two",
      0,
      this.testMatrix4.determinant()
    );
  }

  @Test
  public void testAreSameDimensionMethodForSameDimension() {
    assertTrue(
      "Should give true if both matrix have same dimension",
      this.testMatrix1.areSameDimensions(this.testMatrix2)
    );
  }

  @Test
  public void testAreSameDimensionMethodForDifferentDimension() {
    assertFalse(
      "Should give false if both matrix have different dimension",
      this.testMatrix1.areSameDimensions(this.testMatrix4)
    );
  }
}
