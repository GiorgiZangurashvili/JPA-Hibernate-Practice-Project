package dev.jpa.entity.oneto.many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // unidirectional - Post is the owner of relationship
//    @OneToMany
//    @JoinColumn(name = "post_id")
//    private List<Comment> comments;

    // bidirectional - Comment is the owner of relationship
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Comment> comments; // can only be Collection, List, Set

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
