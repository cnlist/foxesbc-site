package com.uralfoxes.controller;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

public class DataManager<T> {

    private Class<T> entityClass;
    private EntityManager entityManager;
    private UserTransaction tx;


    public DataManager(Class<T> tclass) {
        entityClass = tclass;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("uf_pu").createEntityManager();
            entityManager.setFlushMode(FlushModeType.AUTO);
        }
        return entityManager;
    }

    public void create(T entity) {
        try {
            getTx().begin();
            getEntityManager().persist(entity);
            getTx().commit();
        } catch (Exception e) {

        }
    }

    public void edit(T entity) {
        try {
            getTx().begin();
            getEntityManager().merge(entity);
            getTx().commit();
        } catch (Exception e) {
        }
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    public UserTransaction getTx() {
        if (tx == null) {
            try {
                tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            } catch (NamingException ne) {

            }
        }
        return tx;
    }
}
