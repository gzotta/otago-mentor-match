package @domain;

public class Admin {
    private int admin_id;
    private String fname;
    private String lname;
    private String email;
    private String phone_number;
    private String password;

    //

    public Admin(int admin_id, String fname, String lname, String email, String phone_number, String password) {
        this.admin_id = admin_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

//getters and settes
    public int getAdmin_id() {
        return this.admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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


}
