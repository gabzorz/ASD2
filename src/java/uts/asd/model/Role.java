package uts.asd.model;

import java.io.Serializable;

public class Role implements Serializable {
    
    private int id;
    private String RoleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public Role(int id, String RoleName) {
        this.id = id;
        this.RoleName = RoleName;
    }
    
    
    
}