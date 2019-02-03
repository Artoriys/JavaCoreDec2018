import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CrazyLoggerTest {

    @Test
    void addLogTest() {
        CrazyLogger logger = new CrazyLogger();
        String currentTime = logger.getCurrentTime();
        String message = "Hello world";
        logger.addLog(message, currentTime);
        assertEquals(currentTime + " - " + message + "\n", logger.getLog());
    }

    @Test
    void logSearchTest() {
        CrazyLogger logger = new CrazyLogger();
        String currentTime = logger.getCurrentTime();
        String message = "Hello world";
        logger.addLog(message, currentTime);
        assertEquals(logger.getLog(), logger.logSearch("He"));
        assertNotEquals(logger.getLog(), logger.logSearch("Ololo"));
    }
}