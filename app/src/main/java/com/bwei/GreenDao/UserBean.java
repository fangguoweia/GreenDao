package com.bwei.GreenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created  on 2018/9/3.
 */
@Entity
public class UserBean {
    //添加 主键 注解
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private Long uid;
    //属性注解
    @Property(nameInDb = "username")
    private String name;
    private int age;


    @Generated(hash = 767347952)
    public UserBean(Long id, Long uid, String name, int age) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
