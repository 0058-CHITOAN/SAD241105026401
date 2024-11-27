import java.util.Date;

public class Timecard {
    private String employeeID;
    private Date date;
    private String chargeCode;
    private double hoursWorked;

    public Timecard(String employeeID, Date date, String chargeCode, double hoursWorked) {
        this.employeeID = employeeID;
        this.date = date;
        this.chargeCode = chargeCode;
        this.hoursWorked = hoursWorked;
    }

    // Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public Date getDate() {
        return date;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
