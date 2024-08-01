package dev.jpa.entity.manyto.many.test;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "HUMANS")
@Getter
@Setter
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @ManyToMany
    @JoinTable(
            name = "HUMANS_HOBBIES",
            joinColumns = @JoinColumn(
                    name = "HUMAN_ID",
                    foreignKey = @ForeignKey(name = "FK_HUMANS_HOBBIES_HUMAN_ID")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "HOBBY_ID",
                    foreignKey = @ForeignKey(name = "FK_HUMANS_HOBBIES_HOBBY_ID")
            )
    )
    private List<Hobby> hobbies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
