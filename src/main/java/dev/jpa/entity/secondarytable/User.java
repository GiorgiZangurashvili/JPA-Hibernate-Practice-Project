package dev.jpa.entity.secondarytable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// @SecondaryTable annotation:
// as we specified on description field
// @Column(table = "user_details"), same as,
// @SecondaryTable name, description will be
// a column of user_details service, with PK User's id.
@Entity
@Getter
@Setter
@Table(name = "users")
@SecondaryTable(
        name = "user_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(table = "user_details")
    private String description;

}
