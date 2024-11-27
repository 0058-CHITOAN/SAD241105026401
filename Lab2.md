
# Phân Tích Các Ca Sử Dụng Còn Lại trong Hệ Thống Payroll System

## Ca Sử Dụng: **Generate Paycheck**
### Mô tả:
Tạo và lưu trữ phiếu lương cho nhân viên dựa trên thông tin bảng chấm công và lương cơ bản.

### Các lớp liên quan:
- **Employee**: Lớp đại diện cho nhân viên, bao gồm thông tin cá nhân và loại lương.
- **Timecard**: Lớp lưu trữ thông tin về giờ làm việc của nhân viên trong một khoảng thời gian.
- **Paycheck**: Lớp dùng để tạo phiếu lương dựa trên các dữ liệu như giờ làm việc và lương cơ bản.
- **PaymentProcessor**: Lớp chịu trách nhiệm tính toán và xử lý các khoản thanh toán cho nhân viên.
- **DatabaseService**: Lớp lưu trữ thông tin về các phiếu lương vào cơ sở dữ liệu.

### Luồng cơ bản:
1. Hệ thống truy xuất bảng chấm công từ lớp `Timecard` dựa trên `EmployeeID`.
2. Hệ thống tính toán lương dựa trên số giờ làm việc từ bảng chấm công.
3. Phiếu lương được tạo và lưu trữ vào cơ sở dữ liệu.
### Biểu đồ Sequence:

![1](https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0)
---

## Ca Sử Dụng: **Process Direct Deposit**
### Mô tả:
Xử lý gửi tiền lương trực tiếp đến tài khoản ngân hàng của nhân viên.

### Các lớp liên quan:
- **Employee**: Lớp chứa thông tin về nhân viên, bao gồm tài khoản ngân hàng.
- **Paycheck**: Lớp đại diện cho phiếu lương, bao gồm các thông tin thanh toán.
- **BankSystem**: Hệ thống ngân hàng xử lý giao dịch thanh toán trực tiếp.
- **PaymentProcessor**: Lớp chịu trách nhiệm xử lý các yêu cầu thanh toán.

### Luồng cơ bản:
1. Hệ thống lấy thông tin tài khoản ngân hàng từ lớp `Employee`.
2. Hệ thống xác nhận và gửi yêu cầu thanh toán đến hệ thống `BankSystem`.
3. `BankSystem` phản hồi kết quả giao dịch và xác nhận thanh toán thành công.
### Biểu đồ Sequence:
![2](https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0)

---

## Ca Sử Dụng: **View Payment History**
### Mô tả:
Hiển thị lịch sử thanh toán lương của nhân viên.

### Các lớp liên quan:
- **Employee**: Lớp đại diện cho nhân viên yêu cầu lịch sử thanh toán.
- **Paycheck**: Lớp chứa thông tin về các phiếu lương đã thanh toán.
- **PayrollReport**: Lớp tạo và hiển thị báo cáo về các phiếu lương đã thanh toán.

### Luồng cơ bản:
1. Hệ thống truy xuất lịch sử phiếu lương từ lớp `Paycheck`.
2. Hiển thị thông tin cho nhân viên qua giao diện `PayrollReport`.
### Biểu đồ Sequence:

![3](https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0)
#### Code Java Mô Phỏng Ca Sử Dụng Maintain Timecard
```Java
public class Employee {
    private String employeeID;

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}


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
