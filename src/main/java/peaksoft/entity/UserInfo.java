package peaksoft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    private Gender gender;
    private String image;
    @OneToOne
    private User user;
}
