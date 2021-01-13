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
	 * @param name the name
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
	 * @param category the category
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
	 * @param description the description
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
	 * @param img the img
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
	 * @param nameCss the nameCss
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
	 * @param categoryCss the categoryCss
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
	 * @param imgCss the imgCss
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
	 * @param descriptionCss the descriptionCss
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
	 * @param items the items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of property name
	 * @return this {@code Payable}
	 */
	public Payable withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
	 * @return this {@code Payable}
	 */
	public Payable withCategory(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the value of property description
	 * @return this {@code Payable}
	 */
	public Payable withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the value of property img
	 * @return this {@code Payable}
	 */
	public Payable withImg(String img) {
		this.img = img;
		return this;
	}

	/**
	 * Set the value of property {@code nameCss}.
	 *
	 * @param nameCss the value of property nameCss
	 * @return this {@code Payable}
	 */
	public Payable withNameCss(String nameCss) {
		this.nameCss = nameCss;
		return this;
	}

	/**
	 * Set the value of property {@code categoryCss}.
	 *
	 * @param categoryCss the value of property categoryCss
	 * @return this {@code Payable}
	 */
	public Payable withCategoryCss(String categoryCss) {
		this.categoryCss = categoryCss;
		return this;
	}

	/**
	 * Set the value of property {@code imgCss}.
	 *
	 * @param imgCss the value of property imgCss
	 * @return this {@code Payable}
	 */
	public Payable withImgCss(String imgCss) {
		this.imgCss = imgCss;
		return this;
	}

	/**
	 * Set the value of property {@code descriptionCss}.
	 *
	 * @param descriptionCss the value of property descriptionCss
	 * @return this {@code Payable}
	 */
	public Payable withDescriptionCss(String descriptionCss) {
		this.descriptionCss = descriptionCss;
		return this;
	}

	/**
	 * Set the value of property {@code items}.
	 *
	 * @param items the value of property items
	 * @return this {@code Payable}
	 */
	public Payable withItems(List<Item> items) {
		this.items = items;
		return this;
	}

	public Payable toPayable() {
		Payable payable = new Payable();
		payable.withUuid(uuid);
		payable.withName(name);
		payable.withCategory(category);
		payable.withDescription(description);
		payable.withImg(img);
		payable.withNameCss(nameCss);
		payable.withCategoryCss(categoryCss);
		payable.withDescriptionCss(descriptionCss);
		payable.withNameCss(nameCss);
		payable.withItems(items);
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
