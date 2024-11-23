public class PatternRunner {
  public static void main(String[] args) {

    InputGetter objInputGetter = new InputGetter(1.2, 4, 4);
    InputConverter objInputConverter = new InputConverter(objInputGetter.getRadius(), objInputGetter.getGauge(), objInputGetter.getVertGauge());
    SphereMaker objSphereMaker = new SphereMaker(objInputConverter.getStRadius(), objInputConverter.getRowCircumference());

    System.out.println("\nobjInputGetter:" + objInputGetter);
    System.out.println("\nobjInputConverter:" + objInputConverter);
    System.out.println("\nobjSphereMaker:" + objSphereMaker);
    
    objSphereMaker.printRows();

    // TODO - make it properly handle middle row (aka repeat or not)
  }
}
