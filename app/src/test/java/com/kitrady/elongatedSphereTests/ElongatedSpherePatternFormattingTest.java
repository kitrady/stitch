package com.kitrady.elongatedSphereTests;

import com.kitrady.RoundComponentAssembler;
import com.kitrady.RoundComponentMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElongatedSpherePatternFormattingTest {
    @Test
    public void patternFormatterTest1() {
        List<Integer> stitchesPerRound = List.of(6, 12, 17, 21, 24, 25, 25, 25, 25, 25, 25, 24, 21, 17, 12, 6);
        RoundComponentMaker maker =  new RoundComponentMaker(stitchesPerRound);
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
Rd 3: (1 sc, 1 inc) x5, 2 sc (17)
Rd 4: 2 sc, 1 inc, (3 sc, 1 inc) x3, 2 sc (21)
Rd 5: (6 sc, 1 inc) x3 (24)
Rd 6: 11 sc, 1 inc, 12 sc (25)
Rd 7: sc in each st in round (25)
Rd 8: sc in each st in round (25)
Rd 9: sc in each st in round (25)
Rd 10: sc in each st in round (25)
Rd 11: sc in each st in round (25)
Rd 12: 23 sc, 1 dec (24)
Rd 13: 3 sc, 1 dec, (6 sc, 1 dec) x2, 3 sc (21)
Rd 14: (3 sc, 1 dec) x4, 1 sc (17)
Rd 15: 1 dec, (1 sc, 1 dec) x4, 3 sc (12)
Rd 16: dec in each st in round (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest2() {
        List<Integer> stitchesPerRound = List.of(6, 11, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 11, 6);
        RoundComponentMaker maker =  new RoundComponentMaker(stitchesPerRound);
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
Rd 2: 5 inc, 1 sc (11)
Rd 3: (4 sc, 1 inc) x2, 1 sc (13)
Rd 4: sc in each st in round (13)
Rd 5: sc in each st in round (13)
Rd 6: sc in each st in round (13)
Rd 7: sc in each st in round (13)
Rd 8: sc in each st in round (13)
Rd 9: sc in each st in round (13)
Rd 10: sc in each st in round (13)
Rd 11: sc in each st in round (13)
Rd 12: sc in each st in round (13)
Rd 13: 2 sc, 1 dec, 4 sc, 1 dec, 3 sc (11)
Rd 14: 5 dec, 1 sc (6)""", output.toString());
    }
}
