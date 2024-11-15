# Lab 1: Phân Tích Kiến Trúc, Cơ Chế, Ca Sử Dụng cho Hệ Thống Payroll System

#
## 1. Phân Tích Kiến Trúc

#### 1.1 Đề Xuất Kiến Trúc

Hệ thống Payroll System sẽ sử dụng kiến trúc **Layered (Lớp)** với ba lớp chính:
   - **User Interface Layer (Giao diện người dùng):** Cung cấp giao diện cho người dùng tương tác với hệ thống.
   - **Business Logic Layer (Logic kinh doanh):** Xử lý các quy tắc và quy trình liên quan đến tính toán lương và quản lý chấm công.
   - **Data Access Layer (Truy xuất dữ liệu):** Quản lý truy xuất dữ liệu từ cơ sở dữ liệu, bao gồm lưu trữ thông tin nhân viên, bảng chấm công và lịch sử thanh toán.

#### 1.2 Giải Thích Kiến Trúc

   - **User Interface Layer:** Cho phép người dùng nhập và xem thông tin liên quan đến hệ thống.
   - **Business Logic Layer:** Thực hiện các thao tác của hệ thông như tính toán lương theo các quy tắc kinh doanh, bao gồm phụ cấp và các khoản khấu trừ, kết nối cơ sở dữ liệu.
   - **Data Access Layer:** Truy xuất và lưu trữ dữ liệu về nhân viên, lương và thời gian làm việc trong cơ sở dữ liệu.

