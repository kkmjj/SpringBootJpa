package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

       EntityManager em = emf.createEntityManager();

        EntityTransaction tran = em.getTransaction();
        tran.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("A");

        em.persist(member);
        tran.commit();

        em.close();

       emf.close();


    }
}
