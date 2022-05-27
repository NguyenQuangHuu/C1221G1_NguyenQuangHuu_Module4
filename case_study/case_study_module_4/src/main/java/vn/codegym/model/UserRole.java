package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name="role_id",referencedColumnName = "id")
    @JsonBackReference
    private Role roles;

    public UserRole() {
    }

    public UserRole(Users users, Role roles) {
        this.users = users;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role role) {
        this.roles = role;
    }
}
