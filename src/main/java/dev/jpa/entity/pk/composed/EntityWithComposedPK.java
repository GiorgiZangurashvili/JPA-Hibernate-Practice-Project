package dev.jpa.entity.pk.composed;

import dev.jpa.key.ComposedKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(ComposedKey.class)
@Table(name = "TABLE_WITH_COMPOSED_PK")
@Getter
@Setter
public class EntityWithComposedPK {

    @Id
    private Long code;

    @Id
    private String slug;

    private String name;

    private String surname;

    @Override
    public String toString() {
        return "EntityWithComposedPK{" +
                "code=" + code +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
