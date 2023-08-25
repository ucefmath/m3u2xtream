package ma.xpertiz.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Cacheable(false)
@CascadeOnDelete
@Entity
@Table(name = "users")
@NoArgsConstructor
@EntityListeners(AuditListener.class)
@JsonIgnoreProperties({ "adminUser" })
public class UserAccount implements Auditable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3537337730820764537L;

    @JsonIgnore
    @Getter
    @Setter
    @Embedded
    public Audit audit;
    @Getter
    @Setter
    @EmbeddedId
    private UserAccountId id;

//    @JsonManagedReference
//    @Getter
//    @Setter
//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = false)
//    private List<Balance> balances = new ArrayList<>();

    @Setter
    @Getter
    @Transient
    private transient String oldpassword;

    @Setter
    @Getter
    @Transient
    private transient String newpassword;

    @Getter
    @Column(columnDefinition = "varchar(255)")
    private String password;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(1000)")
    private String serializedprofile;
    @Getter
    @Setter
    @Column(name = "phone_number")
    private String phoneNumber;
    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @Column(name = "fullname")
    private String fullname;

    @Getter
    @Setter
    private Date lastlogin;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private AllRoles role = null;

    @Getter
    @Setter
    @Column(name = "reset_password")
    private Boolean resetPassword;
    //    @JsonManagedReference

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword.trim();
    }

    @Setter
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "admin_id", nullable = true, referencedColumnName = "id"),
            @JoinColumn(name = "admin_name", nullable = true, referencedColumnName = "username"),
            @JoinColumn(name = "admin_linkedid", nullable = true, referencedColumnName = "linkedid")})
    private UserAccount adminUser;

    public UserAccount getAdminUser() {
        if (adminUser!=null)        return adminUser;
        else return this;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }



    public AllRoles getRole() {
        return role;
    }

    public void setRole(AllRoles role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return getId().getUsername() + " (" + getId().getId() + ")";
    }

}