/**
 * FileName: DutyAssignment
 * Author: 何锦川
 * Date: 2021/10/2 17:16
 * Description: 排班表
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

/**
 * <功能概述>
 * <排班表>
 *
 * @author 何锦川
 * @create 2021/10/2 17:16
 * @since 1.0.0
 */
public class DutyAssignment {

    private Integer id;
    private String time;
    private Integer aid;
    private String detail;

    public DutyAssignment(Integer id, String time, Integer aid, String detail) {
        this.id = id;
        this.time = time;
        this.aid = aid;
        this.detail = detail;
    }

    public DutyAssignment(String time, Integer aid, String detail) {
        this.time = time;
        this.aid = aid;
        this.detail = detail;
    }

    public DutyAssignment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "DutyAssignment{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", aid=" + aid +
                ", detail='" + detail + '\'' +
                '}';
    }
}
