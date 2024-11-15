# Lab 1: Phân Tích Kiến Trúc, Cơ Chế, Ca Sử Dụng cho Hệ Thống Payroll System

### 1. Phân Tích Kiến Trúc

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
