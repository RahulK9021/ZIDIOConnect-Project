
package requirepackage;

public class UserLogin {
  String uid,pwd;

    public UserLogin() {
        
    }

    public UserLogin(String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
}
