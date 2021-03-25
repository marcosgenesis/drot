package br.com.pi.drot.dto;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    public static EntityManager entityManager = Persistence.createEntityManagerFactory("UP").createEntityManager();
    private Class clazz;

    public GenericDAO(Class clazz) {
        this.clazz = clazz;
    }

    public boolean insert(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void delete(T entity) {
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }


    public T obterPorId(int id) {
        entityManager.clear();
        return (T) entityManager.find(clazz, id);
    }

    public T obter(T entity) {
        entityManager.clear();
        return (T) entityManager.find(clazz, entity);
    }

    public ArrayList<T> list() {
        return (ArrayList<T>) entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

}
