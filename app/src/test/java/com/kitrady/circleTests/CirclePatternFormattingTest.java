package com.kitrady.circleTests;

import com.kitrady.RoundComponentAssembler;
import com.kitrady.RoundComponentMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CirclePatternFormattingTest {
    @Test
    public void patternFormatterTest1() {
        List<Integer> stitchesPerRd = List.of(6, 13, 19, 25);
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
                
                Rd 1: 6 sc in magic ring (6)
                Rd 2: 5 inc, 3 sc in st (13)
                Rd 3: (1 sc, 1 inc) x6, 1 sc (19)
                Rd 4: 1 sc, 1 inc, (2 sc, 1 inc) x5, 2 sc (25)""", output.toString());
    }

    @Test
    public void patternFormatterTest2() {
        List<Integer> stitchesPerRd = List.of(7, 13, 20, 26, 33, 40, 46);
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
                
                Rd 1: 7 sc in magic ring (7)
                Rd 2: 6 inc, 1 sc (13)
                Rd 3: 7 inc, 6 sc (20)
                Rd 4: (2 sc, 1 inc) x6, 2 sc (26)
                Rd 5: 1 sc, 1 inc, (2 sc, 1 inc) x6, 6 sc (33)
                Rd 6: (3 sc, 1 inc) x7, 5 sc (40)
                Rd 7: 2 sc, 1 inc, (5 sc, 1 inc) x5, 7 sc (46)""", output.toString());
    }
}
