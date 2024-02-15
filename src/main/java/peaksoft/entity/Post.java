package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "posts_seq" ,allocationSize = 1)
public class Post extends BaseEntity {
    private String tittle;
    private String description;
    private LocalDate cratedAt;
    @OneToMany (mappedBy = "post")
    private List<Image> imageList;
    @OneToMany (mappedBy = "post")
    private List<Like> likes;
    @OneToMany (mappedBy = "post")
    private List<Comment> comments;
    @ManyToOne
    private User user;
}
