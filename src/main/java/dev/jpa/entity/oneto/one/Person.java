package dev.jpa.entity.oneto.one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // basically if Person is persisted,
    // then Passport should be persisted as well
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passport_id", foreignKey = @ForeignKey(name = "PERSON_PASSPORT_ID_FK"))
    private Passport passport;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }

}
