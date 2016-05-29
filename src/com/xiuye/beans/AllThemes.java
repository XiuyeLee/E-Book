package com.xiuye.beans;

import org.springframework.stereotype.Component;

@Component
public class AllThemes {

	public static final String[] POSSIBLE_THEMES = { "swanky-purse",
			"bootstrap", "afterdark", "afternoon", "afterwork", "aristo",
			"black-tie", "blitzer", "bluesky", "casablanca", "cruze",
			"cupertino", "dark-hive", "dot-luv", "eggplant", "excite-bike",
			"flick", "glass-x", "home", "hot-sneaks", "humanity", "le-frog",
			"midnight", "mint-choc", "overcast", "pepper-grinder", "redmond",
			"rocket", "sam", "smoothness", "south-street", "start", "sunny",
			"trontastic", "twitter bootstrap", "ui-darkness", "ui-lightness",
			"vader" };

	public static final String DEFAULT_THEME = "swanky-purse"; 
	
	public String[] getThemes() {
		return POSSIBLE_THEMES;
	}

	
}
