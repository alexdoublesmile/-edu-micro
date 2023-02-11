package edu.joyful.micro.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
