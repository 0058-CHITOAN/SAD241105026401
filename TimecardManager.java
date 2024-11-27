import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimecardManager {
    private Map<String, Timecard> timecardDatabase;

    public TimecardManager() {
        timecardDatabase = new HashMap<>();
    }

    public void maintainTimecard(String employeeID, Date date, String chargeCode, double hoursWorked) {
        Timecard timecard = new Timecard(employeeID, date, chargeCode, hoursWorked);
        timecardDatabase.put(employeeID + date.toString(), timecard);
        System.out.println("Timecard maintained successfully.");
    }

    public Timecard getTimecard(String employeeID, Date date) {
        return timecardDatabase.get(employeeID + date.toString());
    }

    public void saveTimecard(Timecard timecard) {
        // In a real application, save to a database or file
        System.out.println("Timecard saved successfully for " + timecard.getEmployeeID() + " on " + timecard.getDate());
    }


}
