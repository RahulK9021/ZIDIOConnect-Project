
package requirepackage;
import java.sql.Date;

public class Internship {
    String recemail,comnm,jr,skill,loc,salary,exp,dec,post_type;
    Date deadline;
    public Internship() {
    }

    public Internship(String recemail,  String comnm, String jr, String skill, String loc,Date deadline, String salary, String exp, String dec , String post_type ) {
        this.recemail = recemail;
        this.comnm = comnm;
        this.jr = jr;
        this.skill = skill;
        this.loc = loc;
        this.deadline=deadline;
        this.salary = salary;
        this.exp = exp;
        this.dec = dec;
        this.post_type=post_type;
    }
    
  

public String getPostType() {
    return post_type;
}
public void setPostType(String post_type) {
    this.post_type = post_type;
}

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getRecemail() {
        return recemail;
    }

    public void setRecemail(String recemail) {
        this.recemail = recemail;
    }

    public String getComnm() {
        return comnm;
    }

    public void setComnm(String comnm) {
        this.comnm = comnm;
    }

    public String getJr() {
        return jr;
    }

    public void setJr(String jr) {
        this.jr = jr;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
    
    
}
