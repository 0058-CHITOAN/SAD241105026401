# Lab 3. Identify design elements

# 1. **Biểu Đồ Ngữ Cảnh của Hệ Thống Con BankSystem**

### Mô tả hệ thống con:
**BankSystem** là hệ thống phụ có trách nhiệm xử lý các giao dịch thanh toán lương thông qua chuyển khoản trực tiếp vào tài khoản ngân hàng của nhân viên.

### Các thành phần và giao diện:
- **PayrollController**: Gọi giao diện `IBankSystem` để thực hiện giao dịch thanh toán.
- **IBankSystem**: Giao diện chứa phương thức `deposit()` để chuyển tiền từ phiếu lương vào tài khoản ngân hàng.
- **BankSystem**: Hệ thống phụ thực tế thực hiện giao dịch chuyển tiền.
- **Paycheck**: Lưu trữ thông tin về số tiền và chi tiết phiếu lương.
- **BankInformation**: Chứa thông tin tài khoản ngân hàng của nhân viên.

### Biểu đồ ngữ cảnh:

[1](https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0)

## Biểu Đồ Ngữ Cảnh của Hệ Thống Con PrintService

### Mô tả hệ thống con:
PrintService chịu trách nhiệm in phiếu lương và các tài liệu khác liên quan đến thanh toán lương cho nhân viên.

### Các thành phần và giao diện:
- **PayrollController**: Gọi PrintService để in các phiếu lương.
- **PrintService**: Hệ thống con chịu trách nhiệm thực hiện công việc in ấn.
- **Paycheck**: Dữ liệu được in từ phiếu lương của nhân viên.

### Biểu đồ ngữ cảnh:
(2)[https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0]

## Biểu Đồ Ngữ Cảnh của Hệ Thống Con ProjectManagementDatabase
### Mô tả hệ thống con:
ProjectManagementDatabase chứa thông tin về các dự án và mã số dự án (charge numbers) mà nhân viên làm việc, giúp liên kết thời gian làm việc với các dự án cụ thể.

### Các thành phần và giao diện:
- **Timecard**: Truy xuất thông tin dự án và mã số dự án từ ProjectManagementDatabase để liên kết giờ làm việc với các dự án.
- **ProjectManagementDatabase**: Lưu trữ và cung cấp thông tin về dự án và mã số dự án.
### Biểu đồ ngữ cảnh:
(3)[https://www.planttext.com/api/plantuml/svg/PD5DQWCn30NWlKyXifeiSe4iIg1JIdUXANIjiGKnyOmLMIxaR5tqIBr2FJzE6BgrFfwUxT_ldqDI5CrzC6Wr2hpq7EADo70vzjOp3WgR3z-JHN4Rm0HgryCZtdeQz2ZHKafH9iJy3zapsSiyNCzQLEmmqOdaorkQYEkCgLrWzrIMxk6ThfcIGctJLF3MRerQs1LNZqQjMOOxXd7BAfBv4LdhDRhmKMyDSuNF66mEg0JBTPjpp98-erp8tM5nGWkQytZMBIdwa0gSMhfk3wVot0yu9Qpwrmcyqa1IGfqvqE36h_e3003__mC0]

