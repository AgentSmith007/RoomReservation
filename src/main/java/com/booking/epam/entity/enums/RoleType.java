package com.booking.epam.entity.enums;

public enum RoleType {
	ROLE_ADMIN("Admin role"),
	ROLE_USER("Simple user");

	private String description;

	RoleType(String description) {
		this.description = description;
	}
}
