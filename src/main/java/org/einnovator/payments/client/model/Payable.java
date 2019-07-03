package org.einnovator.payments.client.model;

import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payable extends EntityBase {

	private String name;

	private String category;

	private String description;
	
	private String img;
	
	private String nameCss;
	
	private String categoryCss;
	
	private String imgCss;

	private String descriptionCss;
	
	private List<Item> items;

	
	public Payable() {
	}
	
	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code category}.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the value of property {@code img}.
	 *
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * Get the value of property {@code nameCss}.
	 *
	 * @return the nameCss
	 */
	public String getNameCss() {
		return nameCss;
	}

	/**
	 * Set the value of property {@code nameCss}.
	 *
	 * @param nameCss the nameCss to set
	 */
	public void setNameCss(String nameCss) {
		this.nameCss = nameCss;
	}

	/**
	 * Get the value of property {@code categoryCss}.
	 *
	 * @return the categoryCss
	 */
	public String getCategoryCss() {
		return categoryCss;
	}

	/**
	 * Set the value of property {@code categoryCss}.
	 *
	 * @param categoryCss the categoryCss to set
	 */
	public void setCategoryCss(String categoryCss) {
		this.categoryCss = categoryCss;
	}

	/**
	 * Get the value of property {@code imgCss}.
	 *
	 * @return the imgCss
	 */
	public String getImgCss() {
		return imgCss;
	}

	/**
	 * Set the value of property {@code imgCss}.
	 *
	 * @param imgCss the imgCss to set
	 */
	public void setImgCss(String imgCss) {
		this.imgCss = imgCss;
	}

	/**
	 * Get the value of property {@code descriptionCss}.
	 *
	 * @return the descriptionCss
	 */
	public String getDescriptionCss() {
		return descriptionCss;
	}

	/**
	 * Set the value of property {@code descriptionCss}.
	 *
	 * @param descriptionCss the descriptionCss to set
	 */
	public void setDescriptionCss(String descriptionCss) {
		this.descriptionCss = descriptionCss;
	}

	/**
	 * Get the value of property {@code items}.
	 *
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Set the value of property {@code items}.
	 *
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Payable toPayable() {
		Payable payable = new Payable();
		payable.setUuid(uuid);
		payable.setName(name);
		payable.setCategory(category);
		payable.setDescription(description);
		payable.setImg(img);
		payable.setNameCss(nameCss);
		payable.setCategoryCss(categoryCss);
		payable.setDescriptionCss(descriptionCss);
		payable.setNameCss(nameCss);
		payable.setItems(items);
		return payable;
	}
	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("category", category)
				.append("description", description)
				.append("img", img)
				.append("nameCss", nameCss)
				.append("categoryCss", categoryCss)
				.append("imgCss", imgCss)
				.append("descriptionCss", descriptionCss)
				.append("items", items)
				;
	}
	
}
