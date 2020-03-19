package com.nongxin.terminal.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    private Integer id;

    private String serviceproject;

    private String contact;

    private String tel;

    private String address;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date appointmentdate;

    private Integer number;

    private Float servicetime;

    private Float price;

    private BigDecimal amount;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceproject() {
        return serviceproject;
    }

    public void setServiceproject(String serviceproject) {
        this.serviceproject = serviceproject == null ? null : serviceproject.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getServicetime() {
        return servicetime;
    }

    public void setServicetime(Float servicetime) {
        this.servicetime = servicetime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount.setScale(2,5);
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}