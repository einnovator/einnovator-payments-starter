package org.einnovator.payments.client.model;

public class PayableBuilder {

	private String name;

	private String category;

	private String description;
	
	private String imgUri;
	
	private String nameCss;
	
	private String categoryCss;
	
	private String imgCss;

	private String descriptionCss;

	
	public PayableBuilder() {
	}

	public PayableBuilder name(String name) {
		this.name = name;
		return this;
	}

	public PayableBuilder category(String category) {
		this.category = category;
		return this;
	}

	public PayableBuilder description(String description) {
		this.description = description;
		return this;
	}

	public PayableBuilder imgUri(String imgUri) {
		this.imgUri = imgUri;
		return this;
	}

	public PayableBuilder nameCss(String nameCss) {
		this.nameCss = nameCss;
		return this;
	}

	public PayableBuilder categoryCss(String categoryCss) {
		this.categoryCss = categoryCss;	
		return this;
	}

	public PayableBuilder imgCss(String imgCss) {
		this.imgCss = imgCss;
		return this;
	}

	public PayableBuilder descriptionCss(String descriptionCss) {
		this.descriptionCss = descriptionCss;
		return this;
	}

	public Payable build() {
		Payable payable = new Payable();
		payable.setName(name);
		payable.setCategory(category);
		payable.setDescription(description);
		payable.setImgUri(imgUri);
		payable.setNameCss(nameCss);
		payable.setCategoryCss(categoryCss);
		payable.setDescriptionCss(descriptionCss);
		payable.setNameCss(nameCss);
		return payable;
	}
	
	@Override
	public String toString() {
		return "Payable [" + (name != null ? "name=" + name + ", " : "")
				+ (category != null ? "category=" + category + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (imgUri != null ? "imgUri=" + imgUri + ", " : "")
				+ (nameCss != null ? "nameCss=" + nameCss + ", " : "")
				+ (categoryCss != null ? "categoryCss=" + categoryCss + ", " : "")
				+ (imgCss != null ? "imgCss=" + imgCss + ", " : "")
				+ (descriptionCss != null ? "descriptionCss=" + descriptionCss : "") + "]";
	}
	
	
	
}
