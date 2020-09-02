package com.sebolaila.dao;

import com.sebolaila.connection.ConnectionFactory;
import com.sebolaila.entity.Livros;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LivrosDAO implements DAO<Livros> {


    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Livros save(Livros livros) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(livros);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return livros;
    }

    @Override
    public List getList() {
        Query query = this.entityManager.createQuery("SELECT l FROM Livros as l");
        return query.getResultList();
    }

    @Override
    public Livros update(Livros livros) {
        Livros livrosUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (livros.getId() == null) {
                this.entityManager.persist(livros);
            } else {
                livrosUp = this.entityManager.merge(livros);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return livrosUp;
    }

    @Override
    public Livros delete(Long id) {
        Livros livros = null;
        try {
            livros = entityManager.find(Livros.class, id);

            this.entityManager.getTransaction().begin();
            this.entityManager.remove(livros);
            this.entityManager.getTransaction().commit();

        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return livros;
    }

    @Override
    public Livros findById(Long id) {
        Livros livros = null;
        try {
            livros = entityManager.find(Livros.class, id);
        } catch (Exception e) {
            // TODO: Throw exception here!!
            System.out.println("erro ao buscar por id\n" + e);
        }
        return livros;
    }
}
