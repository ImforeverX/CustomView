package com.example.lining.dbutisl;

/**
 * Created by 李宁 on 2017/3/29.
 * 实体模型 使用DbUtils来映射表
 */


//@Table(name = "Person")//该类对应的表是Student

public class Pers {
    //    @Id(column = "_id")//主键一定要标识
    public int _id;
    public String name;
    public int age;
    public String sex;

    public Pers() {
    }

    public Pers(int _id, String name, int age, String sex) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "_id=" + _id +
                ", name=" + name +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
