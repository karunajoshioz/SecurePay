package com.securepay.cardvalidator.service;

import java.util.List;


import com.securepay.cardvalidator.bean.CardDetails;


public interface CardInfoService {
	
	public List<CardDetails> getAllCardInfo();
	
	public CardDetails getCardDetails(String cardNo);
	
	public List<CardDetails> getCardDtslByParams(String cardNickName, String cardType, String cardHolderName);
	
	public int insertCardDetails(CardDetails cardDtls);
	public int updateCardDetails(CardDetails cardDtls, String cardNo);
	
	public int deleteCardNo(String cardNos);

}
