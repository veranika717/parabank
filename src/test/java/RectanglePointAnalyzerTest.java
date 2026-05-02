
import org.example.RectanglePointAnalyzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectanglePointAnalyzerTest {


    @Test
    void testInside() {
        assertEquals("Point is INSIDE the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(0, 0));
    }

    @Test
    void testOutside() {
        assertEquals("Point is OUTSIDE the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(10, 10));
    }

    @Test
    void testCorner() {
        assertEquals("Point belongs to a CORNER of the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(-3, -4));
    }


    @ParameterizedTest
    @CsvSource({
            "0, -4",
            "0, 4",
            "2, -4",
            "-1, 4"
    })
    void testHorizontalBorder(int x, int y) {
        assertEquals("Point belongs to the HORIZONTAL border of the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "-3, 0",
            "-3, 2",
            "3, 0",
            "3, -1"
    })
    void testVerticalBorder(int x, int y) {
        assertEquals("Point belongs to the VERTICAL border of the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "-3, -4",
            "3, -4",
            "-3, 4",
            "3, 4"
    })
    void testCorners(int x, int y) {
        assertEquals("Point belongs to a CORNER of the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "-5, 0",
            "5, 0",
            "0, -6",
            "0, 6",
            "-4, -5",
            "4, 5"
    })
    void testOutsidePoints(int x, int y) {
        assertEquals("Point is OUTSIDE the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(x, y));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> insidePointsProvider() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(0, 0),
                org.junit.jupiter.params.provider.Arguments.of(2, 2),
                org.junit.jupiter.params.provider.Arguments.of(-2, -3),
                org.junit.jupiter.params.provider.Arguments.of(1, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("insidePointsProvider")
    void testMultipleInsidePoints(int x, int y) {
        assertEquals("Point is INSIDE the rectangle",
                RectanglePointAnalyzer.analyzePointPosition(x, y));
    }
}