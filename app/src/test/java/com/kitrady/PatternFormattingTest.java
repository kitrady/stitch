package com.kitrady;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatternFormattingTest {
    @Test
    public void patternFormatterTest1() {
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 23, 26, 29, 31, 31, 31, 29, 26, 23, 18, 12, 6);
        RoundComponentMaker maker =  new RoundComponentMaker(stitchesPerRd);
        maker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(maker.getAllRoundComponents());
        assembler.assemble();
        List<String> formattedPattern = assembler.getFormattedPattern();
        StringBuilder output = new StringBuilder();
        for (String s : formattedPattern) {
            output.append("\n").append(s);
        }
        assertEquals("""

Rd 1: 6 sc in magic ring (6)
Rd 2: inc in each st in round (12)
Rd 3: (1 sc, inc) x6 (18)
Rd 4: 1 sc, inc, (2 sc, inc) x4, 4 sc (23)
Rd 5: (6 sc, inc) x3, 2 sc (26)
Rd 6: 3 sc, inc, (7 sc, inc) x2, 6 sc (29)
Rd 7: (13 sc, inc) x2, 1 sc (31)
Rd 8: sc in each st in round (31)
Rd 9: sc in each st in round (31)
Rd 10: 6 sc, dec, 13 sc, dec, 8 sc (29)
Rd 11: (7 sc, dec) x3, 2 sc (26)
Rd 12: 3 sc, dec, (6 sc, dec) x2, 5 sc (23)
Rd 13: (2 sc, dec) x5, 3 sc (18)
Rd 14: 0 sc, dec, (1 sc, dec) x5, 1 sc (12)
Rd 15: dec in each st in round (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest2() {
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 22, 26, 28, 29, 29, 28, 26, 22, 18, 12, 6);
        RoundComponentMaker maker =  new RoundComponentMaker(stitchesPerRd);
        maker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(maker.getAllRoundComponents());
        assembler.assemble();
        List<String> formattedPattern = assembler.getFormattedPattern();
        StringBuilder output = new StringBuilder();
        for (String s : formattedPattern) {
            output.append("\n").append(s);
        }
        assertEquals("""

Rd 1: 6 sc in magic ring (6)
Rd 2: inc in each st in round (12)
Rd 3: (1 sc, inc) x6 (18)
Rd 4: 1 sc, inc, (3 sc, inc) x3, 4 sc (22)
Rd 5: (4 sc, inc) x4, 2 sc (26)
Rd 6: 6 sc, inc, 12 sc, inc, 6 sc (28)
Rd 7: 27 sc, inc (29)
Rd 8: sc in each st in round (29)
Rd 9: 27 sc, dec (28)
Rd 10: (12 sc, dec) x2 (26)
Rd 11: 2 sc, dec, (4 sc, dec) x3, 4 sc (22)
Rd 12: (3 sc, dec) x4, 2 sc (18)
Rd 13: 0 sc, dec, (1 sc, dec) x5, 1 sc (12)
Rd 14: dec in each st in round (6)""", output.toString());
    }
}
