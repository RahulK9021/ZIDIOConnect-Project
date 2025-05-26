package requirepackage;
import java.sql.*;

public class ViewProfile {
    String fnm,file,email,education,address,type,status,linkedin,github,personalwebsite,jobtitle,excompany,duration,skills,responsibility,exsalary,phone;
    Date dob;

    public String getFnm() {
        return fnm;
    }

    public void setFnm(String fnm) {
        this.fnm = fnm;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getEmail() {
        return email;
    } 

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getPersonalwebsite() {
        return personalwebsite;
    }

    public void setPersonalwebsite(String personalwebsite) {
        this.personalwebsite = personalwebsite;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getExcompany() {
        return excompany;
    }

    public void setExcompany(String excompany) {
        this.excompany = excompany;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getExsalary() {
        return exsalary;
    }

    public void setExsalary(String exsalary) {
        this.exsalary = exsalary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public ViewProfile(String fnm, String file, String email, String education, String phone, Date dob, String address, String type, String status, String linkedin, String github, String personalwebsite, String jobtitle, String excompany, String duration, String skills, String responsibility, String exsalary) {
        this.fnm = fnm;
        this.file = file;
        this.email = email;
        this.education = education;
        this.address = address;
        this.type = type;
        this.status = status;
        this.linkedin = linkedin;
        this.github = github;
        this.personalwebsite = personalwebsite;
        this.jobtitle = jobtitle;
        this.excompany = excompany;
        this.duration = duration;
        this.skills = skills;
        this.responsibility = responsibility;
        this.exsalary = exsalary;
        this.phone = phone;
        this.dob = dob;
    }

    public ViewProfile() {
    }
}
