package org.einnovator.payments.client.model;

public class PayableBuilder {


	private String id;

	private String uuid;

	private String name;

	private String category;

	private String description;
	
	private String img;
	
	private String nameCss;
	
	private String categoryCss;
	
	private String imgCss;

	private String descriptionCss;

	
	public PayableBuilder() {
	}

	public PayableBuilder id(String id) {
		this.id = id;
		return this;
	}
	
	public PayableBuilder uuid(String uuid) {
		this.uuid = uuid;
		return this;
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

	public PayableBuilder img(String img) {
		this.img = img;
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
		payable.setImg(img);
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
				+ (img != null ? "img=" + img + ", " : "")
				+ (nameCss != null ? "nameCss=" + nameCss + ", " : "")
				+ (categoryCss != null ? "categoryCss=" + categoryCss + ", " : "")
				+ (imgCss != null ? "imgCss=" + imgCss + ", " : "")
				+ (descriptionCss != null ? "descriptionCss=" + descriptionCss : "") + "]";
	}
	
	
	
}
