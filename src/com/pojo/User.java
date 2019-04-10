package com.pojo;


public class User {

    //声明用户id
    private int id;
    //声明用户名
    private String uname;
    //声明用户密码
    private String pwd;
    //声明用户性别
    private String sex;
    //声明用户年龄
    private int age;
    //声明用户出生日期
    private String birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (sex != user.sex) return false;
        if (age != user.age) return false;
        if (uname != null ? !uname.equals(user.uname) : user.uname != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;
        return birth != null ? birth.equals(user.birth) : user.birth == null;
    }



    @Override
    public String toString() {
        return "User{" +

                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }

    public User(int id, String uname, String pwd, String sex, int age, String birth) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }

    public User() {

    }
}
