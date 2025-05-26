
package requirepackage;
import java.sql.*;


public class Registration {
    String email,fullnm,gender,address,status,password ,type;

   
    int phoneno;
    Date date;

    public Registration() {
    }

    public Registration(String email,String password, String fullnm,int phoneno, Date date, String gender, String address, String status ,String type) {
        this.email = email;
        this.fullnm = fullnm;
        this.gender = gender;
        this.address = address;
        this.status = status;
        this.phoneno = phoneno;
        this.date = date;
        this.password=password;
        this.type=type;
    }
     public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullnm() {
        return fullnm;
    }

    public void setFullnm(String fullnm) {
        this.fullnm = fullnm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
