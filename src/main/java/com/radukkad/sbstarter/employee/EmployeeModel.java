package com.radukkad.sbstarter.employee;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Employee")
public class EmployeeModel implements Serializable {
    public long id;
    public String name;
    public int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
