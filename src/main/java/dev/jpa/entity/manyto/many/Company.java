package dev.jpa.entity.manyto.many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMPANIES")
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int yearOfCreation;

    private int numberOfEmployees;

    @ManyToMany
    // This annotation makes Company entity
    // the owner of the relationship
    @JoinTable(
            name = "DEVELOPERS_COMPANIES",
            joinColumns = @JoinColumn(
                    name = "COMPANY_ID",
                    foreignKey = @ForeignKey(name = "FK_DEVELOPERS_COMPANIES_COMPANY_ID")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "DEVELOPER_ID",
                    foreignKey = @ForeignKey(name = "FK_DEVELOPERS_COMPANIES_DEVELOPER_ID")
            )
    )
    private List<Developer> developers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }
}
