package com.uralfoxes.repository;

import com.uralfoxes.entity.SystemUser;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Component
public class UserRepository extends AbstractFacade<SystemUser> {
    public UserRepository() {
        super(SystemUser.class);
    }

    @Override
    public void create(SystemUser entity) {
        try {
            em.createQuery("SELECT x FROM SystemUser x WHERE x.login=:login")
                    .setParameter("login", entity.getLogin().toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            
            super.create(entity);
        }
    }
}
