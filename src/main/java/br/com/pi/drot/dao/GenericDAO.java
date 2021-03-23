package br.com.pi.drot.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    public static EntityManager entityManager = Persistence.createEntityManagerFactory("DROT").createEntityManager();
    private Class<?> clazz;

    public GenericDAO(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean cadastrarNovaInstancia(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public boolean editarInstancia(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void removerInstancia(T entity) {
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public T obterPorId(int id) {
        entityManager.clear();
        return (T) entityManager.find(clazz, id);
    }

    public T obterInstancia(T entity) {
        entityManager.clear();
        return (T) entityManager.find(clazz, entity);
    }

    public ArrayList<T> listarInstancias() {
        return (ArrayList<T>) entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

}
