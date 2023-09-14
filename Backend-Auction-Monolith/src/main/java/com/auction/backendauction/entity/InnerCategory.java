package com.auction.backendauction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "inner_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InnerCategory {

    @Id
    @GenericGenerator(name = "id", strategy = "com.auction.backendauction.utils.InnerCategoryGenerator")
    @GeneratedValue(generator = "id")
    @Column(name = "id")
    private String id;

    @Column(name = "name",unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "outer_category_id")
    private OuterCategory outerCategory;

}
