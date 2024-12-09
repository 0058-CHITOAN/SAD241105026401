# 📑**Thiết kế các ca sử dụng hệ thống Payroll System**
# Các ca sử dụng hệ thống "Payroll System"
#### I. Danh sách các ca sử dụng chính
- #### Đăng nhập (Login)
- #### Quản lý bảng chấm công (Maintain Timecard)
- #### Chạy bảng lương (Run Payroll)
- #### Xử lý giao dịch ngân hàng (Process Bank Transactions)
- #### In phiếu lương (Print Paychecks)
### 1.Mô tả các ca sử dụng và giải thích 
### 1.1. Đăng nhập (Login)
- **Actor tham gia**: Payroll Administrator, Employee.
#### Dòng chảy chính
1. Người dùng nhập tên đăng nhập và mật khẩu.
2. Hệ thống xác thực thông tin.
3. Nếu thông tin hợp lệ, hệ thống cấp quyền truy cập.
#### Dòng chảy thay thế
- Nếu thông tin không hợp lệ, thông báo lỗi và yêu cầu nhập lại.
### Biểu đồ tuần tự:
![diargam](https://www.planttext.com/api/plantuml/png/Z94nQiCm68LtdU9T81VmK08DRQ6bMw6hh9XOrFxLohz3CsVir1iab0mfP2WK2lAGmRc8Jj0hLBOXDY53D_sFzpwzN_gjzkE2fUKopuHKR2mUYiIAs9GqbNQ1EpFJT6LiBfGXjYRhbCjko88r8TQyQ6CJoJAMHI94Cs5qqSSZtAVUxPx1zIVXy7vOqWpKIVDwXJoS64z1s9RYc3eY-liYNFjgfy5f_HqGh4zeuiJV88RT8ZpMQnNYllfI_sepJ6Dqhj6jTtl6I-dT1rvx-hagWmUvqRvQKkjzQzPPKGhLBfKQxtvQYjimOk_MMemJcZQVz0S00F__0m00)
### Lý do thiết kế
- #### Đảm bảo chỉ những người dùng hợp lệ (Employee, Payroll Administrator) mới có quyền truy cập hệ thống.
- #### Bước xác thực thông tin giúp tăng cường bảo mật và bảo vệ dữ liệu nhạy cảm.
- #### Phản hồi lỗi trực quan khi nhập sai thông tin giúp cải thiện trải nghiệm người dùng.
### 1.2. Quản lý bảng chấm công (Maintain Timecard)
- **Actor tham gia**: Employee.
#### Dòng chảy chính
1. Nhân viên nhập mã chi phí và số giờ làm việc.
2. Hệ thống kiểm tra và cập nhật vào cơ sở dữ liệu.
#### Dòng chảy thay thế
- Nếu nhập sai mã chi phí, hệ thống thông báo lỗi.
#### Biểu đồ tuần tự:
![diargam](https://www.planttext.com/api/plantuml/png/T94xJiGm48Pxd-A_m5uW1Lg9fuH051IqZcDj37u4xsIbr1GKd05fqOeoeg5AYYry4f-0A-3i2jW8fPlvfVdc6_khtywNn3tLHZCko7cScagxHagMkzeMt3UuLKOAxeipvmqJpf9t-ZSytlTQUYOjAMfmuzsz57J5BLz8ay8JJZpdIydO3nkpen4rmtKPkxQ22Hk8Kg4gGujLM6EXOlyA7TO6grG-2tOuTyZv4ybm7ljMWShmQHSWPP77RfDAaRQy6uWXP_y71zoaVORB9F1aG9xlrCJEs0xYX2Bs7z23OSqc4PXD-Dw5Dx4dsH5smd7yT1U3batNnlu53x7R4XxhTE-OD9Us63xv6m00__y30000)
#### Lý do thiết kế:
- #### Hệ thống cần lưu trữ thông tin thời gian làm việc chính xác để phục vụ việc tính lương.
- #### Cho phép nhân viên dễ dàng nhập và cập nhật thông tin thời gian làm việc mà không cần sử dụng các công cụ ngoài hệ thống.
- #### Việc kiểm tra mã chi phí đảm bảo dữ liệu hợp lệ và giảm thiểu sai sót.

### 1.3. Chạy bảng lương (Run Payroll)
- **Actor tham gia**: Payroll Administrator.
#### Dòng chảy chính
1. Hệ thống lấy dữ liệu từ bảng chấm công và hồ sơ nhân viên.
2. Tính toán tiền lương dựa trên thời gian làm việc và loại nhân viên.
3. Gửi thông tin giao dịch đến ngân hàng.
#### Dòng chảy thay thế
- Nếu dữ liệu bảng chấm công không hợp lệ, thông báo lỗi.
#### Biểu đồ tuần tự:
![diargam](https://www.planttext.com/api/plantuml/png/b98nJiGm44Nxd68ki1T8WPO590eA92Xe7STABEm9SYP8hYaeg3X2G2ia9BH8K3a5HT3UmoVW2ZYx2eko0KGv8__tP_xuetcRbiGCLLf5Z5DXu9XPKoYrcsg94I-GGjKtzzQb4YOII98id4ejE3FfFYEMi5Bq_GDzeGehn5S_AIfCcR4mOtX-OaiIEeg-Uy5aPzicXfbt2uBtM-yUAk2vTxM5nBjxp40jdvSrPj6MgaCD1ulXoBkvXTGt2r3IDzTLp-ceSmsyVVq9DjocXr7UQO32z9YtTmYNidt4SSR8Rl-7RCBxGxrv29DnyxEsva7YtHD29bdH9NF3yr-7NnqgXiCGtnK6ww00QbyqqEfAWxjC1QRTl_e4003__mC0)
#### Lý do thiết kế:
- #### Hệ thống tự động hóa quy trình tính toán lương, giúp tiết kiệm thời gian và giảm rủi ro sai sót.
- #### Thuật toán tính toán dựa trên loại nhân viên (theo giờ, hưởng lương tháng, hoặc có hoa hồng) đáp ứng đa dạng yêu cầu.
- #### Tích hợp với ngân hàng để xử lý thanh toán, đảm bảo nhanh chóng và chính xác.

### 1.4. Xử lý giao dịch ngân hàng (Process Bank Transactions)
- **Actor tham gia**: Payroll Administrator.
#### Dòng chảy chính
1. Gửi yêu cầu giao dịch tới ngân hàng thông qua `IBankSystem`.
2. Ngân hàng xác nhận giao dịch thành công.
#### Dòng chảy thay thế
- Nếu giao dịch thất bại, hệ thống lưu lỗi vào nhật ký.
#### Biểu đồ tuần tự:
![diargam](https://www.planttext.com/api/plantuml/png/X90z2W8n48NxdE9Tm0ji8VuKMWesjZ6xkC7i16AssDhI0rXl9GZMmWQno4bo0gzW5X5NLh0PUCDyxytCmzr7EykDBGl5kB3QOC4hevKQfuKa9ZJPgDxDwKkgpB2rBYdbfiA4qtPPxMnMCDPbCHZsiGIpu2uIbJ-N4A4vbTX8hf46Tn0vwyst9f-01Aj8G_bRbuBDESMgVKtiCup1xmLMlXQWF3GNGgv3SnLGmHtb_qMwroMOo-3s5CCZ0Mj2KzCcAbz_EuqoIjldFW400F__0m00)
#### Lý do thiết kế:
- #### Sử dụng giao diện `IBankSystem` để kết nối với hệ thống ngân hàng, giúp giảm độ phức tạp và đảm bảo tính linh hoạt khi tích hợp nhiều ngân hàng.
- #### Quản lý trạng thái giao dịch (thành công hoặc lỗi) giúp theo dõi và xử lý vấn đề kịp thời.
- #### Lưu lỗi vào nhật ký cho phép kiểm tra và giải quyết các vấn đề về thanh toán khi cần.
### 1.5. In phiếu lương (Print Paychecks)
- **Actor tham gia**: Payroll Administrator.
#### Dòng chảy chính
1. Hệ thống tạo tệp phiếu lương.
2. Gửi lệnh in qua `IPrintService`.
#### Dòng chảy thay thế
- Nếu không tìm thấy máy in, thông báo lỗi và yêu cầu kiểm tra kết nối.
#### Biểu đồ tuần tự:
![diargam](https://www.planttext.com/api/plantuml/png/T90n2W8n44Nxd68ku0Ms4CN2Ta4BBMDssGJZH6CYU0AluI8Y20iMLjbYYu3to0cyWgiY1DHouCtxV-PUDxsreThOXIIK6QKXfLkjfEnd2u5afYncL6yXrGBDADSRmNB259gM-Q23zoXpJKYy3PtkDvB0r9yjiE1E5bfcoKLmZGLvkznABCZNmiiIfISm37KbG8PwX_od8gAXyxl4n9SCa0TNuLF1bTyZcE2Eva-3wAu4njnViO2PBnNCssm3AnlSeJMHNexPyvaF0000__y30000)
#### Lý do thiết kế:
- #### Việc in phiếu lương cung cấp bằng chứng rõ ràng về các khoản thanh toán cho nhân viên.
- #### Sử dụng giao diện `IPrintService` đảm bảo khả năng tương thích với nhiều loại máy in khác nhau.
- #### Quản lý lỗi kết nối máy in giúp người dùng nhanh chóng phát hiện và sửa chữa vấn đề.
## 2. Giải thích tổng hợp các ca sử dụng
### Lý do thiết kế hệ thống
- #### Tính toàn vẹn dữ liệu
  - #### Mỗi ca sử dụng đều bao gồm bước xác thực và kiểm tra tính hợp lệ, đảm bảo dữ liệu được xử lý chính xác.
- #### Đơn giản hóa quy trình
  - #### Thiết kế từng ca sử dụng tương ứng với các chức năng cụ thể trong tài liệu.
- #### Tăng khả năng tái sử dụng
  - #### Các phân hệ (Subsystem) như `BankSystem`, `PrintService` được thiết kế thành các giao diện độc lập, dễ dàng tái sử dụng trong các hệ thống khác.
- #### Đáp ứng yêu cầu người dùng
  - #### Căn cứ trên tài liệu, các ca sử dụng đã bao phủ toàn bộ quy trình hoạt động của hệ thống tính lương.
 ### Tích hợp và mở rộng
  - #### Hệ thống cần khả năng tích hợp với các dịch vụ ngân hàng hoặc hệ thống quản lý tài chính bên ngoài.
  - #### Dễ dàng mở rộng để thêm các tính năng như quản lý thuế, bảo hiểm xã hội.
