package pl.pc;


import java.awt.*;
import java.util.Random;

public class Main {

    private static Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {
        while (true) {
            moveRandomly();
            Thread.sleep(10_000);
        }
    }

    private static void moveRandomly() throws AWTException {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();

        Point location = pointerInfo.getLocation();

        int x = location.x;
        int y = location.y;

        int newX = getNext(x);
        int newY = getNext(y);
        Robot robot = new Robot();
        robot.mouseMove(newX, newY);
    }

    private static int getNext(int current) {
        return current + getRandomOneOrMinusOne();
    }

    private static int getRandomOneOrMinusOne() {
        int next = RANDOM.nextInt(2);
        return next == 0 ? -1 : 1;
    }
}
