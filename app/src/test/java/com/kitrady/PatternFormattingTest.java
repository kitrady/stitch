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
Rd 3: (1 sc, 1 inc) x6 (18)
Rd 4: 1 sc, 1 inc, (2 sc, 1 inc) x4, 4 sc (23)
Rd 5: (6 sc, 1 inc) x3, 2 sc (26)
Rd 6: 3 sc, 1 inc, (7 sc, 1 inc) x2, 6 sc (29)
Rd 7: (13 sc, 1 inc) x2, 1 sc (31)
Rd 8: sc in each st in round (31)
Rd 9: sc in each st in round (31)
Rd 10: 6 sc, 1 dec, 13 sc, 1 dec, 8 sc (29)
Rd 11: (7 sc, 1 dec) x3, 2 sc (26)
Rd 12: 3 sc, 1 dec, (6 sc, 1 dec) x2, 5 sc (23)
Rd 13: (2 sc, 1 dec) x5, 3 sc (18)
Rd 14: 1 dec, (1 sc, 1 dec) x5, 1 sc (12)
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
Rd 3: (1 sc, 1 inc) x6 (18)
Rd 4: 1 sc, 1 inc, (3 sc, 1 inc) x3, 4 sc (22)
Rd 5: (4 sc, 1 inc) x4, 2 sc (26)
Rd 6: 6 sc, 1 inc, 12 sc, 1 inc, 6 sc (28)
Rd 7: 27 sc, 1 inc (29)
Rd 8: sc in each st in round (29)
Rd 9: 27 sc, 1 dec (28)
Rd 10: (12 sc, 1 dec) x2 (26)
Rd 11: 2 sc, 1 dec, (4 sc, 1 dec) x3, 4 sc (22)
Rd 12: (3 sc, 1 dec) x4, 2 sc (18)
Rd 13: 1 dec, (1 sc, 1 dec) x5, 1 sc (12)
Rd 14: dec in each st in round (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest3() {
        List<Integer> stitchesPerRd = List.of(6, 11, 13, 13, 11, 6);
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
Rd 2: 5 inc, 1 sc (11)
Rd 3: (4 sc, 1 inc) x2, 1 sc (13)
Rd 4: sc in each st in round (13)
Rd 5: 2 sc, 1 dec, 4 sc, 1 dec, 3 sc (11)
Rd 6: 5 dec, 1 sc (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest4() {
        List<Integer> stitchesPerRd = List.of(6, 10, 14, 15, 15, 14, 10, 6);
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
Rd 2: 4 inc, 2 sc (10)
Rd 3: (1 sc, 1 inc) x4, 2 sc (14)
Rd 4: 13 sc, 1 inc (15)
Rd 5: sc in each st in round (15)
Rd 6: 13 sc, 1 dec (14)
Rd 7: 1 dec, (1 sc, 1 dec) x3, 3 sc (10)
Rd 8: 4 dec, 2 sc (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest5() {
        List<Integer> stitchesPerRd = List.of(5, 9, 13, 16, 18, 19, 19, 18, 16, 13, 9, 5);
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

Rd 1: 5 sc in magic ring (5)
Rd 2: 4 inc, 1 sc (9)
Rd 3: (1 sc, 1 inc) x4, 1 sc (13)
Rd 4: 1 sc, 1 inc, (3 sc, 1 inc) x2, 3 sc (16)
Rd 5: (7 sc, 1 inc) x2 (18)
Rd 6: 17 sc, 1 inc (19)
Rd 7: sc in each st in round (19)
Rd 8: 17 sc, 1 dec (18)
Rd 9: 3 sc, 1 dec, 7 sc, 1 dec, 4 sc (16)
Rd 10: (3 sc, 1 dec) x3, 1 sc (13)
Rd 11: 1 dec, (1 sc, 1 dec) x3, 2 sc (9)
Rd 12: 4 dec, 1 sc (5)""", output.toString());
    }

    @Test
    public void patternFormatterTest6() {
        List<Integer> stitchesPerRd = List.of(5, 9, 13, 16, 18, 19, 19, 18, 16, 13, 9, 5);
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

Rd 1: 5 sc in magic ring (5)
Rd 2: 4 inc, 1 sc (9)
Rd 3: (1 sc, 1 inc) x4, 1 sc (13)
Rd 4: 1 sc, 1 inc, (3 sc, 1 inc) x2, 3 sc (16)
Rd 5: (7 sc, 1 inc) x2 (18)
Rd 6: 17 sc, 1 inc (19)
Rd 7: sc in each st in round (19)
Rd 8: 17 sc, 1 dec (18)
Rd 9: 3 sc, 1 dec, 7 sc, 1 dec, 4 sc (16)
Rd 10: (3 sc, 1 dec) x3, 1 sc (13)
Rd 11: 1 dec, (1 sc, 1 dec) x3, 2 sc (9)
Rd 12: 4 dec, 1 sc (5)""", output.toString());
    }

    @Test
    public void patternFormatterTest7() {
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 23, 28, 32, 35, 37, 38, 38, 37, 35, 32, 28, 23, 18, 12, 6);
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
Rd 3: (1 sc, 1 inc) x6 (18)
Rd 4: 1 sc, 1 inc, (2 sc, 1 inc) x4, 4 sc (23)
Rd 5: (3 sc, 1 inc) x5, 3 sc (28)
Rd 6: 3 sc, 1 inc, (6 sc, 1 inc) x3, 3 sc (32)
Rd 7: (9 sc, 1 inc) x3, 2 sc (35)
Rd 8: 8 sc, 1 inc, 16 sc, 1 inc, 9 sc (37)
Rd 9: 36 sc, 1 inc (38)
Rd 10: sc in each st in round (38)
Rd 11: 36 sc, 1 dec (37)
Rd 12: (16 sc, 1 dec) x2, 1 sc (35)
Rd 13: 4 sc, 1 dec, (9 sc, 1 dec) x2, 7 sc (32)
Rd 14: (6 sc, 1 dec) x4 (28)
Rd 15: 1 sc, 1 dec, (3 sc, 1 dec) x4, 5 sc (23)
Rd 16: (2 sc, 1 dec) x5, 3 sc (18)
Rd 17: 1 dec, (1 sc, 1 dec) x5, 1 sc (12)
Rd 18: dec in each st in round (6)""", output.toString());
    }

    @Test
    public void patternFormatterTest8() {
        List<Integer> stitchesPerRd = List.of(7, 13, 20, 26, 32, 38, 43, 49, 54, 58, 62, 66, 69, 71, 73, 74, 75, 75, 75, 74, 73, 71, 69, 66, 62, 58, 54, 49, 43, 38, 32, 26, 20, 13, 7);
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

Rd 1: 7 sc in magic ring (7)
Rd 2: 6 inc, 1 sc (13)
Rd 3: 7 inc, 6 sc (20)
Rd 4: (2 sc, 1 inc) x6, 2 sc (26)
Rd 5: 1 sc, 1 inc, (3 sc, 1 inc) x5, 4 sc (32)
Rd 6: (4 sc, 1 inc) x6, 2 sc (38)
Rd 7: 3 sc, 1 inc, (6 sc, 1 inc) x4, 6 sc (43)
Rd 8: (6 sc, 1 inc) x6, 1 sc (49)
Rd 9: 4 sc, 1 inc, (8 sc, 1 inc) x4, 8 sc (54)
Rd 10: (12 sc, 1 inc) x4, 2 sc (58)
Rd 11: 6 sc, 1 inc, (13 sc, 1 inc) x3, 9 sc (62)
Rd 12: (14 sc, 1 inc) x4, 2 sc (66)
Rd 13: 10 sc, 1 inc, (21 sc, 1 inc) x2, 11 sc (69)
Rd 14: (33 sc, 1 inc) x2, 1 sc (71)
Rd 15: 17 sc, 1 inc, 34 sc, 1 inc, 18 sc (73)
Rd 16: 72 sc, 1 inc (74)
Rd 17: 73 sc, 1 inc (75)
Rd 18: sc in each st in round (75)
Rd 19: sc in each st in round (75)
Rd 20: 73 sc, 1 dec (74)
Rd 21: 72 sc, 1 dec (73)
Rd 22: (34 sc, 1 dec) x2, 1 sc (71)
Rd 23: 16 sc, 1 dec, 33 sc, 1 dec, 18 sc (69)
Rd 24: (21 sc, 1 dec) x3 (66)
Rd 25: 7 sc, 1 dec, (14 sc, 1 dec) x3, 9 sc (62)
Rd 26: (13 sc, 1 dec) x4, 2 sc (58)
Rd 27: 6 sc, 1 dec, (12 sc, 1 dec) x3, 8 sc (54)
Rd 28: (8 sc, 1 dec) x5, 4 sc (49)
Rd 29: 3 sc, 1 dec, (6 sc, 1 dec) x5, 4 sc (43)
Rd 30: (6 sc, 1 dec) x5, 3 sc (38)
Rd 31: 2 sc, 1 dec, (4 sc, 1 dec) x5, 4 sc (32)
Rd 32: (3 sc, 1 dec) x6, 2 sc (26)
Rd 33: 1 sc, 1 dec, (2 sc, 1 dec) x5, 3 sc (20)
Rd 34: 7 dec, 6 sc (13)
Rd 35: 6 dec, 1 sc (7)""", output.toString());
    }
}
