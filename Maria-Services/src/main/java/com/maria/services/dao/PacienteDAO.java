
package com.maria.services.dao;

import com.maria.lib.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class PacienteDAO {
    
    @PersistenceContext(unitName = "MariaPU")
     EntityManager entityManager;


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Paciente paciente) {
        getEntityManager().persist(getEntityManager().merge(paciente));
    }
    
    public void update(Paciente paciente) {
        getEntityManager().merge(paciente);
    }

    public void delete(Object id) {
        Paciente entity = getEntityManager().find(Paciente.class, id);
        getEntityManager().remove(entity);
    }

    public Paciente find(Object id) {
        return getEntityManager().find(Paciente.class, id);
    }

    public List<Paciente> loadAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Paciente.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
