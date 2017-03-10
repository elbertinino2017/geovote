package com.geovote.representations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.result.domain.ThemePercentage;

@XmlRootElement(name = "themepercentages")
public class ThemePercentageCollectionRepresentation {
	
	private List<ThemePercentage> themePercentages;


	public ThemePercentageCollectionRepresentation() {
	}

	public ThemePercentageCollectionRepresentation(List<ThemePercentage> themePercentages) {
		this.themePercentages = themePercentages;
	}

	@XmlElement(name="themepercentage")
	public List<ThemePercentage> getThemePercentages() {
		return themePercentages;
	}

	public void setThemePercentages(List<ThemePercentage> themePercentages) {
		this.themePercentages = themePercentages;
	}

}
