package dev.jpa.entity.inheritance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity

// If we use this annotation, instead of Entity,
// we are no longer able to call SELECT p from ProductInSale p,
// as it is not an entity. Both Book and ElectronicDevice
// will be seen as completely different entities and this
// class will simply be a place where Book's and ED's common
// attributes are defined.
//@MappedSuperclass

// With this strategy, Hibernate will create a single table
// for all the entities in the hierarchy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

// With this strategy, Hibernate will create as many tables
// as there are entities in the hierarchy.
// It will create queries using JOIN, because
// entities have their own respectful table
// P.S. Less performant than SINGLE_TABLE (because of necessity of JOIN),
// but better structured tables.
@Inheritance(strategy = InheritanceType.JOINED)

// Not recommended!!!
// Hibernate will create as many tables, as this entity's
// number of children. All the columns, that are in this
// entity, will also be in child entities. So, in this case,
// id and name columns will be duplicated in child tables.
// Also, this strategy doesn't allow using GeneratedValue's
// strategy - IDENTITY
// Also, when we want to retrieve all the ProductInSales,
// it will always call UNION, which is not supported in JPQL
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Getter
@Setter

// Made this class abstract, so that it can't be instantiated
public abstract class ProductInSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInSale that = (ProductInSale) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
