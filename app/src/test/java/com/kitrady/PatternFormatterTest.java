package com.kitrady;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatternFormatterTest {
    @Test
    public void patternFormatterTest1() {
        ArrayList<Integer> stitchesPerRd = new ArrayList<>(List.of(6, 12, 18, 23, 26, 29, 31, 31, 31, 29, 26, 23, 18, 12, 6));
        PatternFormatter objPatternFormatter =  new PatternFormatter(stitchesPerRd);
        ArrayList<String> formattedPattern = objPatternFormatter.getFormattedPattern();
        String output = "";
        for (String s : formattedPattern) {
            output += "\n" + s;
        }
        assertEquals("""

Rd 1: 6 sc in magic ring (6)
Rd 2: inc in each st in round (12)
Rd 3: (1 sc, inc) x6 (18)
Rd 4: (2 sc, inc) x5, 3 sc (23)
Rd 5: (6 sc, inc) x3, 2 sc (26)
Rd 6: (7 sc, inc) x3, 2 sc (29)
Rd 7: (13 sc, inc) x2, 1 sc (31)
Rd 8: sc in each st in round (31)
Rd 9: sc in each st in round (31)
Rd 10: (13 sc, dec) x2, 1 sc (29)
Rd 11: (7 sc, dec) x3, 2 sc (26)
Rd 12: (6 sc, dec) x3, 2 sc (23)
Rd 13: (2 sc, dec) x5, 3 sc (18)
Rd 14: (1 sc, dec) x6 (12)
Rd 15: dec in each st in round (6)""", output);
    }

    @Test
    public void patternFormatterTest2() {
        ArrayList<Integer> stitchesPerRd = new ArrayList<>(List.of(6, 12, 18, 22, 26, 28, 29, 29, 28, 26, 22, 18, 12, 6));
        PatternFormatter objPatternFormatter =  new PatternFormatter(stitchesPerRd);
        ArrayList<String> formattedPattern = objPatternFormatter.getFormattedPattern();
        String output = "";
        for (String s : formattedPattern) {
            output += "\n" + s;
        }
        assertEquals("""

Rd 1: 6 sc in magic ring (6)
Rd 2: inc in each st in round (12)
Rd 3: (1 sc, inc) x6 (18)
Rd 4: (3 sc, inc) x4, 2 sc (22)
Rd 5: (4 sc, inc) x4, 2 sc (26)
Rd 6: (12 sc, inc) x2 (28)
Rd 7: 27 sc, inc (29)
Rd 8: sc in each st in round (29)
Rd 9: (27 sc, dec) x1 (28)
Rd 10: (12 sc, dec) x2 (26)
Rd 11: (4 sc, dec) x4, 2 sc (22)
Rd 12: (3 sc, dec) x4, 2 sc (18)
Rd 13: (1 sc, dec) x6 (12)
Rd 14: dec in each st in round (6)""", output);
    }
}
