# 📑**Thiết kế hệ thống Payroll System**

## **1. Biểu đồ ngữ cảnh các hệ thống con**

### **Hệ thống con BankSystem**

![BankSystem](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9IG69bKNvEZa9mPN59QgwIGcAn0bI8ApMl9BEaKa79AJ4l6raUnEVYWcdKrRK3YoXOARW_tBqsKw7oyAfIXUI7kvQNAgHd9kOhf3pStPsSmGLM0r8CqsYb493nSDVYF8MCXxidPwAeTKZDIm6v4G000F__0m00)

#### **Mô tả:**
- **Chức năng**:
  - Gửi lệnh chuyển khoản từ hệ thống Payroll.
  - Nhận xác nhận hoặc thông báo lỗi từ ngân hàng.
- **Interfaces**:
  - **Input**: Giao thức chuyển khoản (PaymentCommand).
  - **Output**: Phản hồi giao dịch (PaymentResponse).

---

### **Hệ thống con PrintService**

![PrintService](https://www.planttext.com/api/plantuml/png/L8yn2eCm68NtdEBXxWKSYaSGd3e66veVOYpnJy5pz0JIeT2fSnmS1E-H4_GArTOEhj_xteFt7iQyPUdOrqR8YXk7f92TQun1sRMiwWIonOQ4iapSBOeZooYLkrAbViPADY34Vo9D3xi46OxJqwEAuU515XTDCOmUPdxDlJsBdVnjRqiP2Xt3tKB7uKPW5yFYW_NKayYLFQq7FW000F__0m00)


#### **Mô tả:**
- **Chức năng**:
  - Nhận yêu cầu in phiếu lương từ Payroll System.
  - Trả về trạng thái hoàn thành hoặc lỗi khi in.
- **Interfaces**:
  - **Input**: PrintRequest.
  - **Output**: PrintStatus.

---

### **Hệ thống con ProjectManagementDatabase**

![ProjectManagementDatabase](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9IG69bKNvEZa9mPN59QgwIGcAn0bI8ApMl9BEa4gYaA3yhDRb4mJSnBp4zDHSehE2IM9AOb5YS2b4FaNTnukA2cQQhQuSGLh1IY3oygbGX-U6kvQKAkOSNAwGytBrHuV32F2w46h0Eg6uhXP2YXxiMAvGztDseK99nU4jUka99PXv2cqDgNWh83m00003__mC0)


#### **Mô tả:**
- **Chức năng**:
  - Cung cấp danh sách mã dự án và thông tin liên quan.
- **Interfaces**:
  - **Input**: ProjectQuery.
  - **Output**: ProjectData.

---

## **2. Ánh xạ các lớp phân tích đến phần tử thiết kế**

| **Analysis Class**         | **Design Element**       |
|----------------------------|----------------------------|
| Employee                  | EmployeeEntity            |
| Timecard                  | TimecardEntity            |
| PaymentMethod             | PaymentProcessorInterface |
| Payroll Administrator     | AdminService              |
| Project Management System | ProjectManagementService  |

---

## **3. Ánh xạ phần tử thiết kế vào các gói**

| **Design Element**       | **Owning Package**        |
|----------------------------|---------------------|
| EmployeeEntity            | `com.payroll.model` |
| TimecardEntity            | `com.payroll.model` |
| PaymentProcessorInterface | `com.payroll.utils` |
| AdminService              | `com.payroll.service` |
| ProjectManagementService  | `com.payroll.service` |

---

## **4. Các lớp kiến trúc và quan hệ**

### **Biểu đồ phân lớp**
![OverView](https://www.planttext.com/api/plantuml/png/V9E_Jjn04CPxFyM89XKlG15n48YGxX1II8LI37iRUy4UE_ldX8MeA6YXZb8S4eg4X18agdD1OSHxx1Fm2eonm_aSWykP_NxxpJVhf-9-rLZKrYLnaA4un532qewMHf95grA28UPIBy5n0FpjVJLImnPPgR-ZaD_guZ0D5S5cgfEciAiIAL2Fczf9C6SFiYnMeW_TxdoHUg8gVbkwvemYQSo_hka0TZ3NQHpFnNLLfmTIM1WXCINXkVhfdz0Y38IeBbZaLfrzDBBfDjoD98lJN4gesfsxwbARld74aH6okTnOcPXN-1hIOLDyXQYEnmymyiM5WXyE2I9Vd46eVF47GPHJ0R4lVcP1TpEmlFonFrDOWS--k56GbzSEX9_zTa5xXUyg7yuVJYa4YlpiXYzTN7IjxAw1LTilny6ozr-ApIC5_nzx4NUpPl6kTZaSEJ-xiZ3ciI7cuSySUoWl2IQgl7wJrWwNIUkHotrnIX0__dsSKXYyzpYQOTeRPSIGRUGyI7d7ALYEZ1tTGZbzqyBYDfcmHP15oi_ktTn6RzZr1Frllc-9G65K9PF1n1TNmQgaSVLNFmC00F__0m00)


## Mô tả các lớp kiến trúc trong hệ thống
### 4.1. Lớp Giao diện Người dùng

- **Chức năng**: Lớp này chịu trách nhiệm giao tiếp với người dùng và hiển thị giao diện người dùng.
- **Các thành phần**:
  - **User Interface**: Hiển thị các form như đăng nhập, bảng chấm công, thông tin nhân viên.
  - **Login Form**: Giao diện đăng nhập để người dùng có thể xác thực.
  - **Timecard Form**: Giao diện nhập bảng chấm công cho nhân viên.

### 4.2. Lớp Ứng dụng

- **Chức năng**: Xử lý các yêu cầu từ lớp Presentation và điều phối các dịch vụ của hệ thống.
- **Các thành phần**:
  - **Application Service**: Lớp này điều phối các yêu cầu giữa lớp giao diện người dùng và các dịch vụ nghiệp vụ.

### 4.3. Lớp Dịch vụ Nghiệp vụ

- **Chức năng**: Chứa các logic nghiệp vụ chính của hệ thống, bao gồm tính toán lương và các dịch vụ liên quan đến dự án.
- **Các thành phần**:
  - **Payroll Service**: Xử lý các yêu cầu liên quan đến tính toán lương và các dịch vụ liên quan.
  - **Project Management Service**: Xử lý thông tin về các dự án mà nhân viên tham gia.

### 4.4. Lớp Truy cập Dữ liệu

- **Chức năng**: Truy cập và thao tác với cơ sở dữ liệu để lưu trữ và lấy dữ liệu.
- **Các thành phần**:
  - **Database Access**: Cung cấp các phương thức để truy xuất và thao tác với cơ sở dữ liệu.
  - **Employee Data**: Lưu trữ thông tin về nhân viên.
  - **Project Data**: Lưu trữ thông tin về dự án và các bảng chấm công.

### 4.5. Lớp Hệ thống Ngoài

- **Chức năng**: Tích hợp với các hệ thống ngoài để thực hiện các nhiệm vụ như chuyển tiền và in ấn phiếu lương.
- **Các thành phần**:
  - **Bank System**: Hệ thống ngân hàng, xử lý các giao dịch chuyển tiền lương cho nhân viên.
  - **Print Service**: Hệ thống in phiếu lương, gửi phiếu lương cho nhân viên.

### 4.6. Mối Quan Hệ Giữa Các Lớp

Các lớp trong hệ thống có mối quan hệ như sau:
- **User Interface** gửi yêu cầu đến **Application Service** để xử lý.
- **Payroll Service** tương tác với **Database Access** để truy xuất dữ liệu nhân viên và bảng chấm công.
- **Bank System** được gọi từ **Payroll Service** để thực hiện giao dịch chuyển lương cho nhân viên.
- **Print Service** được gọi từ **Payroll Service** để in phiếu lương.
---
# 5. Trình bày tài liệu thiết kế

Tài liệu thiết kế chi tiết sẽ trình bày các phần tử của hệ thống, mô tả các lớp và mối quan hệ giữa chúng, cùng với các biểu đồ UML để giúp hiểu rõ cách thức các thành phần tương tác.

## 5.1. Các phần tử thiết kế

### Các lớp trong hệ thống:

1. **Presentation Layer**: Chứa giao diện người dùng và các form nhập liệu.
2. **Application Layer**: Xử lý các yêu cầu và điều phối hoạt động giữa các lớp.
3. **Business Services Layer**: Chứa các dịch vụ tính toán lương và quản lý dự án.
4. **Data Access Layer**: Xử lý các yêu cầu truy cập và lưu trữ dữ liệu.
5. **External Systems**: Tích hợp với các hệ thống ngoài như ngân hàng và in ấn.

### Giao diện giữa các lớp:
- **Application Service** giao tiếp với các dịch vụ nghiệp vụ trong **Business Services Layer**.
- **Payroll Service** giao tiếp với **Bank System** và **Print Service**.

