package ec.edu.uce.method.service;

import ec.edu.uce.method.clases.Card;
import ec.edu.uce.method.clases.Pay;
import ec.edu.uce.method.clases.Product;
import ec.edu.uce.method.clases.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CrudService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CrudService() {
        emf = Persistence.createEntityManagerFactory("MyServicePay");
        em = emf.createEntityManager();
    }

    // Crear entidad
    public void createUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void createCard(Card card) {
        em.getTransaction().begin();
        em.persist(card);
        em.getTransaction().commit();
    }

    public void createPay(Pay pay) {
        em.getTransaction().begin();
        em.persist(pay);
        em.getTransaction().commit();
    }

    public void createProduct(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    // Leer entidad por ID
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    public Card getCardById(Long id) {
        return em.find(Card.class, id);
    }

    public Pay getPayById(Long id) {
        return em.find(Pay.class, id);
    }

    public Product getProductById(Long id) {
        return em.find(Product.class, id);
    }

    // Leer todos los registros
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public List<Card> getAllCards() {
        TypedQuery<Card> query = em.createQuery("SELECT c FROM Card c", Card.class);
        return query.getResultList();
    }

    public List<Pay> getAllPays() {
        TypedQuery<Pay> query = em.createQuery("SELECT p FROM Pay p", Pay.class);
        return query.getResultList();
    }

    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    // Actualizar entidad
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void updateCard(Card card) {
        em.getTransaction().begin();
        em.merge(card);
        em.getTransaction().commit();
    }

    public void updatePay(Pay pay) {
        em.getTransaction().begin();
        em.merge(pay);
        em.getTransaction().commit();
    }

    public void updateProduct(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    // Eliminar entidad
    public void deleteUser(Long id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
    }

    public void deleteCard(Long id) {
        em.getTransaction().begin();
        Card card = em.find(Card.class, id);
        if (card != null) {
            em.remove(card);
        }
        em.getTransaction().commit();
    }

    public void deletePay(Long id) {
        em.getTransaction().begin();
        Pay pay = em.find(Pay.class, id);
        if (pay != null) {
            em.remove(pay);
        }
        em.getTransaction().commit();
    }

    public void deleteProduct(Long id) {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
        em.getTransaction().commit();
    }

    // Cerrar recursos
    public void close() {
        em.close();
        emf.close();
    }
}