package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.forBaseId.BaseEntity;

import java.util.List;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "followers_seq" ,allocationSize = 1)
public class Follower extends BaseEntity {
    @ElementCollection
    private List<Long> subscribers;
    @ElementCollection
    private List<Long> subscription;
    @OneToOne
    private User user;

}
