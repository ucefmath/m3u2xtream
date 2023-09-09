package ma.xpertiz.jpa.model;

import io.buji.pac4j.subject.Pac4jPrincipal;
import lombok.extern.slf4j.Slf4j;
import ma.xpertiz.StaticClass;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Slf4j
public class AuditListener {

    @PrePersist
    public void setCreatedOn(Object auditable) {

        log.trace("prepersist " + auditable.toString());

        Audit audit = ((Auditable) auditable).getAudit();

        if (audit == null) {
            audit = new Audit();
            ((Auditable) auditable).setAudit(audit);
        }

        audit.setCreatedOn(new Date());
        audit.setCreatedBy(StaticClass.getLoggedUserName());


    }


        @PreUpdate
    public void setUpdatedOn(Object auditable) {

        log.trace("preupdate " + auditable.toString());

        Audit audit = ((Auditable) auditable).getAudit();
        if (audit != null) {
            audit.setUpdatedOn(new Date());
            audit.setUpdatedBy(StaticClass.getLoggedUserName());
        }
    }
}