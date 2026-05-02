package org.example;
import java.util.Scanner;

public class RectanglePointAnalyzer {

    private static final int X_MIN = -3;
    private static final int X_MAX = 3;
    private static final int Y_MIN = -4;
    private static final int Y_MAX = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x coordinate (integer): ");
        int x = scanner.nextInt();

        System.out.print("Enter y coordinate (integer): ");
        int y = scanner.nextInt();

        scanner.close();

        String result = analyzePointPosition(x, y);
        System.out.println("Result: " + result);
    }

    public static String analyzePointPosition(int x, int y) {
        boolean isInsideX = (x >= X_MIN && x <= X_MAX);
        boolean isInsideY = (y >= Y_MIN && y <= Y_MAX);

        if (!isInsideX || !isInsideY) {
            return "Point is OUTSIDE the rectangle";
        }

        boolean onLeftBorder = (x == X_MIN);
        boolean onRightBorder = (x == X_MAX);
        boolean onBottomBorder = (y == Y_MIN);
        boolean onTopBorder = (y == Y_MAX);

        boolean onVerticalBorder = onLeftBorder || onRightBorder;
        boolean onHorizontalBorder = onBottomBorder || onTopBorder;

        if (onVerticalBorder && onHorizontalBorder) {
            return "Point belongs to a CORNER of the rectangle";
        } else if (onHorizontalBorder) {
            return "Point belongs to the HORIZONTAL border of the rectangle";
        } else if (onVerticalBorder) {
            return "Point belongs to the VERTICAL border of the rectangle";
        } else {
            return "Point is INSIDE the rectangle";
        }
    }
}