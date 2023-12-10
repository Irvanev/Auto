package com.example.auto.models.entities;

import com.example.auto.models.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "created", column = @Column(insertable = false, updatable = false)),
        @AttributeOverride(name = "modified", column = @Column(insertable = false, updatable = false))
})

public class Roles extends BaseEntity {
    private List<Users> users;
    private RoleEnum roleName;

    public Roles() {
    }

    public Roles(RoleEnum roleName) {
        this.roleName = roleName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    public RoleEnum getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return String.valueOf(roleName);
    }
}
