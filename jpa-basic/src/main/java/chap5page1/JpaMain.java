package chap5page1;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


            Member member = new Member();
            Address homeAddress = new Address("city", "street", "10");
            member.setName("member1");
            member.setHomeAddress(homeAddress);

            AddressHistory old1 = new AddressHistory("old1", "street", "10");
            AddressHistory old2 = new AddressHistory("old2", "street", "10");

            List<AddressHistory> addressHistory = member.getAddressHistory();
            addressHistory.add(old1);
            addressHistory.add(old2);
            em.persist(member);

//            em.flush();
//            em.clear();
//
//            System.out.println("=============================");
//            Member findMember = em.find(Member.class, member.getId());
//
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            findMember.getFavoriteFoods().remove("치킨"); // remove(Object o)
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10"));
//            // remove(Object o). equals, hashCode 메서드가 제대로 만들어져있지 않으면 제대로 동작 X
//            findMember.getAddressHistory().add(new Address("newCity", "street", "10000"));

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
