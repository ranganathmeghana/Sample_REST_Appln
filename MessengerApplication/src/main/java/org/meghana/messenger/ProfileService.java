package org.meghana.messenger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.meghana.messenger.database.Database;
import org.meghana.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> map = Database.getProfiles();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	public ProfileService() {
		
		map.put("Meghana", new Profile(1L, "meg", "Meghana", "Ranganath", date));
	}
	
	public List<Profile> getAllProfiles(){	
		return new ArrayList<Profile>(map.values());
	}
	
	public Profile getProfile(String name){
		return map.get(name);	}
	
	public Profile addProfile(Profile profile){
		profile.setId(map.size() +1);
		map.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getId() <= 0){
			return null;
		}
		map.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return map.remove(profileName);
		
	}

}
