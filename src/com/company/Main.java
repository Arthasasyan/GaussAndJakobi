package com.company;

import com.company.gauss.GaussAlgorithm;
import com.company.jacobi.JacobiAlgorithm;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException
  {
    FileReader reader = new FileReader("matrix.txt");
    List<List<Float>> matrix = new ArrayList<>();
    Scanner sc = new Scanner(reader);
    for(int i=0;i<4;i++)
    {
      List<Float> line = new ArrayList<>();
      String[]  fileLine = sc.nextLine().split(" ");
      for(String s: fileLine)
      {
        line.add(Float.parseFloat(s));
      }
      matrix.add(line);
    }
    MatrixAlgorithm gauss = new GaussAlgorithm(matrix);
    System.out.println("Gauss"+gauss.getResults().toString());
    MatrixAlgorithm jacobi = new JacobiAlgorithm(matrix, 0.01f);
    System.out.println("Jacobi "+jacobi.getResults().toString());
  }
}
