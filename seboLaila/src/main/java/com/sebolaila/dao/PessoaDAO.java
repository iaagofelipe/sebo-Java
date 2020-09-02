package com.sebolaila.dao;

import com.sebolaila.connection.ConnectionFactory;
import com.sebolaila.entity.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO implements DAO<Pessoa> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();


    @Override
    public Pessoa save(Pessoa pessoa) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(pessoa);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> getList() {
        Query query = this.entityManager.createQuery("SELECT p FROM Pessoa as p");
        return query.getResultList();
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (pessoa.getId() == null) {
                this.entityManager.persist(pessoa);
            } else {
                pessoaUp = this.entityManager.merge(pessoa);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return pessoaUp;
    }

    @Override
    public Pessoa delete(Long id) {
        Pessoa pessoa = null;
        try {
            pessoa = entityManager.find(Pessoa.class, id);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(pessoa);
            this.entityManager.getTransaction().commit();

        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return pessoa;
    }

    @Override
    public Pessoa findById(Long id) {
        Pessoa pessoa = null;
        try {
            pessoa = entityManager.find(Pessoa.class, id);
        } catch (Exception e) {
            System.out.println("erro ao buscar por id\n" + e);
        }
        return pessoa;
    }
}