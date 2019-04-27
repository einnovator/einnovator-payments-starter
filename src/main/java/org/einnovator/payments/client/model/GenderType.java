package org.einnovator.payments.client.model;

public enum GenderType {
	MALE("Male"),
	
	FEMALE("Female");
	
	private final String displayName;

	GenderType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static GenderType get(String name) {
		if (name==null) {
			return null;
		}
		if (GenderType.valueOf(name)!=null) {
			return GenderType.valueOf(name);
		}
		for (GenderType gender: GenderType.values()) {
			if (gender.toString().equalsIgnoreCase(name) || name.equalsIgnoreCase(gender.displayName)) {
				return gender;
			}
		}
		return null;
	}
	
}
