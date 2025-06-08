
package requirepackage;
import java.sql.Date;


public class Registration {
    String email,fullnm,gender,password;
    String  phoneno;
    Date date;
    public Registration() {
        
    }

    public Registration(String email,String password, String fullnm,String  phoneno,  String gender ,Date date) {
        this.email = email;
        this.fullnm = fullnm;
        this.phoneno = phoneno;
        this.password=password;
        this.gender=gender;
        this.date=date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String  getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String  phoneno) {
        this.phoneno = phoneno;
    }
    
}