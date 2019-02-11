package com.company.jacobi;

import com.company.MatrixAlgorithm;

import java.util.List;
import java.util.Map;

public class JacobiAlgorithm  extends MatrixAlgorithm {
  private final float eps;

  public JacobiAlgorithm(List<List<Float>> matrix, float eps)
  {
    super(matrix);
    this.eps=eps;
  }

  @Override
  public List<Float> getResults() {
    return null;
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
      result+= Math.abs(present.get(i)-previous.get(i));
    }
    return result;
  }
}
