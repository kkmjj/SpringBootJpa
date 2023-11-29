package jpabook.jpashop.domain;


import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberid;
    // id를 쓰면 뭔가 객체 지향 스럽지 않다.



    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this); // member.getOrders.add(member) 대신 set에서 적용.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
