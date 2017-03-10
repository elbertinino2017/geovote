package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.context.election.domain.Theme;

@Repository
public class ThemeDaoJpaImpl implements ThemeDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Theme findElectionsThemeByCode(String code, String themeId) {
		return em.createQuery("select theme from Theme as theme where theme.code=:themeId and theme.electionInfo.electionCode=:code",Theme.class)
				.setParameter("themeId", themeId)
				.setParameter("code", code)
				.getSingleResult();
	}

}
