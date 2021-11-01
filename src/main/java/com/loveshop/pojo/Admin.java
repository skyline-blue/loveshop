/**
 * FileName: Admin
 * Author: 何锦川
 * Date: 2021/9/14 23:12
 * Description: 管理员表
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

/**
 * <功能概述>
 * <管理员表>
 *
 * @author 何锦川
 * @create 2021/9/14 23:12
 * @since 1.0.0
 */
public class Admin {
    private Integer aid;
    private String aname;
    private String password;
    private String studentId;
    private String phone;
    private String school;
    private String qq;
    private String level;
    private String dept;
    private Double points;

    public Admin(Integer aid, String aname, String password, String studentId, String phone, String school, String qq, String level, String dept, Double points) {
        this.aid = aid;
        this.aname = aname;
        this.password = password;
        this.studentId = studentId;
        this.phone = phone;
        this.school = school;
        this.qq = qq;
        this.level = level;
        this.dept = dept;
        this.points = points;
    }

    public Admin(Integer aid, String aname, String phone, String school, String qq) {
        this.aid = aid;
        this.aname = aname;
        this.phone = phone;
        this.school = school;
        this.qq = qq;
    }

    public Admin(String aname, String studentId, String phone, String school, String qq, String dept, Double points) {
        this.aname = aname;
        this.studentId = studentId;
        this.phone = phone;
        this.school = school;
        this.qq = qq;
        this.dept = dept;
        this.points = points;
    }

    public Admin() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public String
    toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", password='" + password + '\'' +
                ", studentId='" + studentId + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", qq='" + qq + '\'' +
                ", level='" + level + '\'' +
                ", dept='" + dept + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
