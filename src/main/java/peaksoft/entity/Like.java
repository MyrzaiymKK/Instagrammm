package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.util.List;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "likes_seq" ,allocationSize = 1)
public class Like extends BaseEntity {
    @ElementCollection
    private List<Long> postLike;
    @ElementCollection
    private List<Long> commentLike;
    @ManyToOne
    private Comment comment;
    @OneToOne
    private Post post;
    @OneToOne
    private User user;



}
