package org.einnovator.payments.client.modelx;


import java.util.List;

import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.ToStringCreator;

public class AccountFilter extends AccountOptions {

	private OwnerType type;
	
	private String q;	

	private String group;
	
	private List<String> groups;

	private Boolean seller;

	/**
	 * Create instance of {@code AccountFilter}.
	 *
	 */
	public AccountFilter() {
	}
	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public OwnerType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(OwnerType type) {
		this.type = type;
	}
	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}


	/**
	 * Get the value of property {@code groups}.
	 *
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}


	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups to set
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	


	/**
	 * Get the value of property {@code seller}.
	 *
	 * @return the seller
	 */
	public Boolean getSeller() {
		return seller;
	}

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the seller to set
	 */
	public void setSeller(Boolean seller) {
		this.seller = seller;
	}
	
	//
	
	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type
	 * @return this
	 */
	public AccountFilter withType(OwnerType type) {
		this.type = type;
		return this;
	}


	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q
	 * @return this
	 */
	public AccountFilter withQ(String q) {
		this.q = q;
		return this;		
	}
	

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the seller
	 * @return this
	 */
	public AccountFilter withSeller(Boolean seller) {
		this.seller = seller;
		return this;
	}


	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 * @return this
	 */
	public AccountFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 * @return this
	 */
	public AccountFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;

	}



	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator
				.append("type", type)
				.append("q", q)
				.append("group", group)
				.append("groups", groups)
				);
	}
}
