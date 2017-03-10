package com.geovote.data;

import com.geovote.context.election.domain.Theme;

public interface ThemeDao {

	public Theme findElectionsThemeByCode(String code, String themeId);

}
