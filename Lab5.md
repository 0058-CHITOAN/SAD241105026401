# 📑 **Hệ Thống Con của Payroll System**

---

##  **1. Payroll Processing Subsystem**

> **Chức năng chính**  
> - Tính toán tiền lương và xử lý các khoản khấu trừ (thuế, bảo hiểm, ...).  
> - Phát hành phiếu lương (paychecks).  

> **Thành phần chính**  
> - `PayrollController`: Điều khiển quy trình bảng lương.  
> - `Employee`: Chứa thông tin nhân viên.  
> - `Paycheck`: Đại diện cho bảng lương.  
> - `Timecard`: Ghi nhận giờ làm việc.  

**🔗 Mối quan hệ**: Tương tác với **Bank System** và **Print Service** để phát hành thanh toán và in phiếu lương.

| **Thành phần**       | **Chức năng**                          |
|-----------------------|----------------------------------------|
| `PayrollController`   | Điều khiển quá trình xử lý lương       |
| `Employee`            | Chứa thông tin nhân viên              |
| `Paycheck`            | Đại diện cho bảng lương của nhân viên |
| `Timecard`            | Ghi lại thời gian làm việc            |

![UML: Payroll Processing](https://www.planttext.com/api/plantuml/png/T94zRiCm38LtdKAZC-W27ee0RO5sCv00dGcPTOn8Oa19Wr7qP1rwf5wX-h7Y54KcWT_JUoIbdw_llG_08LeZ1rYOZ1cOD7e_kqbe0zut_aWkv1DPVWWf9KUtAjqkrngCZWO29bh9X0wv0dr2VKxqKsoXXPKi1PQY2xryDmIXX34cO_U7txYVxSNGWbZTk5QlOozdb_tAWSLU7WBdDLBjmG0lDmqc38V2kbsZr_JZR543ZpNzH97z6_4PnyslBh0Co3CbzfGcNIDVjhjRRfM6PiX2iQH-_vzMgOVhTdVazdHtv3QzsACRqx-ANm000F__0m00)

---

##  **2. Employee Management Subsystem**

> **Chức năng chính**  
> - Quản lý thông tin nhân viên (lương, thông tin cá nhân).  
> - Cập nhật và bảo trì dữ liệu nhân viên.  

> **Thành phần chính**  
> - `EmployeeController`: Điều khiển các thao tác nhân viên.  
> - `Employee Entity`: Lưu trữ dữ liệu nhân viên.  
> - `SecurityManager`: Kiểm soát quyền truy cập dữ liệu.  

**🔗 Mối quan hệ**: Tương tác với **Database Subsystem** để lưu và truy cập dữ liệu.

| **Thành phần**         | **Chức năng**                        |
|-------------------------|--------------------------------------|
| `EmployeeController`    | Điều khiển thao tác quản lý nhân viên |
| `Employee Entity`       | Lưu trữ dữ liệu nhân viên           |
| `SecurityManager`       | Quản lý quyền truy cập              |

![UML: Employee Management](https://www.planttext.com/api/plantuml/png/T9513e9034NtSufPme8Bi32eSU52DvoWGYN4qZ4pnOGOJ-R28ta5gGeQeil-zhzs_joljom8U6aRiglcIAv3t013XGsoc88WXB6nT2pU4Q6tPsEjhL26rfhtBiAXA5DRiyJfwDJfzbY2u4_3Pp0s5pFP-joLJDWgCJIzCnTVSwNr3lYWs6yj087lKhid1pAzkOpY0QRwjkUfChfLp9y0bL-8yRmSYzRNqhtIUYTo0ghrbVEYm12YDg0VU3rXuHmXi39-H9eaiqzUV_gJfIP3BlklCmy0003__mC0)

---

##  **3. Timecard Management Subsystem**

> **Chức năng chính**  
> - Ghi nhận và quản lý giờ làm việc nhân viên.  

> **Thành phần chính**  
> - `TimecardController`: Quản lý thẻ chấm công.  
> - `Timecard`: Đại diện cho giờ làm việc.  
> - `ProjectManagementDatabase`: Lấy dữ liệu dự án phục vụ tính lương.

**🔗 Mối quan hệ**: Tương tác với **Payroll Processing Subsystem**.

![UML: Timecard Management](https://www.planttext.com/api/plantuml/png/T57DQiCm3BxxANnCe7c174QXFMo7GQ23dTLOox8vLf2LGnbziXtsI7s5sbrgZsQz2A7lHtpIwVjdxGLOfi7gbtx05jWyWuCE1tIYMWlU9s13JfYiHTPVIclTeLoX0eVHqW7noTIwTxBI1WHhlGsrh9D3L4rZX99GvYQJoiXg6V-o5lRlDB5_9Vx4C7cp164smg51xiaiznxLJPPBWchf4gStFdFKnymjoioEK7CLHE0YIViQfWzi9TyqmB07Z-c4CsD31elnjvzJ1hETSE-wQFVF4whg8IUyWz_ThzReJ7YxEWC00F__0m00)

---

##  **4. Bank System Subsystem**

> **Chức năng chính**  
> - Xử lý thanh toán qua ngân hàng (chuyển khoản, séc,...).  

> **Thành phần chính**  
> - `BankController`: Giao tiếp với ngân hàng.  
> - `IBankSystem`: Giao diện chuẩn tích hợp hệ thống ngân hàng.

![UML: Bank System](https://www.planttext.com/api/plantuml/png/T91D3e9038NtSuekCO4Bi32eSU6EX1FKeIXX_Z9J5XFZoLnu9AyWCfWG4tSlxUlNrxuUpoemUXwrWZsQeOc1IGkfC8IvSB26lLMAFDm403Xl9OLGOzHaE2Fjb8r49HmNbOF3AAyaXnBgHMt4NQoOQKdYjUHiw3b3RKV39NJA8kTmdcmxALEjOT-Rompf3PFlK1AS_f5ctq_qejYkprkDVZhVcA8YqqwV46y0003__mC0)

---

##  **5. Print Service Subsystem**

> **Chức năng chính**  
> - In và tạo các phiếu lương.  

> **Thành phần chính**  
> - `PrintService`: Cung cấp chức năng in.  
> - `PaycheckPrinter`: In phiếu lương theo mẫu.  

![UML: Print Service](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbkZa90KMPUIN1gKLbcSYfNSavYSJ6Aa48rbuA2GW58922nCZaZDJbRem3Ai5A02MborNB1D4E5m8Qa5a7qfwVcfHObbgJ295rIIn8pSufncOJY05rTExWiRXceTLmEgNafG6zn0G000F__0m00)

---

##  **6. Database Subsystem**

> **Chức năng chính**  
> - Lưu trữ thông tin nhân viên, phiếu lương và thẻ chấm công.  

> **Thành phần chính**  
> - `PayrollDBManager`: Quản lý dữ liệu hệ thống.  
> - `ObjectStore Support`: Lưu trữ dữ liệu dưới dạng đối tượng.

![UML: Database](https://www.planttext.com/api/plantuml/png/R55B2i8m4Dtd5BEqYruW2n7HfIZK2qpJeNxIZybKAEB9N7Wahs3Q9XLfDu7toSnxoUVrNbb6mqsXOOECALfAcjIsbgaGIgEr8myF0G0MxzGnYymT4lRfXHH7dP8JzyAj8TDAIDYSopmA5l4KVju1MrDflLdliCISp6_kjgXrrT8mdpoG4EWe-8xdWXIQhFUn1n82FVhS9dKYTUrzjGSI0XtzCWqP4wwCgr_NbM6VgcDcwhgBuxF4yNBIIKnATgvGP5uDyUVL4Ff_xpItM56PkUyKNm000F__0m00)

