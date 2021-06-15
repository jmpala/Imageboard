package com.github.jmpala.Imageboard.dao;


import com.github.jmpala.Imageboard.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="category")
public class Category extends BaseEntity {

    @Id
    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="is_available")
    private boolean isAvailable;

    @Column(name="is_nsfw")
    private boolean isNSFW;

    @OneToOne(mappedBy = "category")
    private Board boards;
}
