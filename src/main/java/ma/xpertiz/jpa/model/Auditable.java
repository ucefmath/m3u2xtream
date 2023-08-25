package ma.xpertiz.jpa.model;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);

}