package com.securepay.cardvalidator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepay.cardvalidator.bean.CardDetails;
import com.securepay.cardvalidator.dao.CardInfoDao;

@Service
public class CardInfoServiceImpl implements CardInfoService{

	@Autowired
	CardInfoDao cardDAO;
	
	@Override
	public List<CardDetails> getAllCardInfo() {
		return cardDAO.getAllCardInfo();
	}
	
	
	public CardDetails getCardDetails(String cardNo) {
		return cardDAO.getCardDetails(cardNo);
	}

	public List<CardDetails> getCardDtslByParams(String cardNickName, String cardType, String cardHolderName){
		return cardDAO.getCardDtslByParams(cardNickName, cardType, cardHolderName);
	}
	
	public int insertCardDetails(CardDetails cardDtls) {
		return cardDAO.insertCardDetails(cardDtls);
	}
	
	public int updateCardDetails(CardDetails cardDtls, String cardNo) {
		return cardDAO.updateCardDetails(cardDtls,cardNo);
	}
	
	public int deleteCardNo(String cardNos) {
		return cardDAO.deleteCardNo(cardNos);
	}
}
