package org.einnovator.payments.client.model;

import java.math.BigDecimal;

public class ItemBuilder {

	private String name;

	private Integer numberOfUnits;

	private Integer numberOfUnits2;

	private BigDecimal amountPerUnit;

	private BigDecimal totalAmount;

	private String comment;

	private String img;

	private String tag;

	private String tag2;

	private String tag2icon;
	
	private BigDecimal refundAmount;

	public ItemBuilder() {
	}

	public ItemBuilder name(String name) {
		this.name = name;
		return this;
	}

	public ItemBuilder numberOfUnits(Integer numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
		return this;
	}

	public ItemBuilder numberOfUnits2(Integer numberOfUnits2) {
		this.numberOfUnits2 = numberOfUnits2;
		return this;
	}

	public ItemBuilder amountPerUnit(BigDecimal amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
		return this;
	}

	public ItemBuilder totalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public ItemBuilder comment(String comment) {
		this.comment = comment;
		return this;
	}

	public ItemBuilder img(String img) {
		this.img = img;
		return this;
	}
	
	public ItemBuilder tag(String tag) {
		this.tag = tag;
		return this;
	}

	public ItemBuilder tag2(String tag2) {
		this.tag2 = tag2;
		return this;
	}

	public ItemBuilder tag2icon(String tag2icon) {
		this.tag2icon = tag2icon;
		return this;
	}

	public ItemBuilder refundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
		return this;
	}

	public Item build() {
		Item item = new Item();
		item.setName(name);
		item.setNumberOfUnits(numberOfUnits);
		item.setNumberOfUnits2(numberOfUnits2);
		item.setAmountPerUnit(amountPerUnit);
		item.setTotalAmount(totalAmount);
		item.setComment(comment);
		item.setImg(img);
		item.setTag(tag);
		item.setTag(tag2);
		item.setTag(tag2icon);
		item.setRefundAmount(refundAmount);
		return item;
	}

}
