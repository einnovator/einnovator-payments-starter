package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String name;

	private Integer numberOfUnits;

	private Integer numberOfUnits2;

	private BigDecimal amountPerUnit;

	private BigDecimal totalAmount;

	private String comment;

	private String tag;

	private String tag2;

	private String tag2icon;
	
	private List<Fee> fees;
	
	private Fee refund;

	public Item() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(Integer numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public BigDecimal getAmountPerUnit() {
		return amountPerUnit;
	}

	public void setAmountPerUnit(BigDecimal amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
	}

	public Integer getNumberOfUnits2() {
		return numberOfUnits2;
	}

	public void setNumberOfUnits2(Integer numberOfUnits2) {
		this.numberOfUnits2 = numberOfUnits2;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag2icon() {
		return tag2icon;
	}

	public void setTag2icon(String tag2icon) {
		this.tag2icon = tag2icon;
	}

	public List<Fee> getFee() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Fee getRefund() {
		return refund;
	}

	public void setRefund(Fee refund) {
		this.refund = refund;
	}

	public BigDecimal update() {
		if (amountPerUnit == null || numberOfUnits == null) {
			totalAmount = null;
		} else {
			totalAmount = amountPerUnit.multiply(new BigDecimal(numberOfUnits));
		}
		if (totalAmount != null && numberOfUnits2 != null) {
			totalAmount = totalAmount.multiply(new BigDecimal(numberOfUnits2));
		}
		return totalAmount;
	}

	@Override
	public String toString() {
		return "Item [" + (name != null ? "name=" + name + ", " : "") + (numberOfUnits != null ? "numberOfUnits=" + numberOfUnits + ", " : "")
				+ (numberOfUnits2 != null ? "numberOfUnits2=" + numberOfUnits2 + ", " : "") + (amountPerUnit != null ? "amountPerUnit=" + amountPerUnit + ", " : "")
				+ (totalAmount != null ? "totalAmount=" + totalAmount + ", " : "") + (comment != null ? "comment=" + comment + ", " : "") + (tag != null ? "tag=" + tag + ", " : "")
				+ (tag2 != null ? "tag2=" + tag2 + ", " : "") + (tag2icon != null ? "tag2icon=" + tag2icon + ", " : "") + (fees != null ? "fees=" + fees + ", " : "")
				+ (refund != null ? "refund=" + refund : "") + "]";
	}

	public static BigDecimal add(Item... items) {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : items) {
			BigDecimal partial = item.update();
			if (partial != null) {
				total = total.add(partial);
			}
		}
		total = total.setScale(2, RoundingMode.HALF_UP);
		return total;
	}

	public static BigDecimal add(List<Item> items) {
		return add(items.toArray(new Item[items.size()]));
	}

	public static String formatSum(Item... items) {
		BigDecimal total = add(items);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		sb.append(total);
		sb.append(" = ");
		for (Item item : items) {
			BigDecimal partial = item.update();
			if (partial != null) {
				if (!first) {
					sb.append(" + ");
				} else {
					first = false;
				}
				sb.append(partial);
			}
		}
		return sb.toString();
	}

	public static String formatSum(List<Item> items) {
		return formatSum(items.toArray(new Item[items.size()]));
	}

}
