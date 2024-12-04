# Lab 3. Identify design elements

# 1. **Biểu Đồ Ngữ Cảnh của Hệ Thống Con BankSystem**

### Mô tả hệ thống con:
### **BankSystem** là hệ thống phụ có trách nhiệm xử lý các giao dịch thanh toán lương thông qua chuyển khoản trực tiếp vào tài khoản ngân hàng của nhân viên.

### Các thành phần và giao diện:
### 1.1. PayrollSystem (Control Class)
- **Vai trò**: Là lớp điều khiển chính (controller) trong hệ thống xử lý lương.
- **Chức năng**: Gửi các yêu cầu **Payment Instructions** (hướng dẫn thanh toán) đến giao diện trung gian `IBankService`.

---

### 1.2. IBankService (Interface)
- **Vai trò**: Giao diện trung gian giữa lớp điều khiển (`PayrollSystem`) và hệ thống con thực tế (`BankSystem`).
- **Phương thức cung cấp**:
  - `processPayment(aInstruction: PaymentInstruction)`: Xử lý yêu cầu thanh toán.
  - `getAccountBalance(): AccountBalance`: Truy vấn số dư tài khoản ngân hàng.
  - `sendStatement(aStatement: BankStatement)`: Gửi bảng sao kê ngân hàng.

---

### 1.3. BankSystem (Subsystem Proxy)
- **Vai trò**: Là lớp đại diện cho hệ thống con thực tế, nơi thực hiện các chức năng tài chính liên quan.
- **Mối quan hệ**:
  - Thực thi giao diện `IBankService`.
- **Phương thức cung cấp**:
  - `processPayment(aInstruction: PaymentInstruction)`: Thực hiện logic xử lý thanh toán thực tế.
  - `getAccountBalance(): AccountBalance`: Cung cấp số dư tài khoản.
  - `sendStatement(aStatement: BankStatement)`: Gửi bảng sao kê chi tiết cho các giao dịch.

---

### 1.4. PaymentInstruction (Entity)
- **Vai trò**: Là thực thể chứa thông tin chi tiết về hướng dẫn thanh toán (Payment Instructions).
- **Dữ liệu chứa**:
  - Thông tin tài khoản người nhận.
  - Số tiền cần thanh toán.
  - Thời gian thực hiện.

---

### 1.5. PaymentConfirmation (Entity)
- **Vai trò**: Là thực thể xác nhận giao dịch đã hoàn tất.
- **Dữ liệu chứa**:
  - Trạng thái giao dịch (thành công hoặc thất bại).
  - Mã xác nhận giao dịch.

---

### 1.6. AccountBalance (Entity)
- **Vai trò**: Là thực thể đại diện cho số dư tài khoản ngân hàng.
- **Dữ liệu chứa**:
  - Số tiền hiện tại trong tài khoản.
  - Ngày cập nhật số dư gần nhất.

---

### 1.7. BankStatement (Entity)
- **Vai trò**: Là thực thể lưu trữ thông tin chi tiết về các giao dịch tài chính của tài khoản ngân hàng.
- **Dữ liệu chứa**:
  - Danh sách các giao dịch.
  - Số dư đầu kỳ và cuối kỳ.
  - Ngày thực hiện giao dịch.

---

### Biểu đồ ngữ cảnh:

