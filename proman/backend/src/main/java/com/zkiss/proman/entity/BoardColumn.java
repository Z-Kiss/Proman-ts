package com.zkiss.proman.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BoardColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COLUMN_ID", nullable = false)
    private Long id;

    private String columnName;

    private int columnOrder;

    private String color;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @OneToMany(mappedBy = "boardColumn")
    private Set<Card> cards;

}
