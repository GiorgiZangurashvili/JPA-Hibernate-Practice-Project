package dev.jpa;

import dev.jpa.entity.criteria.Customer;
import dev.jpa.entity.jpql.join.Course;
import dev.jpa.entity.jpql.join.Enrollment;
import dev.jpa.entity.jpql.join.Student;
import dev.jpa.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (
                EntityManagerFactory emf = new HibernatePersistenceProvider()
                        .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());
                EntityManager em = emf.createEntityManager();
            ) {
            em.getTransaction().begin();

//            Product product = new Product();
//            product.setId(1L);
//            product.setName("Prime");
//
//            em.persist(product); // Add a new instance of an entity to the context -> NOT AN INSERT QUERY

//            Product product = em.find(Product.class, 1L);
//            product.setName("Coca Cola");
//            System.out.println(product);

//            Product p = new Product();
////            p.setId(2L);
//            p.setName("Pepsi");
//            em.merge(p);
////            em.find(Product.class, 1L);
//
//            p.setName("COCA COLA");

            // composed key - first method
//            EntityWithComposedPK pk = new EntityWithComposedPK();
//            pk.setCode(69420L);
//            pk.setSlug("unique-slug");
//            pk.setName("name");
//            pk.setSurname("surname");
//            em.persist(pk);

            // composed key - second method
//            EntityWithComposedPK2 pk2 = new EntityWithComposedPK2();
//            ComposedKey2 key2 = new ComposedKey2();
//            key2.setCode(69420L);
//            key2.setSlug("unique-slug");
//            pk2.setComposedKey2(key2);
//            pk2.setAge(22L);
//            em.persist(pk2);

//            ComposedKey composedKey = new ComposedKey();
//            composedKey.setCode(69420L);
//            composedKey.setSlug("unique-slug");
//            var pk = em.find(EntityWithComposedPK.class, composedKey);
//            System.out.println(pk);
//
//            var pk2 = em.find(EntityWithComposedPK2.class, key2);
//            System.out.println(pk2);

//            Person person = new Person();
//            person.setName("Jason");
//
//            Passport passport = new Passport();
//            passport.setNumber("123456789");
//
//            // we should set both, bidirectional relationship
//            person.setPassport(passport);
//            passport.setPerson(person);
//
//            em.persist(person);
//            // no longer needed, as we have
//            // cascade PERSIST in Person entity
////            em.persist(passport);

            // write query with EntityManager
//            TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.passport.number = :number", Person.class);
//            q.setParameter("number", "123456789");
//            List<Person> persons = q.getResultList();
//            System.out.println(persons);

            // secondary table example
//            User user = new User();
//            user.setName("Joe");
//            user.setDescription("Kessler");
//            em.persist(user);

            // bidirectional one-to-many relationship
//            Post post = new Post();
//            post.setTitle("Post 1");
//            post.setContent("Post content");
//
//            Comment comment = new Comment();
//            comment.setContent("Comment content");
//
//            comment.setPost(post);
//            post.setComments(List.of(comment));
//
//            em.persist(post);
            // no longer needed, as we have cascade
            // PERSIST in Post entity
//            em.persist(comment);

//            TypedQuery<Post> q = em.createQuery("SELECT p FROM Post p WHERE size(p.comments) > 0", Post.class);
//            System.out.println(q.getResultList());

//            Developer developer = new Developer();
//            developer.setName("Giorgi");
//            developer.setEmail("GIORGI_EMAIL");
//            developer.setLevel("Junior");
//
//            Company company = new Company();
//            company.setName("Optimo Group");
//            company.setYearOfCreation(2020);
//            company.setNumberOfEmployees(60);
//
//            company.setDevelopers(List.of(developer));
//            developer.setCompanies(List.of(company));
//
//            em.persist(developer);
//            em.persist(company);

//            Woman woman = new Woman();
//            woman.setName("Jane");
//            woman.setAge(25);
//
//            Man man = new Man();
//            man.setName("Dave");
//            man.setAge(27);
//
//            man.setWoman(woman);
//            woman.setMan(man);
//
//            em.persist(man);

//            Book book = new Book();
//            book.setId(1L);
//            book.setName("Jayos Khiznebi");
//            book.setAuthor("Mikheil Javakhishvili");
//
//            ElectronicDevice electronicDevice = new ElectronicDevice();
//            electronicDevice.setId(2L);
//            electronicDevice.setName("Tesla");
//            electronicDevice.setModel("Model S");
//
//            em.persist(electronicDevice);
//            em.persist(book);

            /* JPQL example 1:
            FootballPlayer fp = new FootballPlayer();
            fp.setFirstName("Lionel");
            fp.setLastName("Messi");
            fp.setPrice(BigDecimal.valueOf(250_000_000.0));

            em.persist(fp);

            String jpql = "SELECT fp FROM FootballPlayer fp";
            String jpql = "SELECT fp FROM FootballPlayer fp WHERE fp.price >= 200000000";
            String jpql = "SELECT fp FROM FootballPlayer fp WHERE fp.price > :price AND fp.firstName LIKE :firstName";

            // JPQL
            // SELECT fp FROM FootballPlayer fp ===> Fetch all the attributes of an entity from the current context

            // Native Query
            // SELECT * FROM FOOTBALL_PLAYERS ===> Fetch all the columns from the table FOOTBALL_PLAYERS

            TypedQuery<FootballPlayer> q = em.createQuery(jpql, FootballPlayer.class);

            q.setParameter("price", BigDecimal.valueOf(0.0));
            q.setParameter("firstName", "%e%"); // LIKE

            System.out.println(q.getResultList());
             */

            /* JPQL example 2:
            String jpql = "SELECT AVG(fp.price) FROM FootballPlayer fp";

            TypedQuery<Double> q = em.createQuery(jpql, Double.class);

            System.out.println(q.getSingleResult());

            em.getTransaction().commit();
             */

            /* JPQL example 3:
            String jpql = "SELECT COUNT(fp) FROM FootballPlayer fp";

            TypedQuery<Long> q = em.createQuery(jpql, Long.class);

            System.out.println(q.getSingleResult());

            em.getTransaction().commit();
            */

            /* JPQL example 4:
            String jpql = "SELECT fp.firstName, fp.price FROM FootballPlayer fp";

            TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);

            q.getResultList().forEach(
                    result -> System.out.println(result[0] + ", " + result[1])
            );
            */

            /* JPQL example 4 (Querying a result that doesn't exist):
            String jpql = "SELECT fp FROM FootballPlayer fp WHERE fp.firstName = 'Cristiano'";

            TypedQuery<FootballPlayer> q = em.createQuery(jpql, FootballPlayer.class);

            Optional<FootballPlayer> fp;

            try {
                fp = Optional.of(q.getSingleResult());
            } catch (NoResultException e) {
                fp = Optional.empty();
            }

            fp.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("FootballPlayer not found")
            );
            */

            /* JPQL JOIN examples:
            String jpql = """
                    SELECT s, e FROM Student s INNER JOIN s.enrollments e
                    """;

            String jpql = """
                    SELECT s, e FROM Student s JOIN s.enrollments e
                    """;

            String jpql = """
                    SELECT s, e FROM Student s, Enrollment e WHERE s.id = e.student.id
                    """;

            String jpql = """
                    SELECT s, e FROM Student s, Enrollment e WHERE s = e.student
                    """;
             */

            /* JPQL store query result in respective dto object:
            String jpql = """
                    SELECT NEW dev.jpa.entity.jpql.join.dto.EnrolledStudentDto(s, e)
                    FROM Student s, Enrollment e
                    WHERE s = e.student
                    """;

             String jpql = """
                    SELECT NEW dev.jpa.entity.jpql.join.dto.CountedEnrollmentForStudent(s, COUNT(s))
                    FROM Student s
                    """;
             */

            /* JPQL subquery:
            String jpql = """
                    SELECT s FROM Student s WHERE
                        (SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id) > 1
                    """;
             */

            /* JPQL GROUP BY:
            String jpql = """
                    SELECT NEW dev.jpa.entity.jpql.join.dto.CountedEnrollmentForStudent(s, COUNT(s))
                    FROM Student s
                    GROUP BY s
                    HAVING s.name LIKE '%e'
                    ORDER BY s.name DESC
                    """;
             */

            /* JPQL Named Queries:
            TypedQuery<Student> q = em.createNamedQuery("findAllStudents", Student.class);

            q.getResultList().forEach(s -> System.out.println(s));
             */

            /* Native Query:
            String sql = """
                    SELECT * FROM student
                    """;

            Query q = em.createNativeQuery(sql, Student.class);
            q.getResultList().forEach(s -> System.out.println(s));
             */

//            for (int i = 0; i < 20; i++) {
//                Customer customer = new Customer();
//                customer.setName("Customer " + i);
//                em.persist(customer);
//            }

            /* Simple CriteriaQuery
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

            Root<Customer> customerRoot = cq.from(Customer.class);
            cq.select(customerRoot);  // SELECT c FROM Customer c
            TypedQuery<Customer> q = em.createQuery(cq);

            CriteriaQuery<String> cq = cb.createQuery(String.class);
            Root<Customer> customerRoot = cq.from(Customer.class);

            cq.select(customerRoot.get("name"));  // SELECT c.name FROM Customer c
            TypedQuery<String> q = em.createQuery(cq);

            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<Customer> customerRoot = cq.from(Customer.class);

            cq.multiselect(customerRoot.get("id"), customerRoot.get("name"))
                    .where(builder.ge(customerRoot("id"), 5)
                    .orderBy(builder.desc(customerRoot.get("id")));
            // SELECT c.id, c.name FROM Customer c WHERE c.id >= 5 ORDER BY c.id DESC

            TypedQuery<Object[]> q = em.createQuery(cq);

            q.getResultList().forEach(System.out::println);
             */

            CriteriaBuilder cb = em.getCriteriaBuilder(); // ASC, DESC, >, <, >=, <=, SUM, AVG, etc...
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);  // SELECT, WHERE, GROUP BY, ORDER BY, etc...
            Root<Customer> customerRoot = cq.from(Customer.class); // Customer c

            cq.multiselect(cb.sum(customerRoot.get("id")), customerRoot.get("name"));
            cq.where(cb.ge(customerRoot.get("id"), 5));
            cq.groupBy(customerRoot.get("name"));
            cq.orderBy(cb.desc(customerRoot.get("id")));

            TypedQuery<Object[]> query = em.createQuery(cq);

            query.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));

            em.getTransaction().commit();
        }
    }
}