package jpql;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
Member member1 = new Member();
member1.setUsername("member1");
member1.setAge(10);
em.persist(member1);
int i = em.createQuery("update Member m set m.age = 20")
        .executeUpdate();
Member member = em.find(Member.class, member1.getId());
System.out.println("member.getAge() = " + member.getAge());
em.clear();
Member findMember = em.find(Member.class, member1.getId());
System.out.println("findMember.getAge() = " + findMember.getAge());
tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }


}