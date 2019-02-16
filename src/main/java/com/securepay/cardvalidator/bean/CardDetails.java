package com.securepay.cardvalidator.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class CardDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cardType;
	private String cardSubType;
	private String cardNo;
	private String cardNickName;		
	private String cardHolderName;
	private Long cardId;
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardSubType() {
		return cardSubType;
	}
	public void setCardSubType(String cardSubType) {
		this.cardSubType = cardSubType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardNickName() {
		return cardNickName;
	}
	public void setCardNickName(String cardNickName) {
		this.cardNickName = cardNickName;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	
	
	
	

}
