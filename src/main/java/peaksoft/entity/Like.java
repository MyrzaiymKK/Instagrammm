package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "likes_seq" ,allocationSize = 1)
public class Like extends BaseEntity {
    @Column(name = "is_like")
    private boolean islike;
    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Post post;
    @OneToOne
    private User user;



}
