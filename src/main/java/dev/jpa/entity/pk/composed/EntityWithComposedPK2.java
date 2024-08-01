package dev.jpa.entity.pk.composed;

import dev.jpa.key.ComposedKey2;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TABLE_WITH_COMPOSED_PK_EMBEDDABLE")
@Getter
@Setter
public class EntityWithComposedPK2 {

    @EmbeddedId
    private ComposedKey2 composedKey2;

    private Long age;

    @Override
    public String toString() {
        return "EntityWithComposedPK2{" +
                "composedKey2=" + composedKey2 +
                ", age=" + age +
                '}';
    }
}
