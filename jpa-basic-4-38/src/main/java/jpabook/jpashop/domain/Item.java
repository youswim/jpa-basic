package jpabook.jpashop.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 상속을 위한 어노테이션
// 상속은 단일 테이블 전략
@DiscriminatorColumn
// 기본값인 DTYPE 사용
public abstract class Item extends BaseEntity {
    // Item 테이블을 단독으로 만드는 경우가 없다고 가정 => abstract

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID") //column 이름은 각 회사의 룰을 따르면 된다
    private Long id;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    private String name;
    private int price;
    private int StockQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }
}
