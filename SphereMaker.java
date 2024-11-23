import java.util.ArrayList;
import java.lang.Math;

public class SphereMaker {
   // array list where index represents row and value is number of stiches in row
  ArrayList<Integer> stichesPerRow = new ArrayList<Integer>();
  
  private double stRadius; 
  private double rowCircumference;
  private double degreesPerRow;

  // private because using this constructor would literally break the program
  // this constructor exists only to fufill project requirements
  private SphereMaker() {
    stRadius = 0;
    rowCircumference = 0;
    degreesPerRow = 0;
  }
  
  public SphereMaker(double stRadius, double rowCircumference) {
    this.stRadius = stRadius; // radius measured in stiches
    this.rowCircumference = rowCircumference;  // circumference measured in rows
    degreesPerRow = 360.0 / rowCircumference; // divides 360 degrees in circumference by rows in circumference to get degrees per row
  }
  
  private void generateRows() {
    // computes stiches per row, starting from top of sphere (aka 90 degrees) and ending at side of sphere (aka 0 degrees)
    // uses degrees per row to increment angle properly
    // no row can be at exact top, so starts with one row offset
    for (double angle = (90 - degreesPerRow); angle >= 0; angle -= degreesPerRow) {
      double currentRadius = Math.cos(Math.toRadians(angle)) * stRadius; // finds radius associated with current row/angle using cosine
      double currentCircumference = 6.2831 * currentRadius; // finds circumference associated with current row/angle using circumference formula
      stichesPerRow.add((int) Math.round(currentCircumference)); // expresses circumference as whole number of stiches and adds to list of stiches per row
    }

    // since a sphere has identical hemispheres, reverse current stich counts to get rest of sphere
    int size = stichesPerRow.size();
    for (int i = 0; i < size; i++) {
      stichesPerRow.add(stichesPerRow.get(size - i - 1));
    }
  }
  
  public void printRows() {
    generateRows();
    for (int i = 0; i < stichesPerRow.size(); i++) {
      System.out.print("\nRow " + (i + 1) + ": " + stichesPerRow.get(i) + " stiches");
    }
  }

  public String toString() {
    return ("\n- Radius in stiches = " + stRadius +
            "\n- Circumference in rows = " + rowCircumference +
            "\n- Degrees per row = " + degreesPerRow);
  }
}
