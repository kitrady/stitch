public class PatternRunner {
    public static void main(String[] args) {

        InputGetter objInputGetter = new InputGetter(1.2, 4, 4);
        InputConverter objInputConverter = new InputConverter(objInputGetter.getRadius(), objInputGetter.getGauge(), objInputGetter.getVertGauge());
        SphereMaker objSphereMaker = new SphereMaker(objInputConverter.getStRadius(), objInputConverter.getRowCircumference());

        System.out.println("\nobjInputGetter:" + objInputGetter);
        System.out.println("\nobjInputConverter:" + objInputConverter);
        System.out.println("\nobjSphereMaker:" + objSphereMaker);

        objSphereMaker.printRows();

        // TODO
        //  - make it properly handle middle row (aka repeat or not)
        //  - also make handle input methods be one method that takes messages as parameters

        // What is crochet-pattern-maker.iml?
        // it is essentially IDE config file
        // if not in project, will have to open new project in Intellij each time I pull from repo
        // but also changes a lot, and makes things really annoying when many people are working on same repo
        // this is what build tools like gradle are for
        // so for now add it to repo, but ask dad about it later

        // What is .idea folder?
        // it is essentially project config files
        // if not in project, ppl may have different config settings and could be problematic
        // but also changes a lot, and makes things really annoying when many people are working on same repo
        // so for now add it to repo, but ask dad about it later

        // what is out folder?
        // basically just the compiled code
        // don't add it to repo
    }
}
