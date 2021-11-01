/**
 * FileName: DutyHistory
 * Author: 何锦川
 * Date: 2021/10/2 17:29
 * Description: 值班记录
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

/**
 * <功能概述>
 * <值班记录>
 *
 * @author 何锦川
 * @create 2021/10/2 17:29
 * @since 1.0.0
 */
public class DutyHistory {
    private Integer id;
    private Integer aid;
    private String clockInTime;

    public DutyHistory(Integer id, Integer aid, String clockInTime) {
        this.id = id;
        this.aid = aid;
        this.clockInTime = clockInTime;
    }

    public DutyHistory(Integer aid, String clockInTime) {
        this.aid = aid;
        this.clockInTime = clockInTime;
    }

    public DutyHistory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(String clockInTime) {
        this.clockInTime = clockInTime;
    }

    @Override
    public String toString() {
        return "DutyHistory{" +
                "id=" + id +
                ", aid=" + aid +
                ", clockInTime='" + clockInTime + '\'' +
                '}';
    }
}
