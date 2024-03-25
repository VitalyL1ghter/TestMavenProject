package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class User {
    public User() {
    }

    public User(String id, LocalDateTime date, String login,
                String password, String confirmPassword,
                String firstName, String name,
                String surName, Integer age, Boolean isWorker) {
        this.id = id;
        this.date = date;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.isWorker = isWorker;
    }

    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String name;
    private String surName;
    private Integer age;
    private Boolean isWorker;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getWorker() {
        return isWorker;
    }

    public void setWorker(Boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getDate(),
                user.getDate()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(),
                user.getPassword()) && Objects.equals(getConfirmPassword(),
                user.getConfirmPassword()) && Objects.equals(getFirstName(),
                user.getFirstName()) && Objects.equals(getName(),
                user.getName()) && Objects.equals(getSurName(),
                user.getSurName()) && Objects.equals(getAge(),
                user.getAge()) && Objects.equals(isWorker, user.isWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getLogin(), getPassword(),
                getConfirmPassword(), getFirstName(), getName(), getSurName(), getAge(), isWorker);
    }

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add("" + id)
                .add("" + date)
                .add("" + login + "")
                .add("" + password + "")
                .add("" + confirmPassword + "")
                .add("" + firstName + "")
                .add("" + name + "")
                .add("" + surName + "")
                .add("" + age)
                .add("" + isWorker)
                .toString();
    }
}
