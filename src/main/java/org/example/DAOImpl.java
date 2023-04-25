package org.example;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class DAOImpl{
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
    static EntityManager em = emf.createEntityManager();

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void addZoo() throws IOException {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("Enter Name of Zoo ::");
        String name = reader.readLine();
        System.out.println("Enter Name of City ::");
        String city = reader.readLine();

        Zoo zoo = new Zoo(name,city);
        em.persist(zoo);
        em.close();
        emf.close();
    }


    public static void addAnimal() throws IOException {
        EntityTransaction tx = em.getTransaction();

        System.out.println("Enter Name of Animal ::");
        String name = reader.readLine();
        System.out.println("Enter type of Animal ::");
        String type = reader.readLine();
        System.out.println("Enter admission date :: ");
        LocalDate addDate = LocalDate.parse(reader.readLine());
        System.out.println("Enter Origin Country ::");
        String origin = reader.readLine();
        System.out.println("Enter Age ::");
        int age = Integer.parseInt(reader.readLine());

        System.out.println("Enter zoo id ::");
        int zooId = Integer.parseInt(reader.readLine());
        Zoo zoo = em.find(Zoo.class, zooId);
        tx.begin();
        Animal animal = new Animal(name, type,age, addDate, origin);
        animal.setZoo(zoo);

        em.persist(animal);
        em.getTransaction().commit();
    }

    public static void q1(){
        EntityTransaction tx = em.getTransaction();
//        TypedQuery<Animal> query = em.createQuery(
//                "SELECT a FROM Animal a WHERE a.age > :maxAge", Animal.class);
//        int maxAge = 4;
//        query.setParameter("maxAge", maxAge);
//
//// Execute the query and retrieve the results
//        List<Animal> animals = query.getResultList();
//
//        for (Animal a:animals
//             ) {
//            System.out.println("--------------------------");
//            System.out.println(a.getName());
//            System.out.println("--------------------------");
//        }


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal>  from = criteriaQuery.from(Animal.class);
        criteriaQuery.select(from).where(cb.greaterThan(from.get("age"), 4));

        TypedQuery<Animal> q = em.createQuery(criteriaQuery);
        List<Animal> animals = q.getResultList();
        for (Animal a: animals
             ) {
            System.out.println("-----------------------------");
            System.out.println(a.getName());
            System.out.println("-----------------------------");
        }

    }
    public static void LikeQ(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal>  from = criteriaQuery.from(Animal.class);
        criteriaQuery.select(from).where(
                cb.like(from.get("name"), "L%")
        );

        List<Animal> animals = em.createQuery(criteriaQuery).getResultList();

        for (Animal a :animals
             ) {
            System.out.println("---------------------------------------");
            System.out.println(a.getName());
            System.out.println("---------------------------------------");

        }

        em.close();
        emf.close();
    }

}
