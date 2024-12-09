# 📑**Lab 1: Phân Tích Kiến Trúc, Cơ Chế, Ca Sử Dụng cho Hệ Thống Payroll System**

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
![3.1](https://www.planttext.com/api/plantuml/svg/P95DJiCm48NtFiMegrHgBv05glYHO5TH9DQECq1KssF6OwIUZGL7uWhOJPnGTUltvdrlnh_VFxiecYKvgxGHOdXmmT89KONyF9WXQ2-mskkJGozx9eCn4gz0HmZXqlGoE3IQ-xCevbAyrVvuGFuQ39xrBbuHcAnzna0iOpmhLTl0zYRZMc3yJ1XbgjEiLGX54jF2EyeZ9Owln4Vi6vmcd-xNIWnivm19xE5ZSKuHHJJQccIrOCtNZfANIkbY2n5zNzK5iO7gxEAC2gFjZlpRm4xBGBwokDJro2DgsRkPPfR43VJPb1lmlnMAzIesg_LQC_kGJFclVATTxbq--Gy00F__0m00)

### Giải Thích Biểu Đồ Sequence

1. **Employee** gửi yêu cầu thanh toán đến **PaymentProcessor** thông qua hàm `requestPayment()`.
2. **PaymentProcessor** kiểm tra giờ làm việc (nếu cần) bằng cách truy vấn lớp **Timecard** để nhận số giờ đã làm.
3. **PaymentProcessor** tính toán tổng tiền thanh toán.
4. Sau đó, **PaymentProcessor** yêu cầu **BankService** xử lý thanh toán đến tài khoản ngân hàng của nhân viên.
5. **BankService** xác nhận thanh toán thành công, trả kết quả về **PaymentProcessor**.
6. **PaymentProcessor** tạo báo cáo thanh toán bằng cách gọi **PayrollReport**.
7. **PayrollReport** xác nhận báo cáo đã hoàn thành.
8. Cuối cùng, **PaymentProcessor** gửi thông báo thành công về thanh toán đến **Employee**.

### Biểu Đồ Lớp Cho Ca Sử Dụng Payment
![3.2](https://www.planttext.com/api/plantuml/svg/Z5FDReCm3Bxp53aMgNq13bCtCMcxeRLIpswmEjJyC2UPXAezsGvxfBt2iX8e4D368L9in_v-pFVdrzPO8EkaIBW0OzYZh8Lk4DabOVxRC0o1vpnZEqkLEeM40ecJq17K-PvpxPITP0m8e6RVrECdZ16-EJIsW4QYigiq-KW2aX0gI7CqHbEFg6uJ4I2GxU1SkwF042p1-f6vFyD03e8xuU_To5Vjo1mqdR7itgQZ9X78M981x7qbaGELVmiuCtW9z0djqwrw3a3VeGVouCtO8RrNl3EJCOEgN6QndaWuDeEq42zOQx8zDRfU8s9MMn05LF-WfP1QAsxTLv6_KrphGQShndvfDtVHscJnYaMRvPzrjcLJhUVB1-9c8rNdoqS4imNUQRBrZNv_nHy0003__mC0)

### Giải Thích Biểu Đồ Lớp

1. **Employee** gửi yêu cầu thanh toán đến **PaymentProcessor**, nơi tính toán tổng số tiền cần trả.
2. **PaymentProcessor** truy vấn **Timecard** để lấy số giờ làm việc của nhân viên nếu họ được trả lương theo giờ.
3. Sau khi tính toán thanh toán, **PaymentProcessor** gọi **BankService** để gửi tiền vào tài khoản của **Employee**.
4. **PayrollReport** được gọi để tạo báo cáo thanh toán sau khi quá trình thanh toán hoàn tất.

## 4. Phân Tích Ca Sử Dụng Maintain Timecard

#### Xác Định Các Lớp Phân Tích

Để thực hiện chức năng **Maintain Timecard**, chúng ta cần các lớp chính sau:

1. **Employee**:
   - **Thuộc tính**: `employeeID`, `name`
   - **Nhiệm vụ**: Đại diện cho nhân viên, gửi yêu cầu thêm hoặc chỉnh sửa thông tin chấm công.

2. **Timecard**:
   - **Thuộc tính**: `timecardID`, `employeeID`, `hoursWorked`, `date`
   - **Nhiệm vụ**: Lưu trữ thông tin chấm công của từng nhân viên.

3. **TimecardManager**:
   - **Thuộc tính**: Không cần (hoạt động như lớp trung gian xử lý logic).
   - **Nhiệm vụ**: Thêm mới, chỉnh sửa hoặc xóa thông tin chấm công, xác thực dữ liệu trước khi cập nhật.

4. **DatabaseService**:
   - **Nhiệm vụ**: Lưu trữ và truy vấn thông tin chấm công từ cơ sở dữ liệu.

---

#### Biểu Đồ Sequence Cho Ca Sử Dụng Maintain Timecard

##### Dưới đây là biểu đồ sequence mô tả luồng xử lý khi nhân viên thêm hoặc cập nhật thông tin chấm công:

![4.1](https://www.planttext.com/api/plantuml/svg/R90z3i8m34RtdC9YAWCNw810m8WOGEmcCSXIavJ4HUhP63WILo2XH8YVrT_xdYtVhxTP50pIsKQX5XzWPTl6zqIgJMFMtA8J6EtOaiPWrkZmH644646q_G-zqizmYO87ZBIbS65DJyOSeb9b8KocMLb3e7D7KUR6RCBAi5JoycR5M2LcG6kuOCC6XNBmGy6a2BLtHmvsd-bIJwjhwDhSBcT_6HBnLWpaOX2Xi7U3AENb_XgS5pxssqvhYh4Qgnavan_x0000__y30000)
##### Mô tả
**Nhân viên đăng nhập vào hệ thống.**

**Nhân viên thêm, chỉnh sửa hoặc xóa thông tin trên bảng chấm công.**

**Hệ thống lưu các thay đổi.**

**Nhân viên xác nhận hoàn tất.**

### Biểu Đồ Lớp Cho Ca Sử Dụng Maintain Timecard

##### Dưới đây là biểu đồ lớp mô tả các lớp phân tích và mối quan hệ giữa các lớp:

![4.2](https://www.planttext.com/api/plantuml/svg/d98zJiGm48Lxds9AKkG25bgjK2YGe5eGzMpoj5WuzkAVI0XnCWgEn1Lmm0vBmag02yjwC-Fv_3nlBwzh7zY5s6lHQlQUplkzjey0FGbAgoPauQAHj0bEcLqE6ExnJI9oU8ZmuMRVSS2rwj6owqv2FZGSM5AHA_4iSiyYJJrBnQBdKPWx6vs_jUuUdQJ6ngr6ZemeIKfxXXnOgqE-4UiOewGpQpNOB66lsF0EBZF_zzhFslX7myR0bZqsS8DgCJ7yyfxoMSb035_fItCJwANouRIah4Q4QKBgUZLtGypTESoHaqSVtbG_9i-U9kTlgiGQfalp-Wu00F__0m00)
### Giải Thích Biểu Đồ Lớp

1. **Employee (Nhân Viên):**  
   - Lớp này chịu trách nhiệm gửi yêu cầu cập nhật hoặc thêm thông tin chấm công.

2. **Timecard (Bảng Chấm Công):**  
   - Lớp này lưu trữ thông tin về giờ làm việc và ngày làm việc của nhân viên.  
   - Nó cũng chịu trách nhiệm xác thực dữ liệu chấm công.

3. **TimecardManager (Quản Lý Bảng Chấm Công):**  
   - Lớp này là nơi xử lý logic, bao gồm việc xác thực dữ liệu và yêu cầu cập nhật dữ liệu vào cơ sở dữ liệu.

4. **DatabaseService (Dịch Vụ Cơ Sở Dữ Liệu):**  
   - Lớp này lưu trữ và truy vấn thông tin chấm công từ cơ sở dữ liệu, đảm bảo dữ liệu được cập nhật đúng cách.

## 5. Hợp Nhất Kết Quả Phân Tích

### Tổng Quan  
Sau khi phân tích hai ca sử dụng **Payment** và **Maintain Timecard**, ta có thể hợp nhất kết quả để xây dựng một hệ thống quản lý bảng lương (Payroll System) toàn diện. Các thành phần và lớp phân tích từ hai ca sử dụng sẽ được tích hợp để đảm bảo hệ thống hoạt động mạch lạc, hiệu quả và có khả năng mở rộng.

---

### Các Lớp Phân Tích Hợp Nhất

| **Lớp**              | **Thuộc Tính Chính**                                                                                     | **Nhiệm Vụ**                                                                                  |
|-----------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| **Employee**          | `employeeID`, `name`, `bankAccount`, `salaryType`                                                      | Gửi yêu cầu thanh toán và cập nhật thông tin chấm công.                                        |
| **Timecard**          | `timecardID`, `employeeID`, `hoursWorked`, `date`                                                      | Lưu trữ và xác thực thông tin chấm công.                                                      |
| **TimecardManager**   | Không cần thuộc tính.                                                                                   | Xử lý logic: xác thực dữ liệu chấm công, thêm/sửa/xóa thông tin chấm công.                   |
| **PaymentProcessor**  | `paymentID`, `amount`, `date`                                                                          | Tính toán và xử lý thanh toán cho nhân viên.                                                  |
| **BankService**       | Không cần thuộc tính.                                                                                   | Thực hiện việc gửi thanh toán đến tài khoản ngân hàng của nhân viên.                         |
| **PayrollReport**     | `reportID`, `totalPaid`, `date`                                                                        | Tạo và lưu trữ báo cáo thanh toán.                                                            |
| **DatabaseService**   | Không cần thuộc tính.                                                                                   | Lưu trữ và truy vấn thông tin từ cơ sở dữ liệu (chấm công, thanh toán, nhân viên).            |

---

### Biểu Đồ Lớp Hợp Nhất
![5.1](https://www.planttext.com/api/plantuml/svg/d5HBReCm4Drp2Y-3b5p0gg8qeb8hjLBKfEfw0YEAOcng6oHKzMHTz4YzGXsm2PYGHcM1y6U6zzwycP-lxvNI87MPio1ce1IvomicQaJo4H3pB0ZQZOU8agsM6K_j0OSSlQqzyCDj78kIQ-z40GDPx-fY64A8nFSIbNuf4j2uotACGIOpRJyYq429smw7CHkeS-Hw5bAo5e8XyE0pi3HSI4V3PHpHcEJt9agfNeKyO4999CezGtjoX6gspDi2ge1bVVn7s5CSBe1z0WufIelvlsdRsF8wGJiCLioD534g9MGdND4UZEI1l2tpPMLYO779pDeLQontECX1ID52k11mGhqsXjkYhB8OEzKKycGwUEu17qeW1MFFM0YfE_woMOxeQw61RI3xqnifSfHcsQQTZUJq0SrxANhWZeNRWqAVxPLrTerZVedLwVhPQZncIj-uAqkdAbIkXX5go9XoLEZ8EmtiRf0i5alVuTI77GP-3_IZQDS9JGUSl-m9H1l4lHyCyFY8wMYc1AE6629AKT-V1iJK_Pu_gM_iYP212wbldp3mZJ15fwsq5MnbUiBC-5y0003__mC0)
## Tổng Kết

### Kết Nối Giữa Các Lớp
Kết hợp các lớp từ hai ca sử dụng để tạo ra một hệ thống tích hợp, cho phép:
- Quản lý thông tin nhân viên.
- Xử lý bảng chấm công.
- Thực hiện thanh toán lương.

---

### Tính Năng Chính
- **Quản lý thông tin chấm công của nhân viên:**  
  Hệ thống lưu trữ và xác thực thông tin thời gian làm việc của từng nhân viên.  

- **Xử lý và xác nhận thanh toán lương:**  
  Thực hiện các bước tính toán, gửi thanh toán qua ngân hàng và cập nhật trạng thái.  

- **Tạo báo cáo chi tiết về các khoản thanh toán đã thực hiện:**  
  Báo cáo bao gồm các thông tin về nhân viên, tổng số tiền đã trả và thời gian thực hiện thanh toán.

---

### Ưu Điểm Của Hệ Thống Hợp Nhất
- **Hiệu quả:**  
  Dữ liệu và logic được tích hợp một cách liền mạch, giảm thiểu lỗi và tăng tốc độ xử lý.  

- **Mở rộng:**  
  Hệ thống có khả năng nâng cấp dễ dàng để thêm các chức năng mới, như quản lý thuế, bảo hiểm hoặc các báo cáo chi tiết hơn.  

- **Độ chính xác:**  
  Các bước xác thực dữ liệu và quy trình xử lý đều đảm bảo tuân thủ các quy định, giúp giảm thiểu sai sót.





