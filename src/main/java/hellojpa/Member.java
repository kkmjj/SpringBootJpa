package hellojpa;


import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(
        name = "CUSTOM_SEQ",
        sequenceName = "MEMBER_SEQ")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUSTOM_SEQ")
    private Long id;

    @Column(updatable = false, nullable = false)  // update시에 반영 절때로 안되게 지정 할 수 있음.  ( nullable = false === not null )
    private String name;

    @Enumerated(EnumType.STRING)    // Enum을 이용. 하여 DB와 연동.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @Temporal(TemporalType.TIMESTAMP)       //DATE, TIME, TIMESTAMP 3가지 유형 있음.
    private Date ModifyDate;

    @Lob
    private String desc;

    @Transient()        //db에서는 사용안하고 메모리로만 사용하고 싶을때.
    private int temp;

    public Member(){

    }



}
