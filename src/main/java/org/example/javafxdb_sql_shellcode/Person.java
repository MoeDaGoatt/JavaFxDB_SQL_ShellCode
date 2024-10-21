package org.example.javafxdb_sql_shellcode;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    private String major;
    private String profilePath;

    public Person() {
    }

    public Person(Integer id, String f_name, String l_name, String dept, String major, String profilePath) {
        this.id = id;
        this.firstName = f_name;
        this.lastName = l_name;
        this.major = major;
        this.dept = dept;
        this.profilePath = profilePath;
    }
    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePath = profilePicturePath;
    }

    public String getProfilePicturePath() {
        return profilePath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

}
