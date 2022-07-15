package chap5page1;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

Address address = new Address("city", "street", "10");
Member member = new Member();
member.setHomeAddress(address);
em.persist(member);

Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
member.setHomeAddress(newAddress);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member.getName() = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        System.out.println("member.getName() = " + member.getName());
        System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
    }
}
