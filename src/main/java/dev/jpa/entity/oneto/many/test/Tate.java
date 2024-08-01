package dev.jpa.entity.oneto.many.test;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TATE_BROS")
@Getter
@Setter
public class Tate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int fameLevel;

    private long netWorth;

    private int humanTrafficCount;

    @OneToMany(mappedBy = "tate")
    private List<Bugatti> bugattiList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tate tate = (Tate) o;
        return Objects.equals(id, tate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Tate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fameLevel=" + fameLevel +
                ", netWorth=" + netWorth +
                ", humanTrafficCount=" + humanTrafficCount +
                '}';
    }
}
