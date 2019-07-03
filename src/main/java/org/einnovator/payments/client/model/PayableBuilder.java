package org.einnovator.payments.client.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PayableBuilder {

	private String uuid;

	private String name;

	private String category;

	private String description;
	
	private String img;
	
	private String nameCss;
	
	private String categoryCss;
	
	private String imgCss;

	private String descriptionCss;

	private List<Item> items;

	public PayableBuilder() {
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
	
	public PayableBuilder items(List<Item> items) {
		this.items = items;
		return this;
	}
	
	public PayableBuilder items(Item... items) {
		if (this.items==null) {
			this.items = new ArrayList<>();
		}
		this.items.addAll(Arrays.asList(items));
		return this;
	}

	public Payable build() {
		Payable payable = new Payable();
		payable.setUuid(uuid);		
		payable.setName(name);
		payable.setCategory(category);
		payable.setDescription(description);
		payable.setImg(img);
		payable.setImgCss(imgCss);
		payable.setNameCss(nameCss);
		payable.setCategoryCss(categoryCss);
		payable.setDescriptionCss(descriptionCss);
		payable.setNameCss(nameCss);
		payable.setItems(items);
		return payable;
	}
	

	
	
}
