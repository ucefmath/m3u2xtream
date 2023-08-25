package ma.xpertiz.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.persistence.annotations.Index;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Audit implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8626912502074445761L;

    @Index
    @Getter
    @Setter
    @Column(name = "created_on")
    private Date createdOn;

    @Index
    @Getter
    @Setter
    @Column(name = "created_by")
    private String createdBy;

    @Index
    @Getter
    @Setter
    @Column(name = "updated_on")
    private Date updatedOn;

    @Index
    @Getter
    @Setter
    @Column(name = "updated_by")
    private String updatedBy;


}
