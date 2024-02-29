package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;
import peaksoft.forBaseId.BaseEntity;

@Entity
@Table(name = "userInfos")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "userInfos_seq" ,allocationSize = 1)
public class UserInfo extends BaseEntity {
    private String fullName;
    private String biography;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.PERSIST)
    private User user;
}
