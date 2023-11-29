package jpabook.jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {

    public static void main(String[] arg){
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tran = em.getTransaction();
        tran.begin();
        try {

            // member(1) : Order(N)

            Member member = new Member();
            member.setName("kimmj");
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            em.persist(order);

//            em.flush();
//            em.clear();
            //주문을 찾고 해당 주문의 멤버를 조회
            Member findmember = em.find(Member.class,member.getId()); // flush를  안하면 1차 캐시안에 데이터로 사용.
            List<Order> orders = findmember.getOrders();
            System.out.println("===============");
            for(Order or : orders)
            {
                System.out.println(or.getId());
            }

            tran.commit();
        }
        catch (Exception E)
        {

        }
        finally {
            em.close();
        }

        emf.close();


    }
}
