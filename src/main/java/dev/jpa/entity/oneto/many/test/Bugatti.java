package dev.jpa.entity.oneto.many.test;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "BUGATTIES")
@Getter
@Setter
public class Bugatti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    private long milesCovered;

    private int price;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Tate tate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bugatti bugatti = (Bugatti) o;
        return Objects.equals(id, bugatti.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Bugatti{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", milesCovered=" + milesCovered +
                ", price=" + price +
                '}';
    }
}
