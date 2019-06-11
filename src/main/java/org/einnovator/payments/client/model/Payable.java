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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
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

	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Payable toPayable() {
		Payable payable = new Payable();
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
