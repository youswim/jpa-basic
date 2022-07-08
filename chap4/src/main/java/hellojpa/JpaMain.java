package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        Member member1 = new Member();
        member1.setUsername("1");

        Member member2 = new Member();
        member2.setUsername("2");

        Member member3 = new Member();
        member3.setUsername("3");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            System.out.println("=================");
            em.persist(member1);
            em.persist(member2);
//            em.persist(member3);
            System.out.println("member1.id = " + member1.getId());
            System.out.println("member2.id = " + member2.getId());
            System.out.println("member3.id = " + member3.getId());
            System.out.println("=================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
