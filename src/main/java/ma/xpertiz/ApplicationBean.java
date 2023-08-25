package ma.xpertiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;

public class ApplicationBean {

    @Getter
    EntityManagerFactory entityManagerFactory;
    public ApplicationBean() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public String getApplicationName() {
        return "Xpertiz";
    }
}
