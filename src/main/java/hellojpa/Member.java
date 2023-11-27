package hellojpa;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Member {

    @Id
    private Long id;


    private String name;

    @Enumerated(EnumType.STRING)    // Enum을 이용. 하여 DB와 연동.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @Temporal(TemporalType.TIMESTAMP)       //DATE, TIME, TIMESTAMP 3가지 유형 있음.
    private Date ModifyDate;

    @Lob
    private String desc;

    public Member(){

    }



}
