package dev.jpa.entity.oneto.many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // Comment is the owner of relationship
    @ManyToOne(cascade = CascadeType.REMOVE)
    // specify the name of foreign key column
    @JoinColumn(name = "post")
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", post=" + post +
                '}';
    }
}
