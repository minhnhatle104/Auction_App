package com.auction.backendauction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "outer_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OuterCategory {

    @Id
    @GenericGenerator(name = "id", strategy = "com.auction.backendauction.utils.OuterCategoryGenerator")
    @GeneratedValue(generator = "id")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "outerCategory",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<InnerCategory> innerCategories;

}
