package com.atguigu.mvc.bean;

/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
public class User {

    private Integer id;

    private String username;

    /*private String password;

    private Integer age;

    private String sex;

    private String email;*/

    public User() {
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
