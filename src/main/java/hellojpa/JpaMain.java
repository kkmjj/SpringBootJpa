package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

       EntityManager em = emf.createEntityManager();

        EntityTransaction tran = em.getTransaction();
        tran.begin();
        try {
            Member findMember = em.find(Member.class,1L);   //

//            findMember.setName("HelloJPA");
//
//            em.persist(findMember);

         List<Member> result =  em.createQuery("select m from Member as m ",Member.class).setFirstResult(1).setMaxResults(10).getResultList();


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
