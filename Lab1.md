# Lab 1: Phân Tích Kiến Trúc, Cơ Chế, Ca Sử Dụng cho Hệ Thống Payroll System

## Mục Tiêu
Phân tích kiến trúc, cơ chế và ca sử dụng của hệ thống Payroll System nhằm xác định các yêu cầu chức năng và phi chức năng, đề xuất kiến trúc hệ thống và các cơ chế phù hợp.

---

### 1. Phân Tích Kiến Trúc

#### 1.1 Đề Xuất Kiến Trúc

Hệ thống Payroll System sẽ sử dụng kiến trúc **Layered (Lớp)** với ba lớp chính:
   - **Presentation Layer (Giao diện người dùng):** Cung cấp giao diện cho người dùng tương tác với hệ thống.
   - **Business Logic Layer (Logic kinh doanh):** Xử lý các quy tắc và quy trình liên quan đến tính toán lương và quản lý chấm công.
   - **Data Access Layer (Truy xuất dữ liệu):** Quản lý truy xuất dữ liệu từ cơ sở dữ liệu, bao gồm lưu trữ thông tin nhân viên, bảng chấm công và lịch sử thanh toán.

#### 1.2 Giải Thích Kiến Trúc

   - **Presentation Layer:** Cho phép người dùng nhập và xem thông tin liên quan đến trả lương, thời gian làm việc.
   - **Business Logic Layer:** Thực hiện các tính toán lương theo các quy tắc kinh doanh, bao gồm phụ cấp và các khoản khấu trừ.
   - **Data Access Layer:** Truy xuất và lưu trữ dữ liệu về nhân viên, lương và thời gian làm việc trong cơ sở dữ liệu.

#### 1.3 Biểu Đồ Package Mô Tả Kiến Trúc

```plaintext
+----------------------+
|      Presentation    |
+----------------------+
            |
+----------------------+
|    Business Logic    |
+----------------------+
            |
+----------------------+
|     Data Access      |
+----------------------+
