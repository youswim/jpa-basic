package hellojpa;

import chap5page1.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    //SequenceGenerator의 allocationSize속성의 테스트를 위한 코드

    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//
//        List<Member> memberList = new ArrayList<>();
//
//        for (int i = 1; i < 53; i++) {
//            Member member = new Member();
//            member.setUsername(Integer.toString(i));
//            memberList.add(member);
//        }
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try {
//            for (Member member : memberList) {
//                em.persist(member);
//            }
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

Address address1 = new Address("city", "street", "10");
Address address2 = new Address("city", "street", "10");

System.out.println("(address1 == address2) = " + (address1 == address2));
System.out.println("address1.equals(address2) = " + address1.equals(address2));

    }
}
