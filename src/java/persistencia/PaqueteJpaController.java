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
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Paquete;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ivanc
 */
public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PaqueteJpaController() {
        emf =  Persistence.createEntityManagerFactory("AgenciaTurismoTPOFinalPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) {
        if (paquete.getListaServicios() == null) {
            paquete.setListaServicios(new ArrayList<Servicio>());
        }
        if (paquete.getListaDePaquetes() == null) {
            paquete.setListaDePaquetes(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedListaServicios = new ArrayList<Servicio>();
            for (Servicio listaServiciosServicioToAttach : paquete.getListaServicios()) {
                listaServiciosServicioToAttach = em.getReference(listaServiciosServicioToAttach.getClass(), listaServiciosServicioToAttach.getId());
                attachedListaServicios.add(listaServiciosServicioToAttach);
            }
            paquete.setListaServicios(attachedListaServicios);
            List<Venta> attachedListaDePaquetes = new ArrayList<Venta>();
            for (Venta listaDePaquetesVentaToAttach : paquete.getListaDePaquetes()) {
                listaDePaquetesVentaToAttach = em.getReference(listaDePaquetesVentaToAttach.getClass(), listaDePaquetesVentaToAttach.getId());
                attachedListaDePaquetes.add(listaDePaquetesVentaToAttach);
            }
            paquete.setListaDePaquetes(attachedListaDePaquetes);
            em.persist(paquete);
            for (Servicio listaServiciosServicio : paquete.getListaServicios()) {
                listaServiciosServicio.getListaPaquetes().add(paquete);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            for (Venta listaDePaquetesVenta : paquete.getListaDePaquetes()) {
                Paquete oldPaqueteOfListaDePaquetesVenta = listaDePaquetesVenta.getPaquete();
                listaDePaquetesVenta.setPaquete(paquete);
                listaDePaquetesVenta = em.merge(listaDePaquetesVenta);
                if (oldPaqueteOfListaDePaquetesVenta != null) {
                    oldPaqueteOfListaDePaquetesVenta.getListaDePaquetes().remove(listaDePaquetesVenta);
                    oldPaqueteOfListaDePaquetesVenta = em.merge(oldPaqueteOfListaDePaquetesVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getId());
            List<Servicio> listaServiciosOld = persistentPaquete.getListaServicios();
            List<Servicio> listaServiciosNew = paquete.getListaServicios();
            List<Venta> listaDePaquetesOld = persistentPaquete.getListaDePaquetes();
            List<Venta> listaDePaquetesNew = paquete.getListaDePaquetes();
            List<Servicio> attachedListaServiciosNew = new ArrayList<Servicio>();
            for (Servicio listaServiciosNewServicioToAttach : listaServiciosNew) {
                listaServiciosNewServicioToAttach = em.getReference(listaServiciosNewServicioToAttach.getClass(), listaServiciosNewServicioToAttach.getId());
                attachedListaServiciosNew.add(listaServiciosNewServicioToAttach);
            }
            listaServiciosNew = attachedListaServiciosNew;
            paquete.setListaServicios(listaServiciosNew);
            List<Venta> attachedListaDePaquetesNew = new ArrayList<Venta>();
            for (Venta listaDePaquetesNewVentaToAttach : listaDePaquetesNew) {
                listaDePaquetesNewVentaToAttach = em.getReference(listaDePaquetesNewVentaToAttach.getClass(), listaDePaquetesNewVentaToAttach.getId());
                attachedListaDePaquetesNew.add(listaDePaquetesNewVentaToAttach);
            }
            listaDePaquetesNew = attachedListaDePaquetesNew;
            paquete.setListaDePaquetes(listaDePaquetesNew);
            paquete = em.merge(paquete);
            for (Servicio listaServiciosOldServicio : listaServiciosOld) {
                if (!listaServiciosNew.contains(listaServiciosOldServicio)) {
                    listaServiciosOldServicio.getListaPaquetes().remove(paquete);
                    listaServiciosOldServicio = em.merge(listaServiciosOldServicio);
                }
            }
            for (Servicio listaServiciosNewServicio : listaServiciosNew) {
                if (!listaServiciosOld.contains(listaServiciosNewServicio)) {
                    listaServiciosNewServicio.getListaPaquetes().add(paquete);
                    listaServiciosNewServicio = em.merge(listaServiciosNewServicio);
                }
            }
            for (Venta listaDePaquetesOldVenta : listaDePaquetesOld) {
                if (!listaDePaquetesNew.contains(listaDePaquetesOldVenta)) {
                    listaDePaquetesOldVenta.setPaquete(null);
                    listaDePaquetesOldVenta = em.merge(listaDePaquetesOldVenta);
                }
            }
            for (Venta listaDePaquetesNewVenta : listaDePaquetesNew) {
                if (!listaDePaquetesOld.contains(listaDePaquetesNewVenta)) {
                    Paquete oldPaqueteOfListaDePaquetesNewVenta = listaDePaquetesNewVenta.getPaquete();
                    listaDePaquetesNewVenta.setPaquete(paquete);
                    listaDePaquetesNewVenta = em.merge(listaDePaquetesNewVenta);
                    if (oldPaqueteOfListaDePaquetesNewVenta != null && !oldPaqueteOfListaDePaquetesNewVenta.equals(paquete)) {
                        oldPaqueteOfListaDePaquetesNewVenta.getListaDePaquetes().remove(listaDePaquetesNewVenta);
                        oldPaqueteOfListaDePaquetesNewVenta = em.merge(oldPaqueteOfListaDePaquetesNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getId();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
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
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> listaServicios = paquete.getListaServicios();
            for (Servicio listaServiciosServicio : listaServicios) {
                listaServiciosServicio.getListaPaquetes().remove(paquete);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            List<Venta> listaDePaquetes = paquete.getListaDePaquetes();
            for (Venta listaDePaquetesVenta : listaDePaquetes) {
                listaDePaquetesVenta.setPaquete(null);
                listaDePaquetesVenta = em.merge(listaDePaquetesVenta);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
