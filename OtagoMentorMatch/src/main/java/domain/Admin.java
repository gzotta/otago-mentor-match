package @domain;

public class Admin {
    private int adminId;
    private String fname;
    private String lname;
    private String email;
    private String phone_number;
    private String password;

    // Empty constructor.
    public Admin() {
    }


    // Constructor with all fields.
    public Admin(int adminId, String fname, String lname, String email, String phone_number, String password) {
        this.adminId = adminId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }


    // Getters and Setters.
    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
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

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
        return "{" +
            " adminId='" + getAdminId() + "'" +
            ", fname='" + getFname() + "'" +
            ", lname='" + getLname() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone_number='" + getPhone_number() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }


}
