package Library;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DAOImpl1 implements DAO{
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
    static EntityManager em = emf.createEntityManager();

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void addLibrary() throws IOException {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("Enter Name of Library ::");
        String name = reader.readLine();


       Library library = new Library(name);
        em.persist(library);

    }


    public static void addBook() throws IOException {
        EntityTransaction tx = em.getTransaction();

        System.out.println("Enter name of book :: ");
        String name = reader.readLine();
        System.out.println("Enter Publisher ::");
        String pub = reader.readLine();
        System.out.println("Enter price ::");
        int price = Integer.parseInt(reader.readLine());
        System.out.println("Enter Library id ::");
        int lId = Integer.parseInt(reader.readLine());

        Library library = em.find(Library.class, lId);
        tx.begin();
        Book book = new Book(name, pub, price);
        book.setLibrary(library);

        em.persist(book);
        em.getTransaction().commit();
    }


    public static void q1() throws IOException {
        EntityTransaction tx = em.getTransaction();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
        Root<Book> from = criteriaQuery.from(Book.class);
        criteriaQuery.select(from).where(cb.greaterThan(from.get("price"), 400));

        TypedQuery<Book> q = em.createQuery(criteriaQuery);
        List<Book> books = q.getResultList();
        for (Book b: books
        ) {
            System.out.println("-----------------------------");
            System.out.println(b.getName());
            System.out.println("-----------------------------");
        }

    }


    public static void q2() throws IOException {
        EntityTransaction tx = em.getTransaction();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
        Root<Book> from = criteriaQuery.from(Book.class);
        criteriaQuery.orderBy(cb.asc(from.get("publisher")));
        List<Book> books = em.createQuery(criteriaQuery).getResultList();

        for (Book book:books
             ) {
            System.out.println("---------------------------------");
            System.out.println(book.getName());
            System.out.println(book.getPublisher());
            System.out.println("---------------------------------");
        }

        em.close();
        emf.close();
    }
}
