package learn.springcloud.configclient.model;

import javax.persistence.*;

@Entity
@Table(name = "userDetails")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=50)
public class User {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;

    public User(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User(String userName, String password, boolean active, String roles,int id) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.id=id;
    }
    public User(String userName, String password, boolean active, String roles) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles; 
    }
}
