package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] arg){
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tran = em.getTransaction();
        tran.begin();
        try {

            Member member = new Member();
            member.setName("kimmj");

            Order order = new Order();
            order.setMember(member);
            em.persist(member);     // 1:N 매핑

            //조회시
            Order find = em.find(Order.class,order.getId());
            Member member1 = find.getMember();

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
