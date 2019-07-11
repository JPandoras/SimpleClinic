package app.springboot.simpleclinic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserLogin userLogin;

    @Column(name = "name")
    private String name;

    @Column(name = "availability")
    private String availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

}


