package chap5page1;


import javax.persistence.*;

@Entity
public class MemberProduct {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
