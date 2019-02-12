package com.company.jacobi;

import com.company.MatrixAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class JacobiAlgorithm  extends MatrixAlgorithm {
  private final float eps;

  public JacobiAlgorithm(List<List<Float>> matrix, float eps)
  {
    super(matrix);
    this.eps=eps;
  }

  @Override
  public List<Float> getResults() {
    if (!converges())
      throw new ArithmeticException("Jacobi method does not converge");
    List<Float> values = new ArrayList<>();
    int valuesNumber = matrix.get(0).size() - 1;
    for (int i = 0; i < valuesNumber; i++) //initial vector
    {
      values.add(1.0f);
    }
    Float norm = 0.0f;
    do {
      List<Float> coefs = new ArrayList<>();
      for (int i = 0; i < matrix.size(); i++) {
        coefs.add(matrix.get(i).get(valuesNumber));
        for (int j = 0; j < valuesNumber; j++) {
          if (i != j) {
            coefs.set(i, coefs.get(i) - matrix.get(i).get(j) * values.get(j));
          }
        }
        coefs.set(i, coefs.get(i) / matrix.get(i).get(i));
      }
      norm = norm(coefs, values);
      for (int i = 0; i < valuesNumber; i++) {
        values.set(i, coefs.get(i));
      }
    } while (norm > eps);
      return  values;
  }
  private boolean converges()
  {
    for(int i=0;i<matrix.size();i++)
    {
      List<Float> line = matrix.get(i);
      Float sum = 0.0f;
      for(int j=0;j<line.size()-1;j++)
      {
        if(!(j==i))
        {
          sum+=line.get(j);
        }
      }
      if(!(Math.abs(sum)<Math.abs(line.get(i))))
        return false;
    }
    return true;
  }

  private Float norm(List<Float> present, List<Float> previous)
  {
    Float result =0.0f;
    for(int i=0;i<present.size();i++)
    {
      result+=Math.abs(present.get(i)-previous.get(i));
    }
    return result;
  }
}
