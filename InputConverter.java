import java.lang.Math;

public class InputConverter extends InputGetter {
  private double stRadius;
  private double rowRadius;
  private double rowCircumference;

  // private because using this constructor would literally break the program
  // this constructor exists only to fufill project requirements
  private InputConverter() {
    super(0, 0, 0);
    stRadius = 0;
    rowRadius = 0;
    rowCircumference = 0;
  }

  public InputConverter(double radius, double gauge, double vertGauge) {
    super(radius, gauge, vertGauge);
    stRadius = radius * gauge; // converts the radius from inches to stiches using gauge
    rowRadius = radius * vertGauge; // creates a vertical radius measured in rows using radius in inches and vertical gauge in rows per inch
    rowCircumference = 6.2831 * rowRadius; // creates a vertical circumference measured in rows using vertical radius measured in rows
  }

  public double getStRadius() {
    return stRadius;
  }

  public double getRowCircumference() {
    return rowCircumference;
  }

  public String toString() {
    return (super.toString() +
            "\n- Radius in stiches = " + stRadius +
            "\n- Radius in rows = " + rowRadius +
            "\n- Circumference in rows = " + rowCircumference);
  }
}
