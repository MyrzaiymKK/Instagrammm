package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "users_seq" ,allocationSize = 1)
public class User extends BaseEntity {
    @Column(unique = true)
    private String userName;
    private String password;
    @Column (unique = true)
    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "user")
    private Follower follower;
    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;
    @OneToMany (mappedBy = "user")
    private List<Post> posts;
    @OneToMany (mappedBy = "user")
    private List<Comment> comments;
    @OneToOne
    private Like like;
    @ManyToOne
    private Image image;
}
