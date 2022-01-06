/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Cliente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ivanc
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ClienteJpaController() {
        emf =  Persistence.createEntityManagerFactory("AgenciaTurismoTPOFinalPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getComprasRealizadas() == null) {
            cliente.setComprasRealizadas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedComprasRealizadas = new ArrayList<Venta>();
            for (Venta comprasRealizadasVentaToAttach : cliente.getComprasRealizadas()) {
                comprasRealizadasVentaToAttach = em.getReference(comprasRealizadasVentaToAttach.getClass(), comprasRealizadasVentaToAttach.getId());
                attachedComprasRealizadas.add(comprasRealizadasVentaToAttach);
            }
            cliente.setComprasRealizadas(attachedComprasRealizadas);
            em.persist(cliente);
            for (Venta comprasRealizadasVenta : cliente.getComprasRealizadas()) {
                Cliente oldClienteOfComprasRealizadasVenta = comprasRealizadasVenta.getCliente();
                comprasRealizadasVenta.setCliente(cliente);
                comprasRealizadasVenta = em.merge(comprasRealizadasVenta);
                if (oldClienteOfComprasRealizadasVenta != null) {
                    oldClienteOfComprasRealizadasVenta.getComprasRealizadas().remove(comprasRealizadasVenta);
                    oldClienteOfComprasRealizadasVenta = em.merge(oldClienteOfComprasRealizadasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            List<Venta> comprasRealizadasOld = persistentCliente.getComprasRealizadas();
            List<Venta> comprasRealizadasNew = cliente.getComprasRealizadas();
            List<Venta> attachedComprasRealizadasNew = new ArrayList<Venta>();
            for (Venta comprasRealizadasNewVentaToAttach : comprasRealizadasNew) {
                comprasRealizadasNewVentaToAttach = em.getReference(comprasRealizadasNewVentaToAttach.getClass(), comprasRealizadasNewVentaToAttach.getId());
                attachedComprasRealizadasNew.add(comprasRealizadasNewVentaToAttach);
            }
            comprasRealizadasNew = attachedComprasRealizadasNew;
            cliente.setComprasRealizadas(comprasRealizadasNew);
            cliente = em.merge(cliente);
            for (Venta comprasRealizadasOldVenta : comprasRealizadasOld) {
                if (!comprasRealizadasNew.contains(comprasRealizadasOldVenta)) {
                    comprasRealizadasOldVenta.setCliente(null);
                    comprasRealizadasOldVenta = em.merge(comprasRealizadasOldVenta);
                }
            }
            for (Venta comprasRealizadasNewVenta : comprasRealizadasNew) {
                if (!comprasRealizadasOld.contains(comprasRealizadasNewVenta)) {
                    Cliente oldClienteOfComprasRealizadasNewVenta = comprasRealizadasNewVenta.getCliente();
                    comprasRealizadasNewVenta.setCliente(cliente);
                    comprasRealizadasNewVenta = em.merge(comprasRealizadasNewVenta);
                    if (oldClienteOfComprasRealizadasNewVenta != null && !oldClienteOfComprasRealizadasNewVenta.equals(cliente)) {
                        oldClienteOfComprasRealizadasNewVenta.getComprasRealizadas().remove(comprasRealizadasNewVenta);
                        oldClienteOfComprasRealizadasNewVenta = em.merge(oldClienteOfComprasRealizadasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Venta> comprasRealizadas = cliente.getComprasRealizadas();
            for (Venta comprasRealizadasVenta : comprasRealizadas) {
                comprasRealizadasVenta.setCliente(null);
                comprasRealizadasVenta = em.merge(comprasRealizadasVenta);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
