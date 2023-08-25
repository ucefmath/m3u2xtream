package ma.xpertiz.jpa.model;

import lombok.*;
import org.eclipse.persistence.annotations.Index;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserAccountId implements Serializable {

    private static final long serialVersionUID = -4476771485833374372L;

    @Index
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public void setUsername(String username) {
        this.username = username.trim();
    }

    @Index
    @Basic(optional = false)
    @Column(nullable = false, updatable = false,unique = true)
    private String username;

    @Index
    @Basic(optional = false)
    @Column(nullable = false)
    private String linkedid;


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return (((UserAccountId) o).getId().equals(this.getId()) && ((UserAccountId) o).getUsername().equals(this.getUsername()) && ((UserAccountId) o).getLinkedid().equals(this.getLinkedid()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getLinkedid().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getUsername() + ":" + getId() + ":" + getLinkedid();
    }
}