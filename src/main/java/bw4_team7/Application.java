package bw4_team7;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4-team7");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("ciao");
    }
}
