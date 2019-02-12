package com.company.gauss;

import com.company.MatrixAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GaussAlgorithm extends MatrixAlgorithm {

  public GaussAlgorithm(List<List<Float>> matrix)
  {
    super(matrix);
  }

  @Override
  public List<Float> getResults() {
   // System.out.println(matrix);
    for(int i=0;i<matrix.size()-1;i++) //for every line
    {
      List<Float> currentLine = matrix.get(i);
      for(int j=i+1;j<matrix.size();j++)
      {
        List<Float> changingLine = matrix.get(j);
        Float coef =  coefficent(currentLine.get(i), changingLine.get(i));
        for(int k=0;k<changingLine.size();k++)
        {
          Float sum = Float.parseFloat(String.format("%.3f",currentLine.get(k)*coef).replaceAll(",","."));
          changingLine.set(k,changingLine.get(k)+sum);
          if(changingLine.get(k)<0.001 && changingLine.get(k)>-0.001)
          {
            changingLine.set(k,(float)0);
          }
        }
      }

    }
    List<Float> results = new ArrayList<>();
    int resolved=0;
    for(int i=matrix.size()-1;i>=0;i--) //going up
    {
      List<Float> currentLine = matrix.get(i);
      for(int j=0;j<resolved+1;j++)
      {
        if(j!=resolved) //while we know x values
        {
          //moving values to the right
          currentLine.set(currentLine.size()-1,currentLine.get(currentLine.size()-1)-results.get(j)*(currentLine.get(currentLine.size()-2-j)));
        }
        else
        {
          results.add(currentLine.get(currentLine.size()-1)/currentLine.get(currentLine.size()-2-resolved));
        }
      }
      resolved++;
    }

    Collections.reverse(results);
    return results;
  }

  private Float coefficent(Float a, Float b)
  {
    if (a == 0.0f) return 1.0f;
    return -b/a;
  }
}
