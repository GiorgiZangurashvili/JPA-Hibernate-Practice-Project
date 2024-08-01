package dev.jpa.entity.oneto.one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    // on the opposite side of the owner of the relationship
    // we should always specify mappedBy attribute, which should be
    // name of the corresponding field in relationship owner entity
    // (IF THE RELATIONSHIP IS BI-DIRECTIONAL)
    @OneToOne(mappedBy = "passport")
    private Person person;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
