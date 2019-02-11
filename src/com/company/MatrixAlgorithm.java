package com.company;

import java.util.List;

public abstract class MatrixAlgorithm {
  protected List<List<Float>> matrix;

  public MatrixAlgorithm(List<List<Float>> matrix)
  {
    this.matrix=matrix;

  }

  public abstract List<Float> getResults();
}
