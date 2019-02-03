import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrazyLogger {

    private StringBuilder log = new StringBuilder();

    public String getLog() {
        return log.toString();
    }

    public String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY 'at' HH:mm:ss");
        String formatedDate = dateFormat.format(date);
        return formatedDate;
    }

    public void addLog(String message, String currentTime) {
       log.append(currentTime + " - " + message + "\n");
    }

    public String logSearch(String str) {
        StringBuilder result = new StringBuilder("");
        if (log.indexOf(str) == -1) return "";
        int index = 0;
        while (log.indexOf(str, index) != -1) {
                int[] endLine = findBorders(log.indexOf(str, index));
                result.append(log.substring(endLine[0], endLine[1]) + "\n");
                index = endLine[1];
        }
        return result.toString();
    }
    private int[] findBorders(int index) {
        int[] endLine = new int[2];
        boolean borderIsFound = false;
        int i = index;
        endLine[1] = log.indexOf("\n",index);
        while (!borderIsFound) {
            if (log.charAt(i) == '\n' || i == 0 ) {
                endLine[0] = i;
                borderIsFound = true;
            } else {
                i--;
            }
        }
        return endLine;
    }

}
