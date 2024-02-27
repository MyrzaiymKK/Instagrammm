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
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column (unique = true,nullable = false)
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE})
    private Follower follower;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private UserInfo userInfo;

    @OneToMany (mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany (mappedBy = "user")
    private List<Comment> comments;

    @OneToOne(mappedBy = "user")
    private Like like;

    @ManyToOne
    private Image image;
}
