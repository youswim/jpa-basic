package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            // 내가 join 에 사용하는 행의 이름
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
            // 다른 join 테이블이 사용하는 행의 이름
    )
    private List<Item> items = new ArrayList<>();

}
