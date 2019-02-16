package com.securepay.cardvalidator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.securepay.cardvalidator.bean.CardDetails;
import com.securepay.cardvalidator.entity.TblCardInfoModel;


@Repository
@Transactional
public class CardInfoDaoImpl implements CardInfoDao{

	private static final int SUCCESS_CODE = 0;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/*public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/
	
	@Transactional
	public List<CardDetails> getAllCardInfo() {
		List<CardDetails> cardList = new ArrayList<>();
		try {
			TypedQuery<TblCardInfoModel> query = entityManager.createNamedQuery("TblCardInfoModel.findAll", TblCardInfoModel.class);
			List<TblCardInfoModel> modelList = query.getResultList();
			
			if(modelList != null && !modelList.isEmpty()) {
				for(TblCardInfoModel model : modelList) {
					CardDetails cardDtl = new CardDetails();
					
					cardDtl.setCardId(model.getId());
					cardDtl.setCardNo(model.getCardno());
					cardDtl.setCardNickName(model.getCardNickname());
					cardDtl.setCardHolderName(model.getCardHolderName());
					cardDtl.setCardType(model.getCardType());
					cardDtl.setCardSubType(model.getCardSubtype());
					
					cardList.add(cardDtl);
				}				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return cardList;
	}
	
	/**
	 * 
	 */
	@Transactional
	public CardDetails getCardDetails(String cardNo) {

		CardDetails cardDtl = new CardDetails();		
		try {
			TypedQuery<TblCardInfoModel> query = entityManager.createNamedQuery("TblCardInfoModel.findByCardno", TblCardInfoModel.class);
			query.setParameter("cardno", cardNo);
			List<TblCardInfoModel> modelList = query.getResultList();
			
			if(modelList != null && !modelList.isEmpty()) {
				for(TblCardInfoModel model : modelList) {					
					cardDtl.setCardId(model.getId());
					cardDtl.setCardNo(model.getCardno());
					cardDtl.setCardNickName(model.getCardNickname());
					cardDtl.setCardHolderName(model.getCardHolderName());
					cardDtl.setCardType(model.getCardType());
					cardDtl.setCardSubType(model.getCardSubtype());					
				}				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return cardDtl;
	}
	
	
	@Transactional
	public List<CardDetails> getCardDtslByParams(String cardNickName, String cardType, String cardHolderName)
	{
		List<CardDetails> cardList = new ArrayList<>();
		try {
			TypedQuery<TblCardInfoModel> query = null;
			
			if(cardNickName != null && !("".equals(cardNickName.trim()))) {
				query = entityManager.createNamedQuery("TblCardInfoModel.findByCardNickname", TblCardInfoModel.class);
				query.setParameter("cardNickname", cardNickName);
			}
			else if(cardType != null && !("".equals(cardType.trim()))) {
				query = entityManager.createNamedQuery("TblCardInfoModel.findByCardType", TblCardInfoModel.class);
				query.setParameter("cardType", cardType);
			} 			
			else if(cardHolderName != null && !("".equals(cardHolderName.trim()))) {
				query = entityManager.createNamedQuery("TblCardInfoModel.findByCardHolderName", TblCardInfoModel.class);
				query.setParameter("cardHolderName", cardHolderName);
			} 
				
			List<TblCardInfoModel> modelList = query.getResultList();
			
			if(modelList != null && !modelList.isEmpty()) {
				for(TblCardInfoModel model : modelList) {		
					CardDetails cardDtl = new CardDetails();
					
					cardDtl.setCardId(model.getId());
					cardDtl.setCardNo(model.getCardno());
					cardDtl.setCardNickName(model.getCardNickname());
					cardDtl.setCardHolderName(model.getCardHolderName());
					cardDtl.setCardType(model.getCardType());
					cardDtl.setCardSubType(model.getCardSubtype());		
					
					cardList.add(cardDtl);
				}				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return cardList;
	}
	
	/**
	 * 
	 */
	@Transactional(rollbackFor = Exception.class)
	public int insertCardDetails(CardDetails cardDtls) {
		TblCardInfoModel cardModel = new TblCardInfoModel();
		cardModel.setCardHolderName(cardDtls.getCardHolderName());
		cardModel.setCardno(cardDtls.getCardNo());
		cardModel.setCardNickname(cardDtls.getCardNickName());
		cardModel.setCardSubtype(cardDtls.getCardSubType());
		cardModel.setCardType(cardDtls.getCardType());
		entityManager.persist(cardModel);
		return SUCCESS_CODE;
	}

	/**
	 * 
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateCardDetails(CardDetails cardDtls, String cardNo) {
		
		TypedQuery<TblCardInfoModel> query = entityManager.createNamedQuery("TblCardInfoModel.findByCardno", TblCardInfoModel.class);
		query.setParameter("cardno", cardNo);
		List<TblCardInfoModel> modelList = query.getResultList();
		
		if(modelList != null && !modelList.isEmpty()) {
			for(TblCardInfoModel model: modelList) {			
				model.setCardHolderName(cardDtls.getCardHolderName());
				model.setCardno(cardNo);
				model.setCardNickname(cardDtls.getCardNickName());
				model.setCardSubtype(cardDtls.getCardSubType());
				model.setCardType(cardDtls.getCardType());		
				entityManager.merge(model);		
			}
		}
		return SUCCESS_CODE;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteCardNo(String cardNos) {		
		String[] cardNoArr = cardNos.split(",");
		List<String>  cardNoList = new ArrayList<>();
		for(String card: cardNoArr) {
			cardNoList.add(card.trim());
		}
		
		Query query = entityManager.createNamedQuery("TblCardInfoModel.deleteCardNos");
		query.setParameter("cardNos", cardNoList);
		query.executeUpdate();
		return SUCCESS_CODE;
	}

}
