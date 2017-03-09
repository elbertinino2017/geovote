package com.geovote.representations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.election.domain.Theme;

@XmlRootElement(name="themes")
public class ThemeCollectionRepresentation {

	private List<Theme> themes;
	
	
	

	public ThemeCollectionRepresentation() {

	}

	public ThemeCollectionRepresentation(List<Theme> themes) {
		super();
		this.themes = themes;
	}

	@XmlElement(name="theme")
	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
	
	
}
