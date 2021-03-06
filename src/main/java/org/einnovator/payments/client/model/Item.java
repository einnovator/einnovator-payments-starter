package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item extends EntityBase {

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
	
	private List<Fee> fees;
	
	private BigDecimal refundAmount;

	public Item() {
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
	 * Get the value of property {@code numberOfUnits}.
	 *
	 * @return the numberOfUnits
	 */
	public Integer getNumberOfUnits() {
		return numberOfUnits;
	}

	/**
	 * Set the value of property {@code numberOfUnits}.
	 *
	 * @param numberOfUnits the numberOfUnits
	 */
	public void setNumberOfUnits(Integer numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	/**
	 * Get the value of property {@code numberOfUnits2}.
	 *
	 * @return the numberOfUnits2
	 */
	public Integer getNumberOfUnits2() {
		return numberOfUnits2;
	}

	/**
	 * Set the value of property {@code numberOfUnits2}.
	 *
	 * @param numberOfUnits2 the numberOfUnits2
	 */
	public void setNumberOfUnits2(Integer numberOfUnits2) {
		this.numberOfUnits2 = numberOfUnits2;
	}

	/**
	 * Get the value of property {@code amountPerUnit}.
	 *
	 * @return the amountPerUnit
	 */
	public BigDecimal getAmountPerUnit() {
		return amountPerUnit;
	}

	/**
	 * Set the value of property {@code amountPerUnit}.
	 *
	 * @param amountPerUnit the amountPerUnit
	 */
	public void setAmountPerUnit(BigDecimal amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
	}

	/**
	 * Get the value of property {@code totalAmount}.
	 *
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set the value of property {@code totalAmount}.
	 *
	 * @param totalAmount the totalAmount
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Get the value of property {@code comment}.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Set the value of property {@code comment}.
	 *
	 * @param comment the comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * Get the value of property {@code tag}.
	 *
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Get the value of property {@code tag2}.
	 *
	 * @return the tag2
	 */
	public String getTag2() {
		return tag2;
	}

	/**
	 * Set the value of property {@code tag2}.
	 *
	 * @param tag2 the tag2
	 */
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	/**
	 * Get the value of property {@code tag2icon}.
	 *
	 * @return the tag2icon
	 */
	public String getTag2icon() {
		return tag2icon;
	}

	/**
	 * Set the value of property {@code tag2icon}.
	 *
	 * @param tag2icon the tag2icon
	 */
	public void setTag2icon(String tag2icon) {
		this.tag2icon = tag2icon;
	}

	/**
	 * Get the value of property {@code fees}.
	 *
	 * @return the fees
	 */
	public List<Fee> getFees() {
		return fees;
	}

	/**
	 * Set the value of property {@code fees}.
	 *
	 * @param fees the fees
	 */
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	/**
	 * Get the value of property {@code refundAmount}.
	 *
	 * @return the refundAmount
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	/**
	 * Set the value of property {@code refundAmount}.
	 *
	 * @param refundAmount the refundAmount
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of property name
	 * @return this {@code Item}
	 */
	public Item withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code numberOfUnits}.
	 *
	 * @param numberOfUnits the value of property numberOfUnits
	 * @return this {@code Item}
	 */
	public Item withNumberOfUnits(Integer numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
		return this;
	}

	/**
	 * Set the value of property {@code numberOfUnits2}.
	 *
	 * @param numberOfUnits2 the value of property numberOfUnits2
	 * @return this {@code Item}
	 */
	public Item withNumberOfUnits2(Integer numberOfUnits2) {
		this.numberOfUnits2 = numberOfUnits2;
		return this;
	}

	/**
	 * Set the value of property {@code amountPerUnit}.
	 *
	 * @param amountPerUnit the value of property amountPerUnit
	 * @return this {@code Item}
	 */
	public Item withAmountPerUnit(BigDecimal amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
		return this;
	}

	/**
	 * Set the value of property {@code totalAmount}.
	 *
	 * @param totalAmount the value of property totalAmount
	 * @return this {@code Item}
	 */
	public Item withTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	/**
	 * Set the value of property {@code comment}.
	 *
	 * @param comment the value of property comment
	 * @return this {@code Item}
	 */
	public Item withComment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the value of property img
	 * @return this {@code Item}
	 */
	public Item withImg(String img) {
		this.img = img;
		return this;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the value of property tag
	 * @return this {@code Item}
	 */
	public Item withTag(String tag) {
		this.tag = tag;
		return this;
	}

	/**
	 * Set the value of property {@code tag2}.
	 *
	 * @param tag2 the value of property tag2
	 * @return this {@code Item}
	 */
	public Item withTag2(String tag2) {
		this.tag2 = tag2;
		return this;
	}

	/**
	 * Set the value of property {@code tag2icon}.
	 *
	 * @param tag2icon the value of property tag2icon
	 * @return this {@code Item}
	 */
	public Item withTag2icon(String tag2icon) {
		this.tag2icon = tag2icon;
		return this;
	}

	/**
	 * Set the value of property {@code fees}.
	 *
	 * @param fees the value of property fees
	 * @return this {@code Item}
	 */
	public Item withFees(List<Fee> fees) {
		this.fees = fees;
		return this;
	}

	/**
	 * Set the value of property {@code refundAmount}.
	 *
	 * @param refundAmount the value of property refundAmount
	 * @return this {@code Item}
	 */
	public Item withRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
		return this;
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
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("numberOfUnits", numberOfUnits)
				.append("numberOfUnits2", numberOfUnits2)
				.append("amountPerUnit", amountPerUnit)
				.append("totalAmount", totalAmount)
				.append("refundAmount", refundAmount)
				.append("img", img)				
				.append("tag", tag)
				.append("tag2", tag2)
				.append("comment", comment)
				;
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
