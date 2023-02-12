package edu.joyful.noteservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Long personId;
}
