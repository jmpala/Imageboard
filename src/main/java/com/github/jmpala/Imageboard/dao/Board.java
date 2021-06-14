package com.github.jmpala.Imageboard.dao;

import com.github.jmpala.Imageboard.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "boards")
public class Board extends BaseEntity {

    @Id
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "is_nsfw")
    private boolean isNSFW;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> posts;
}