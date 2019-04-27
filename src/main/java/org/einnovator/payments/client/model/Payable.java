package org.einnovator.payments.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payable {

	private String name;

	private String category;

	private String description;
	
	private String imgUri;
	
	private String nameCss;
	
	private String categoryCss;
	
	private String imgCss;

	private String descriptionCss;
	
	private List<Item> lineItems;

	
	public Payable() {
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgUri() {
		return imgUri;
	}


	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}


	public String getNameCss() {
		return nameCss;
	}


	public void setNameCss(String nameCss) {
		this.nameCss = nameCss;
	}


	public String getCategoryCss() {
		return categoryCss;
	}


	public void setCategoryCss(String categoryCss) {
		this.categoryCss = categoryCss;
	}


	public String getImgCss() {
		return imgCss;
	}


	public void setImgCss(String imgCss) {
		this.imgCss = imgCss;
	}


	public String getDescriptionCss() {
		return descriptionCss;
	}


	public void setDescriptionCss(String descriptionCss) {
		this.descriptionCss = descriptionCss;
	}

	public List<Item> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<Item> lineItems) {
		this.lineItems = lineItems;
	}


	public Payable toPayable() {
		Payable payable = new Payable();
		payable.setName(name);
		payable.setCategory(category);
		payable.setDescription(description);
		payable.setImgUri(imgUri);
		payable.setNameCss(nameCss);
		payable.setCategoryCss(categoryCss);
		payable.setDescriptionCss(descriptionCss);
		payable.setNameCss(nameCss);
		payable.setLineItems(lineItems);
		return payable;
	}
	
	@Override
	public String toString() {
		return "Payable [" + (name != null ? "name=" + name + ", " : "") + (category != null ? "category=" + category + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + (imgUri != null ? "imgUri=" + imgUri + ", " : "")
				+ (nameCss != null ? "nameCss=" + nameCss + ", " : "") + (categoryCss != null ? "categoryCss=" + categoryCss + ", " : "")
				+ (imgCss != null ? "imgCss=" + imgCss + ", " : "") + (descriptionCss != null ? "descriptionCss=" + descriptionCss + ", " : "")
				+ (lineItems != null ? "lineItems=" + lineItems : "") + "]";
	}
	
	
	
}