#### 1.3 Biểu Đồ Package Mô Tả Kiến Trúc
![1.3](https://www.planttext.com/api/plantuml/svg/b991QiCm44NtEiMGVIwGHObBDu440abMfOlfUEAAs5BGI0jJSh8kUgHS8RAC2I56RcUXpVzw_FdIzUTtAHwT3qsjpaWdh1XcMsoThMlOjUAvcS6tWZZfk7iS2nkFNbi3QspP3RvktW_23bR6ipiYCMni6Mh-IFfbXFOQH1iMWRMjD8tmXaXRPodwjAaUcCcprmqJkX8sQ2ArYV6UJKNmNr7Gr2UV2lQ67g4WIjcUKdNg9mhtcoAD85Mc3fZFNtAhmGA2i4mZCfl_cJ5UJBoETo5orCHpzB1SCHqo5JgaogN_5-sYbcpAxYlV0000__y30000)


## 2. Cơ Chế Phân Tích

### Đề Xuất Các Cơ Chế:

1. **Xác thực và phân quyền**: 
   - Kiểm soát quyền truy cập của người dùng dựa trên vai trò, bảo vệ dữ liệu lương nhân viên.
2. **Tính toán lương**: 
   - Tự động tính toán dựa trên thời gian làm việc, phụ cấp, khấu trừ, và các khoản thưởng/phạt.
3. **Ghi nhận thời gian làm việc**: 
   - Lưu trữ chính xác dữ liệu chấm công, bao gồm ngày, giờ bắt đầu và giờ kết thúc ca làm việc.
4. **Xuất báo cáo**: 
   - Cung cấp báo cáo lịch sử thanh toán, thời gian làm việc và các thông tin khác cho quản lý và nhân viên.
5. **Quản lý hồ sơ nhân viên**: 
   - Tạo, cập nhật và lưu trữ hồ sơ nhân viên, bao gồm thông tin cá nhân, hợp đồng, và lịch sử công việc.
6. **Quản lý ngày nghỉ và phép**: 
   - Theo dõi và ghi nhận ngày nghỉ phép, nghỉ lễ và tình trạng nghỉ phép của từng nhân viên.
7. **Thông báo và nhắc nhở**: 
   - Gửi thông báo cho nhân viên và quản lý về các sự kiện quan trọng như ngày trả lương, thời gian làm việc chưa chấm công, hoặc yêu cầu phê duyệt.
8. **Quản lý phê duyệt**: 
   - Cung cấp quy trình phê duyệt cho các yêu cầu như chấm công thủ công, nghỉ phép hoặc điều chỉnh lương.
9. **Lưu trữ lịch sử dữ liệu**: 
   - Lưu trữ lịch sử các giao dịch trả lương, thời gian làm việc và các thay đổi hồ sơ nhân viên để hỗ trợ kiểm toán và tra cứu.
10. **Quản lý thuế và khấu trừ**: 
    - Tự động áp dụng các quy định về thuế và các khoản khấu trừ khác nhau dựa trên quy định hiện hành và vị trí của nhân viên.
      
### Giải Thích Lý Do Chọn Cơ Chế:

1. **Xác thực và phân quyền**:
   - Đảm bảo quyền truy cập chính xác, bảo mật dữ liệu nhạy cảm như lương và thời gian làm việc.
2. **Tính toán lương**:
   - Giúp tự động hóa quy trình trả lương, đảm bảo tính chính xác và tuân thủ quy định.
3. **Ghi nhận thời gian làm việc**:
   - Đảm bảo dữ liệu chấm công chính xác cho các tính toán về lương và năng suất làm việc.
4. **Xuất báo cáo**:
   - Hỗ trợ cung cấp thông tin và tài liệu hữu ích cho quản lý và nhân viên, giúp giám sát và đánh giá hiệu suất.
5. **Quản lý hồ sơ nhân viên**:
   - Dễ dàng tra cứu, cập nhật thông tin nhân viên, hỗ trợ quản lý nhân sự hiệu quả.
6. **Quản lý ngày nghỉ và phép**:
   - Giúp theo dõi và quản lý chính xác số ngày nghỉ, tránh tình trạng nghỉ phép không phù hợp.
7. **Thông báo và nhắc nhở**:
   - Cải thiện trải nghiệm người dùng bằng cách thông báo các sự kiện quan trọng và nhắc nhở để tránh sai sót trong chấm công.
8. **Quản lý phê duyệt**:
   - Đảm bảo các quy trình chấm công, nghỉ phép và điều chỉnh lương được quản lý chính xác và minh bạch.
9. **Lưu trữ lịch sử dữ liệu**:
   - Hỗ trợ kiểm toán, tra cứu lịch sử giao dịch và xử lý tranh chấp một cách dễ dàng.
10. **Quản lý thuế và khấu trừ**:
    - Đảm bảo tính chính xác trong việc trích xuất thuế và các khoản khấu trừ theo quy định, giúp hệ thống tuân thủ pháp lý.
## 3. Phân Tích Ca Sử Dụng Payment

### Xác Định Các Lớp Phân Tích

Để thực hiện chức năng Payment, chúng ta cần các lớp chính sau:

#### 1. Employee
- **Thuộc tính**:
  - `employeeID`: ID của nhân viên
  - `name`: Tên của nhân viên
  - `bankAccount`: Tài khoản ngân hàng của nhân viên
  - `salaryType`: Loại lương của nhân viên (theo giờ hoặc cố định)
- **Nhiệm vụ**: Lưu trữ thông tin về nhân viên và loại hình lương của họ (theo giờ hoặc cố định).

#### 2. PaymentProcessor
- **Thuộc tính**:
  - `paymentID`: ID của khoản thanh toán
  - `amount`: Số tiền thanh toán
  - `date`: Ngày thanh toán
- **Nhiệm vụ**: Thực hiện việc tính toán và xử lý các khoản thanh toán cho nhân viên.

#### 3. Timecard
- **Thuộc tính**:
  - `employeeID`: ID của nhân viên
  - `hoursWorked`: Số giờ làm việc
  - `date`: Ngày làm việc
- **Nhiệm vụ**: Ghi nhận số giờ làm việc của nhân viên, dùng cho nhân viên được trả lương theo giờ.

#### 4. BankService
- **Nhiệm vụ**: Xử lý việc gửi thanh toán đến tài khoản ngân hàng của nhân viên.

#### 5. PayrollReport
- **Thuộc tính**:
  - `reportID`: ID của báo cáo
  - `totalPaid`: Tổng số tiền đã thanh toán
  - `date`: Ngày tạo báo cáo
- **Nhiệm vụ**: Tạo và lưu trữ báo cáo về khoản lương đã trả, dùng cho mục đích báo cáo và kiểm tra.

### Biểu Đồ Sequence Cho Ca Sử Dụng Payment
[3.2]
