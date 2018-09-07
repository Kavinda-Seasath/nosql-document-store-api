package com;

public class data {

    private String name;
    private int age;
    private String email;
    private int status;
    private String dateof;
    private String _id;

    public String getDateof() {
        return dateof;
    }

    public void setDateof(String dateof) {
        this.dateof = dateof;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