![1](https://www.planttext.com/api/plantuml/png/pLEnJiCm4Dqj-H-iCj0CKVSgYaeHGoI6YaoCnhYjXMD7lWiG0V-ExP8qRWipsvtzxkwzy_CAa3li6at9DRkr1ftreT0SWCqslFUfhdj0sSmO1vQSiA8GXugoP1-KCBPOC93cEU8QQP1L1j1r0fKrGCaN9M5CPL2wBHUI4ZM4h5fpyr9BzwfyKXGZPcZTEYiam4_ZEPzqPijXtkGm2qKxYJT2sCxWccjkX9nd7fmU1LmWNIFtccBlCVJWI6l8ir53tJt1OGaRPz_xSMKHVjpNCVMQOAnfGurNTdMlTdjyb5hRjtyfyywWmb7T-NYlIaP8MPw0l9UsoZNy5rHAxW8W8PJS1ruFKiVEi5UjDrPgopmlKpij_tHbwhpFF9-y6YMJ5mnzBwWxmvmk_kGwKKR9obEB_-yR "BankSystem")

# Biểu Đồ Ngữ Cảnh của Hệ Thống Con PrintService

### Mô tả hệ thống con:
## PrintService là một hệ thống con trong Payroll System, chịu trách nhiệm xử lý các yêu cầu in ấn. Cụ thể, nó đảm nhận việc nhận tài liệu cần in (như phiếu lương) và tương tác với máy in để hoàn tất quá trình in.


### **Chi Tiết Thành Phần và Giao Diện**

### **1. Interface: `IPrintService`**
## **Vai trò**
- Giao diện trừu tượng cho các chức năng in ấn.

### **Phương thức**
- printDocument(aDocument: Document, onPrinter: Printer): void
  - Yêu cầu in một tài liệu (`Document`) trên một máy in (`Printer`).

---

### **2. Subsystem Proxy: `PrintService`**
## **Vai trò**
- Hệ thống con thực tế chịu trách nhiệm xử lý các yêu cầu in ấn.

## **Chức năng**
1. `printDocument(document: Document, printer: Printer): void`
   - Thực thi việc in tài liệu.
2. `checkPrintStatus(printerId: String): String`
   - Kiểm tra trạng thái của máy in dựa trên `printerId`.

## **Quan hệ**
- **Tương tác với `Document`**: Xử lý các tài liệu cần in.
- **Tương tác với `Printer`**: Gửi tài liệu đến máy in.

---

### **3. Entity: `Document`**
## **Vai trò**
- Đại diện cho tài liệu cần in.

## **Thuộc tính**
- `documentId: String`
  - Mã định danh tài liệu.
- `content: String`
  - Nội dung của tài liệu.
- `format: String`
  - Định dạng (format) của tài liệu (ví dụ: PDF, DOCX).

## **Phương thức**
- `validateDocument(): boolean`
  - Kiểm tra tính hợp lệ của tài liệu trước khi in.

---

### **4. Entity: `Printer`**
## **Vai trò**
- Đại diện cho máy in trong hệ thống.

## **Thuộc tính**
- `printerId: String`
  - Mã định danh máy in.
- `status: String`
  - Trạng thái của máy in (ví dụ: "Online", "Busy", "Offline").
- `location: String`
  - Vị trí của máy in.

## **Phương thức**
- `printDocument(document: Document): void`
  - In tài liệu đã được cung cấp.

---

### Biểu đồ ngữ cảnh:
![2](https://www.planttext.com/api/plantuml/png/Z9DDRi8m48NtEOML5KWD1uYgYWLTP8UK4mpEG2qSEx8d4QZbP5rm9AvGvyUDGr2fLoFFyyoNDvFRztLj2GpLfOmgu4Su88lpUcVFbh1aMwDFvvXzHimTBi5QToKKvMWQmN58zATg4nlDwn8LBOeXI9c_UkaLQDA-1ffboXejYg06_q1-x3iGK6qNmvEiI5bEBZuiVT2zkaINQEH-LoJe3jTtdw1wkB5ioA1TnnPybjbhKy8yaIH986f0YW88Vvrmn3kj9O8QaE_DH3FtCVpa86SxLnuafEP0GgidSCzc54vawctMCks1exTN-0kM_NCbOFDW9xJQ_h4L7SEaV9AyZJDDMLmPpT5QjF5SvzrrihfJJ4bVlrQhwJexeIWhYMrn9r-ZAjeVumS00F__0m00)

## Biểu Đồ Ngữ Cảnh của Hệ Thống Con ProjectManagementDatabase
### Mô tả hệ thống con:
ProjectManagementDatabase chứa thông tin về các dự án và mã số dự án (charge numbers) mà nhân viên làm việc, giúp liên kết thời gian làm việc với các dự án cụ thể.

### Các thành phần và giao diện:
- # 1. PayrollController
**Loại**: Control  
**Vai trò**:  
Là lớp điều khiển, chịu trách nhiệm gọi các phương thức từ `IProjectDatabase` để truy vấn thông tin dữ liệu dự án.  
**Phương thức chính**: 
- `queryProjectData()`

---

# 2. IProjectDatabase
**Loại**: Interface  
**Vai trò**:  
Là giao diện định nghĩa các chức năng cần thiết để truy xuất thông tin dự án từ cơ sở dữ liệu.  
**Phương thức**: 
- `getProjectInfo(projectId: String): ProjectData`  
Lấy thông tin dự án dựa trên ID dự án.

---

# 3. ProjectManagementDatabase
**Loại**: Subsystem Proxy  
**Vai trò**:  
Là hệ thống con thực tế, triển khai giao diện `IProjectDatabase`.  
Thực hiện truy xuất dữ liệu dự án.  
**Phương thức**:
- `getProjectInfo(projectId: String): ProjectData`

---

# 4. ProjectData
**Loại**: Entity  
**Vai trò**:  
Đại diện cho dữ liệu của một dự án trong hệ thống.  
**Thuộc tính và chi tiết của `ProjectData`** có thể bao gồm:
- `projectId`: ID của dự án.
- Các thông tin khác về dự án như tên, mô tả, trạng thái, hoặc tiến độ.

### Biểu đồ ngữ cảnh:
![3](https://www.planttext.com/api/plantuml/png/f5AzJiCm4Dxz5ASoq0vHzwgoAW5392fLT6Ay9jVKoB63VG4YuCaOU2HU0Rj98qiPkztvFdr_yj_FxyOpEcvhBMxXpXfsLej2e_Smss4NDZsyQd8pG0-JLrYlYtwH4Zu5m789hosvRkVi2nLyZuppXVWMGI4tJEw81GbrcI1FS0Vq5FX6sC1O4G-Wt1pjl1dc4bQmPwTCjGXJGjEBxTk3xpnJ7KyVtHYhnstHO4KrcL6uZxTDVFYHeOaCmStDewfE_4nQs_Shh3qOLdnnb5o39frFKaRO4sbaPOq_gSQBQVDP9gVrhSxjA_9GHiOtXM9QyLUM9L55aZfofdutPChuFVu1003__mC0 )

# *2.Analysis class to design element map*

### Mapping Analysis Classes to Design Elements

| **Analysis Class**             | **Design Element**              |
|--------------------------------|---------------------------------|
| **LoginForm**                  | **LoginForm**                   |
| **MaintainTimecardForm**       | **MainEmployeeForm**            |
|                                | **TimecardForm**                |
|                                |  **MainApplicationForm**        |
| **TimecardController**         | **TimecardController**          |
| **SystemClockInterface**       | **SystemClockInterface**        |
| **PayrollController**          | **PayrollController**           |
| **Paycheck**                   | **Paycheck**                    |
| **PaymentInstruction**         | **PaymentInstruction**          |
| **Employee**                   | **Employee**                    |
| **IEmployeeRepository**        | **IEmployeeRepository**         |
| **IPaymentRepository**         | **IPaymentRepository**          |
| **BankSystem**                 | **BankSystem**                  |
| **IBankSystem**                | **IBankSystem**                 |
| **ProjectManagementDatabase**  | **ProjectManagementDatabase**   |
| **IProjectDatabase**           | **IProjectDatabase**            |
| **ProjectData**                | **ProjectData**                 |

# **3. Design element to owning package map**

### Mapping Design Elements to Owning Packages


| **Design Element**        | **"Owning" Package**                        |
|---------------------------|--------------------------------------------|
| **UserInterface**          | Middleware::Presentation::GUI Framework    |
| **PayrollController**      | Applications::Payroll::BusinessLogic       |
| **TimecardController**     | Applications::Payroll::BusinessLogic       |
| **EmployeeRepository**     | DataAccess::Employee::Repository           |
| **PaymentRepository**      | DataAccess::Payment::Repository            |
| **Database**               | DataAccess::Database::Connection           |
| **Paycheck**               | BusinessServices::Payroll::Artifacts       |
| **PaymentInstruction**     | BusinessServices::Payroll::Artifacts       |
| **IEmployeeRepository**    | Interfaces::Employee::RepositoryInterface  |
| **IPaymentRepository**     | Interfaces::Payment::RepositoryInterface   |
| **IBankSystem**            | Interfaces::Bank::SystemInterface          |
| **IProjectDatabase**       | Interfaces::Project::DatabaseInterface     |
| **BankSystem**             | Subsystems::Bank::PaymentProcessing        |
| **ProjectManagementDatabase** | Subsystems::Project::DatabaseManagement |
| **ProjectData**            | BusinessServices::Project::DataArtifacts   |


# **4. Architectural layers and their dependencies**
![PlanText](https://www.planttext.com/api/plantuml/png/X59BJiCm4Dtx54Cth7g1Bb1_4Pk0AW8769nfCNNioEDKYe2JiU18N04xAKb_KRsnv9dtbN-_VwRiqVcgqE8cfxKo14_9uddsU9yc83Ko2t4BotQYiIR7eaIvnGt1QEM8oNZqoXf8ut047mB2wJbMM3khzS8Q7szoualq3FEA0p4pf7QZv227KyPdv7PAqibeZcQRrUofECFOTvB-0KqGAeBB9NfyHQOZ_VW8CoaR2vV5awBKjgPJuP2BjIeZMzUF8zrqmM-gP76M7CRZpxkZC3215wR1rJxSbSN1i1tkKBIt4V0JoCZa37bimbjneDdi_SSFYq4b5aKCPMj33EjUmEvK7g4jfD6xXjztl0_HGPLPss0L96fPXSP9J4E4-8N_0000__y30000")

