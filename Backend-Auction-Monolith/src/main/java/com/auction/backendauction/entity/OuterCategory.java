package com.auction.backendauction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "outer_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OuterCategory {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id",unique = true)
    private String id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

}