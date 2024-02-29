package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToMany (mappedBy = "post",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Image> imageList;

    @OneToOne (mappedBy = "post")
    private Like like;

    @OneToMany (mappedBy = "post")
    private List<Comment> comments;

    @ManyToOne
    private User user;

    @Transient
    private String imageUrl;

    public void addImage(Image image){
        if (imageList == null) imageList = new ArrayList<>();
        imageList.add(image);
    }
}
