package com.geovote.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.Voter;

@Repository
public class VoterDaoJpaImpl implements VoterDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Voter newVoter) {
		em.persist(newVoter);
	}

	@Override
	public void update(Voter voterToUpdate) {
		em.merge(voterToUpdate);
	}

	@Override
	public void delete(Voter voterToDelete) {

		em.remove(voterToDelete);
	}

	@Override
	public List<Voter> getAllVoters() {

		List<Voter> allVoters = em.createQuery("select voter from Voter as voter", Voter.class).getResultList();
		return allVoters;
	}

}
