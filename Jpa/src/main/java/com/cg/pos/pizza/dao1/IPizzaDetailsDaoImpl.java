package com.cg.pos.pizza.dao1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.utility.Queries;

public class IPizzaDetailsDaoImpl implements IPizzaDetails {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	EntityManager em = emf.createEntityManager();
	String result;

	public String delete(PizzaDetailsDTO detailsDTO) {

//		PizzaDetailsDTO id = em.find(PizzaDetailsDTO.class, detailsDTO.getItemId());
//		System.out.println(id);
		System.out.println("jhavd");
		em.getTransaction().begin();
		Query query = em.createNamedQuery("DELETE_ROW");
		query.setParameter(1, detailsDTO.getItemId());
		query.setParameter(2, detailsDTO.getStoreId());
		int i = query.executeUpdate();
		em.getTransaction().commit();
		if (i == 1) {
			result = "1";
		}
		return result;

	}

	@Override
	public String modify(PizzaDetailsDTO detailsDTO) {

		if (detailsDTO.getItemName() != null) {
			em.getTransaction().begin();
			System.out.println("hsfdj");
			System.out.println(detailsDTO.getItemName());
			Query query = em.createNamedQuery("MODIFY_NAME");
			System.out.println(query);
			System.out.println(detailsDTO.getItemName());
			query.setParameter(1, detailsDTO.getItemName());
			query.setParameter(2, detailsDTO.getItemId());
			query.setParameter(3, detailsDTO.getStoreId());
			System.out.println(detailsDTO.getItemName());
			int i = query.executeUpdate();
			System.out.println(i);
			em.getTransaction().commit();
			if (i == 1) {
				result = "1";
			}
			//
			// PizzaDetailsDTO res=em.find(PizzaDetailsDTO.class,detailsDTO.getItemId() );
			// res.setItemName(detailsDTO.getItemName());
			// em.getTransaction().commit();
			// return "1";
		}
		 if(detailsDTO.getCost()!=0) {
		 em.getTransaction().begin();
		 Query query=em.createNamedQuery("MODIFY_COST");
		 query.setParameter(1, detailsDTO.getCost());
		 query.setParameter(2, detailsDTO.getItemId());
		 query.setParameter(3, detailsDTO.getStoreId());
		 int i=query.executeUpdate();
		 System.out.println(i);
		 em.getTransaction().commit();
		 if(i==1) {result="1";}
		
		
		 }
		 if(detailsDTO.getQuantity()!=0) {
		 em.getTransaction().begin();
		 Query query=em.createNamedQuery("MODIFY_QUANTITY");
		 query.setParameter(1, detailsDTO.getQuantity());
		 query.setParameter(2, detailsDTO.getItemId());
		 query.setParameter(3, detailsDTO.getStoreId());
		 int i=query.executeUpdate();
		 em.getTransaction().commit();
		 if(i==1) {result="1";}
		
		
		 }

		return result;

	}
}
