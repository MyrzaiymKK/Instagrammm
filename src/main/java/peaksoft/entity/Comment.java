package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "comment_seq" ,allocationSize = 1)
public class Comment extends BaseEntity {
    private String comment;
    private LocalDate createdAt;
    @OneToMany (mappedBy = "comment")
    private List<Like> likeList;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

}
