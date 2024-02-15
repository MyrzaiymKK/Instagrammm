package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.util.List;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "images_seq" ,allocationSize = 1)
public class Image extends BaseEntity {
    private String imageUrl;
    @ManyToOne
    private Post post;
    @OneToMany (mappedBy = "image")
    private List<User> users;
}
