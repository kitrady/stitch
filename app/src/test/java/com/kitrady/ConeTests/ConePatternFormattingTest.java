package com.kitrady.ConeTests;

import com.kitrady.RoundComponentAssembler;
import com.kitrady.RoundComponentMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConePatternFormattingTest {
    @Test
    public void patternFormatterTest1() {
        List<Integer> stitchesPerRd = List.of(1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22, 23, 25);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRd);
        maker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(maker.getAllRoundComponents());
        assembler.assemble();
        List<String> formattedPattern = assembler.getFormattedPattern();
        StringBuilder output = new StringBuilder();
        for (String s : formattedPattern) {
            output.append("\n").append(s);
        }
        // TODO fix first few rounds
        assertEquals("""
                
                Rd 1: 1 sc in magic ring (1)
                Rd 2: inc in each st in round (2)
                Rd 3: inc in each st in round (4)
                Rd 4: 3 sc, 1 inc (5)
                Rd 5: 2 sc, 1 inc, 2 sc (6)
                Rd 6: 5 sc, 1 inc (7)
                Rd 7: 1 sc, 1 inc, 2 sc, 1 inc, 2 sc (9)
                Rd 8: 8 sc, 1 inc (10)
                Rd 9: 4 sc, 1 inc, 5 sc (11)
                Rd 10: 10 sc, 1 inc (12)
                Rd 11: 2 sc, 1 inc, 5 sc, 1 inc, 3 sc (14)
                Rd 12: 13 sc, 1 inc (15)
                Rd 13: 7 sc, 1 inc, 7 sc (16)
                Rd 14: 15 sc, 1 inc (17)
                Rd 15: 8 sc, 1 inc, 8 sc (18)
                Rd 16: (8 sc, 1 inc) x2 (20)
                Rd 17: 9 sc, 1 inc, 10 sc (21)
                Rd 18: 20 sc, 1 inc (22)
                Rd 19: 10 sc, 1 inc, 11 sc (23)
                Rd 20: (10 sc, 1 inc) x2, 1 sc (25)""", output.toString());
    }

    @Test
    public void patternFormatterTest2() {
        List<Integer> stitchesPerRd = List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRd);
        maker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(maker.getAllRoundComponents());
        assembler.assemble();
        List<String> formattedPattern = assembler.getFormattedPattern();
        StringBuilder output = new StringBuilder();
        for (String s : formattedPattern) {
            output.append("\n").append(s);
        }
        assertEquals("""
                
                Rd 1: 2 sc in magic ring (2)
                Rd 2: inc in each st in round (4)
                Rd 3: (1 sc, 1 inc) x2 (6)
                Rd 4: 1 sc, 1 inc, 2 sc, 1 inc, 1 sc (8)
                Rd 5: (3 sc, 1 inc) x2 (10)
                Rd 6: 2 sc, 1 inc, 4 sc, 1 inc, 2 sc (12)
                Rd 7: (5 sc, 1 inc) x2 (14)
                Rd 8: 3 sc, 1 inc, 6 sc, 1 inc, 3 sc (16)
                Rd 9: (7 sc, 1 inc) x2 (18)
                Rd 10: 4 sc, 1 inc, 8 sc, 1 inc, 4 sc (20)
                Rd 11: (9 sc, 1 inc) x2 (22)
                Rd 12: 5 sc, 1 inc, 10 sc, 1 inc, 5 sc (24)""", output.toString());
    }
}
