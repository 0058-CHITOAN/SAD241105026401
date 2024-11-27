
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


