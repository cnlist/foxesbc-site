package com.uralfoxes.controller;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class DefaultController {

    private EntityManager entityManager;


    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("uf_pu").createEntityManager();
            entityManager.setFlushMode(FlushModeType.AUTO);
        }
        return entityManager;
    }
}
