package org.example.javafxdb_sql_shellcode;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    private String major;
    private String profilePath;

    /**
     * person class
     */
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

    /**
     * set profile pic path method
     * @param profilePicturePath
     */
    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePath = profilePicturePath;
    }

    public String getProfilePicturePath() {
        return profilePath;
    }

    /**
     * id setter method
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get id method
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * set first name method
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set last name setter
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get last name getter
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set dept setter
     * @param dept
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * get dept method
     * @return
     */
    public String getDept() {
        return dept;
    }

    /**
     * set major method
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * get major method
     * @return
     */
    public String getMajor() {
        return major;
    }

}
