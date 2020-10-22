package com.step.maths;

public class Matrix {
  private int[][] values;
  private int rowsCount;
  private int columnsCount;

  public Matrix(int[][] values, int rowsCount, int columnsCount) {
    this.rowsCount = rowsCount;
    this.columnsCount = columnsCount;
    this.values = new int[rowsCount][columnsCount];
    for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
      for (int columnNo = 0; columnNo < columnsCount; columnNo++) {
        this.values[rowNo][columnNo] = values[rowNo][columnNo];
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder matrixString = new StringBuilder();
    matrixString.append(
      String.format("Matrix [%d][%d]\n", this.rowsCount, this.columnsCount)
    );
    for (int[] row : this.values) {
      for (int number : row) {
        matrixString.append(number + " ");
      }
      matrixString.append("\n");
    }
    return matrixString.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Matrix)) {
      return false;
    }
    Matrix otherMatrix = (Matrix) other;
    for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
      for (int colNo = 0; colNo < columnsCount; colNo++) {
        if (this.values[rowNo][colNo] != otherMatrix.values[rowNo][colNo]) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean areSameDimensions(Matrix other) {
    return (
      this.rowsCount == other.rowsCount &&
      this.columnsCount == other.columnsCount
    );
  }

  public Matrix add(Matrix otherMatrix) {
    if (!areSameDimensions(otherMatrix)) return null;
    int[][] result = new int[this.rowsCount][this.columnsCount];
    for (int rowNo = 0; rowNo < this.rowsCount; rowNo++) {
      for (int columnNo = 0; columnNo < this.columnsCount; columnNo++) {
        result[rowNo][columnNo] =
          this.values[rowNo][columnNo] + otherMatrix.values[rowNo][columnNo];
      }
    }
    return new Matrix(result, this.rowsCount, columnsCount);
  }

  public Matrix subtract(Matrix otherMatrix) {
    if (!areSameDimensions(otherMatrix)) return null;
    int[][] result = new int[this.rowsCount][this.columnsCount];
    for (int rowNo = 0; rowNo < this.rowsCount; rowNo++) {
      result[rowNo] = new int[columnsCount];
      for (int columnNo = 0; columnNo < this.columnsCount; columnNo++) {
        result[rowNo][columnNo] =
          this.values[rowNo][columnNo] - otherMatrix.values[rowNo][columnNo];
      }
    }
    return new Matrix(result, this.rowsCount, this.columnsCount);
  }

  public Matrix multiply(Matrix otherMatrix) {
    if (this.rowsCount != otherMatrix.columnsCount) return null;
    int[][] result = new int[this.rowsCount][otherMatrix.columnsCount];
    for (int rowNo = 0; rowNo < this.rowsCount; rowNo++) {
      for (int colNo = 0; colNo < otherMatrix.columnsCount; colNo++) {
        for (int index = 0; index < this.columnsCount; index++) {
          result[rowNo][colNo] +=
            this.values[rowNo][index] * otherMatrix.values[index][colNo];
        }
      }
    }
    return new Matrix(result, this.rowsCount, otherMatrix.columnsCount);
  }

  public Matrix createSubMatrix(int index) {
    int[][] matrixValues = new int[this.rowsCount - 1][this.columnsCount - 1];
    for (int rowNo = 1; rowNo < this.rowsCount; rowNo++) {
      for (int colNo = 0; colNo < this.columnsCount; colNo++) {
        if (colNo < index) {
          matrixValues[rowNo - 1][colNo] = this.values[rowNo][colNo];
        }
        if (colNo > index) {
          matrixValues[rowNo - 1][colNo - 1] = this.values[rowNo][colNo];
        }
      }
    }
    return new Matrix(matrixValues, this.rowsCount - 1, this.columnsCount - 1);
  }

  public int determinant() {
    if (this.rowsCount == 1) {
      return this.values[0][0];
    }
    if (this.rowsCount == 2) {
      return (
        (this.values[0][0] * this.values[1][1]) -
        (this.values[0][1] * this.values[1][0])
      );
    }
    int result = 0;
    for (int index = 0; index < this.columnsCount; index++) {
      Matrix subMatrix = createSubMatrix(index);
      result +=
        this.values[0][index] * Math.pow(-1, index) * subMatrix.determinant();
    }
    return result;
  }
}
