package domain;

public class Admin {
    private Integer adminId;
    private String fname;
    private String lname;
    private String email;
    private String phoneNumber;
    private String password;

    public Admin() {}

    // Constructor with all fields.
    public Admin(Integer adminId, String fname, String lname, String email, String phoneNumber, String password) {
        this.adminId = adminId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Getters and Setters.
    public Integer getAdminId() {
        return this.adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // To String.
    @Override
    public String toString() {
        return "Admin{" +
            " adminId='" + this.adminId + "'" +
            ", fname='" + this.fname + "'" +
            ", lname='" + this.lname + "'" +
            ", email='" + this.email + "'" +
            ", phoneNumber='" + this.phoneNumber + "'" +
            ", password='" + this.password + "'" +
            "}";
    }

}//end class
