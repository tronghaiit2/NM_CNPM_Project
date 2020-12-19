
# 💻 Phần mềm quản lý nhân khẩu và tình trạng dịch covid trong tổ dân phố

⚠️ Một số phần mềm, tool cần thiết để sử dụng trong project: <br>
<b>- IDE:</b>
<br>+<a href="https://www.jetbrains.com/idea/download/#section=windows"> Intellij IDEA 👍</a> (có thể dùng bản community)
<br>+<a href="https://netbeans.org/downloads/8.2/rc/"> NetBeans </a>
<br><b>-<a href="https://dev.mysql.com/downloads/windows/installer/8.0.html"> MySQL Workbench </a> </b>
<br><b>-<a href ="https://git-scm.com/downloads"> Git </a> </b>

# 🛠️ Cách cài đặt: 
1️⃣ Clone repository về bằng cách click vào nút code màu xanh, chọn dowload zip, tải về rồi giải nén
![image](https://user-images.githubusercontent.com/53103225/102680871-0877f300-41ef-11eb-87cf-909455ae11ee.png)

<br> hoặc mở một folder bất kỳ trong máy, click chuột phải và chọn<b> Git bash here</b>, sau đó gõ dòng lệnh trong dấu nháy kép sau đây vào màn hình console:
<br> 👉 "git clone https://github.com/tronghaiit2/NM_CNPM_Project.git"
![image](https://user-images.githubusercontent.com/53103225/102680838-bfc03a00-41ee-11eb-865c-a27fc5451114.png)
<br> Khi nào màn hình console nhìn như này là xong:
![image](https://user-images.githubusercontent.com/53103225/102681022-7244cc80-41f0-11eb-930d-871743750c89.png)
<br> ⚠️ Để mở màn hình console của git như trên thì trước tiên máy của bạn phải có <a href ="https://git-scm.com/downloads"> Git </a> <br>

2️⃣ Mở project:
<br> - Nếu dùng Netbean: File -> Open Project -> Mở project vừa clone về, mở ra và chọn cốc cà phê -> Open Project
![image](https://user-images.githubusercontent.com/53103225/102681102-568df600-41f1-11eb-807b-a117b48305f3.png)
<br> - Nếu dùng Intellij IDEA: File -> Open ->  Mở project vừa clone về, chọn folder NM_CNPM_Project
![image](https://user-images.githubusercontent.com/53103225/102681154-b97f8d00-41f1-11eb-9467-6644ca6b19eb.png) <br>
3️⃣ Vào QuanLyNhanKhau/src/services/MysqlConnection sửa username và password thành username và password mysql của mình

![image](https://user-images.githubusercontent.com/53103225/102682909-95c34380-41ff-11eb-9d02-b9f58c81fe4b.png) <br>

4️⃣ Mở MySQL Workbench, chọn File -> Open SQL Script -> Mở folder chứa project lên và chọn file quan_ly_nhan_khau.sql -> Open
![image](https://user-images.githubusercontent.com/53103225/102683731-b7272e00-4205-11eb-9192-277836cc98ae.png)

-> Sau khi mở ấn vào nút <b>⚡ Execute</b> để tạo csdl cho phần mềm <br>
5️⃣ Project đã hỗ trợ mysql connector phiên bản 8.0.21 và 8.0.22.
<br> Nếu dùng phiên bản khác có thể tự thêm drive mysql connector phù hợp với phiên bản mysql trong máy (như vd trong hình là 8.0.21)
<br> (Xem phiên bản bằng cách chọn Help -> About Workbench)
<br> Gợi ý dùng IDE Intellij IDEA hỗ trợ việc thêm thư viện bằng maven rất tiện lợi, chi tiết tham khảo trong link sau: 
<br> 👉 https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support
<br> Code xml cho từng phiên bản để add dependency vào file pom.xml nếu dùng maven:
<br> 👉 https://mvnrepository.com/artifact/mysql/mysql-connector-java

![image](https://user-images.githubusercontent.com/53103225/102679789-ea0cfa00-41e4-11eb-8f06-1a4c01cc1b2c.png) <br>

6️⃣ Run project bằng IDE, đăng nhập bằng Username là Admin, Password là 1 (có thể xem trong csdl bảng user)
