package japbook.jpashop;

import japbook.jpashop.domain.Order;
import japbook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //DataBase 연결 등 기초 셋팅, 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성 한 트랜잭션 마다 꼭 생성 소멸 필요
        EntityManager em = emf.createEntityManager();

        //트랜잭션 시작
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Order order = new Order();
            order.addOrderItem(new OrderItem());

            //트랜잭션 커밋
            tx.commit();
        }catch (Exception e){
            //트랜잭션 롤백
            tx.rollback();
        }finally {
            //엔티티 매니저 종료
            em.close();
        }

        //엔티티 매니저 팩토리 종료
        emf.close();
        }
    }

