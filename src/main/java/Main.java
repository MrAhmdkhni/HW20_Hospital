import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class Main {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }
}
