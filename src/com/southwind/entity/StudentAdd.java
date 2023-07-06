package com.southwind.entity;

public class StudentAdd {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private String state;
    private String create_date;

    public StudentAdd(String number,String name,String gender,String state,String create_date) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.state = state;
        this.create_date = create_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateDate() {
        return create_date;
    }

    public void setCreateDate(String create_date) {
        this.create_date = create_date;
    }
}
