package ma.xpertiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;
import ma.xpertiz.jpa.model.UserAccount;

public class ApplicationBean {

    @Getter
    EntityManagerFactory entityManagerFactory;
    public ApplicationBean() {

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManagerFactory.createEntityManager().createNativeQuery("select 1").getSingleResult();
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public String getApplicationName() {
        return "Xpertiz";
    }

}
