package SOR_resources;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeepMachineActive {

    public static void main(String[] args) {
        try 
        {
            Robot robot = new Robot();

            while (true) {
                // Simulate key press and release
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_SHIFT);

                // Simulate a tiny mouse movement
                Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                int x = (int) mousePosition.getX();
                int y = (int) mousePosition.getY();
                robot.mouseMove(x + 1, y);
                robot.mouseMove(x, y);

                // Log activity to file
                //logger.println("Activity simulated at: " + new Date());
                //logger.flush();

                // Sleep for a minute
                Thread.sleep(60000); // 1-minute interval
            }
        } catch (AWTException | InterruptedException  e) 
        {
            e.printStackTrace();
        }
    }
}

