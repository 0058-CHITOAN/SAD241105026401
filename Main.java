import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TimecardManager timecardManager = new TimecardManager();
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin nhân viên và ngày tháng
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        Date date = parseDate(dateInput);  // Hàm parseDate để chuyển đổi chuỗi thành đối tượng Date

        System.out.print("Enter Charge Code: ");
        String chargeCode = scanner.nextLine();

        System.out.print("Enter Hours Worked: ");
        double hours = scanner.nextDouble();

        // Duy trì thời gian chấm công
        timecardManager.maintainTimecard(employeeID, date, chargeCode, hours);

        // Lấy và hiển thị lại thời gian chấm công
        Timecard timecard = timecardManager.getTimecard(employeeID, date);
        if (timecard != null) {
            timecardManager.saveTimecard(timecard);
        } else {
            System.out.println("Failed to retrieve or save timecard.");
        }

        scanner.close();
    }

    // Hàm giúp chuyển đổi chuỗi thành đối tượng Date
    public static Date parseDate(String dateInput) {
        try {
            String[] dateParts = dateInput.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]) - 1; // Chú ý rằng tháng trong GregorianCalendar bắt đầu từ 0
            int day = Integer.parseInt(dateParts[2]);
            return new GregorianCalendar(year, month, day).getTime();
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }
}
