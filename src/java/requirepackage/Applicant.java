/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package requirepackage;
import java.sql.Date;
/**
 *
 * @author Rahul
 */
public class Applicant {
    int id ;
    String recruiter_email,candidate_email,job_id,post_type,fullname,resume,education,phoneno,address,gender,
            linkedin,github,pwebsite,jobtitile,excompany,duration,skills,responsibility,exsalary,application_date;
    Date date;

    public Applicant() {
    }

    public Applicant(int id, String recruiter_email, String candidate_email, String job_id, String post_type, String fullname, String resume, String education, String phoneno, String address, String gender, String linkedin, String github, String pwebsite, String jobtitile, String excompany, String duration, String skills, String responsibility, String exsalary, String application_date, Date date) {
        this.id = id;
        this.recruiter_email = recruiter_email;
        this.candidate_email = candidate_email;
        this.job_id = job_id;
        this.post_type = post_type;
        this.fullname = fullname;
        this.resume = resume;
        this.education = education;
        this.phoneno = phoneno;
        this.address = address;
        this.gender = gender;
        this.linkedin = linkedin;
        this.github = github;
        this.pwebsite = pwebsite;
        this.jobtitile = jobtitile;
        this.excompany = excompany;
        this.duration = duration;
        this.skills = skills;
        this.responsibility = responsibility;
        this.exsalary = exsalary;
        this.application_date = application_date;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecruiter_email() {
        return recruiter_email;
    }

    public void setRecruiter_email(String recruiter_email) {
        this.recruiter_email = recruiter_email;
    }

    public String getCandidate_email() {
        return candidate_email;
    }

    public void setCandidate_email(String candidate_email) {
        this.candidate_email = candidate_email;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPwebsite() {
        return pwebsite;
    }

    public void setPwebsite(String pwebsite) {
        this.pwebsite = pwebsite;
    }

    public String getJobtitile() {
        return jobtitile;
    }

    public void setJobtitile(String jobtitile) {
        this.jobtitile = jobtitile;
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

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
