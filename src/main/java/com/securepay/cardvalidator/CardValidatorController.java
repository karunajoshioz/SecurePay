package com.securepay.cardvalidator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.securepay.cardvalidator.bean.CardDetails;
import com.securepay.cardvalidator.bean.ResponseBean;
import com.securepay.cardvalidator.service.CardInfoService;


@RestController
@RequestMapping("/card")
public class CardValidatorController {
	
	@Autowired
	CardInfoService cardService;
	
	private static final int SUCCESS_CODE = 0;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value="/all", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CardDetails>> getAllCardInfo(){
		System.out.println("## Getting All Card Info-----");
		List<CardDetails> cardInfoList = cardService.getAllCardInfo();
		return new ResponseEntity<>(cardInfoList, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param cardNo
	 * @return
	 */
	@GetMapping(value="/number/{cardNo}/info", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CardDetails> getCardDetailsByCardNo(@PathVariable String cardNo){
		System.out.println("## Getting Specific Card Info-----");
		
		CardDetails cardDtls = null;
		if(cardNo != null && !("".equals(cardNo.trim()))){
			//check to use the first 9 digits of the card number, if not found then			
			//2.	Use the first 6 digits of the card number, if not found then			
			//3.	Set the card type and card-subtype as unknown
			
			if(cardNo.length() == 9 || cardNo.length() == 6) {
				cardDtls = cardService.getCardDetails(cardNo);
			}
			else {
				cardDtls = new CardDetails();
				cardDtls.setCardType("UNKNOWN");
				cardDtls.setCardSubType("UNKNOWN");
			}
		}
		return new ResponseEntity<>(cardDtls, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/nickname/{cardNickName}/info", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CardDetails>> getCardDetailsByNickName(@PathVariable String cardNickName){
		System.out.println("## Getting Specific Card Info-----");
		
		List<CardDetails> cardInfoList = new ArrayList<>();		
		cardInfoList = cardService.getCardDtslByParams(cardNickName, null, null);
		return new ResponseEntity<>(cardInfoList, HttpStatus.OK);
	}
	
	@GetMapping(value="/type/{cardType}/info", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CardDetails>> getCardDetailsByType(@PathVariable String cardType){
		System.out.println("## Getting Specific Card Info-----");
		
		List<CardDetails> cardInfoList = new ArrayList<>();		
		cardInfoList = cardService.getCardDtslByParams(null, cardType, null);
		return new ResponseEntity<>(cardInfoList, HttpStatus.OK);
	}
	
	@GetMapping(value="/holdernme/{cardHolderName}/info", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CardDetails>> getCardDetailsByHolderName(@PathVariable String cardHolderName){
		System.out.println("## Getting Specific Card Info-----");
		
		List<CardDetails> cardInfoList = new ArrayList<>();		
		cardInfoList = cardService.getCardDtslByParams(null, null,cardHolderName);
		return new ResponseEntity<>(cardInfoList, HttpStatus.OK);
	}
	
	
	//1 Create card
	@PostMapping(value="/create", produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseBean addCardDetails(@RequestBody CardDetails cardDtls)
	{
		ResponseBean respBean = new ResponseBean();
		int respCode = cardService.insertCardDetails(cardDtls);
		if(respCode == SUCCESS_CODE ) {
			respBean.setResponseCode("0");
			respBean.setResponseDesc("Added Successfully");
		}
		else {
			respBean.setResponseCode("1001");
			respBean.setResponseDesc("Error:- Please conatct admin ");
		}
		return respBean;
	}
	
	// update card
	@PutMapping(value="/update/{cardNo}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseBean updateCardDetails(@RequestBody CardDetails cardDtls, @PathVariable String cardNo)
	{
		ResponseBean respBean = new ResponseBean();
		int respCode = cardService.updateCardDetails(cardDtls, cardNo);
		if(respCode == SUCCESS_CODE ) {
			respBean.setResponseCode("0");
			respBean.setResponseDesc("Updated Successfully");
		}
		else {
			respBean.setResponseCode("1001");
			respBean.setResponseDesc("Error:- Please conatct admin ");
		}
		return respBean;
	}
	
	// delete card(s)
	@DeleteMapping(value="/delete/{cardNos}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseBean deleteCardNo(@PathVariable String cardNos)
	{
		ResponseBean respBean = new ResponseBean();
		int respCode = cardService.deleteCardNo(cardNos);
		if(respCode == SUCCESS_CODE ) {
			respBean.setResponseCode("0");
			respBean.setResponseDesc("Deleted Successfully");
		}
		else {
			respBean.setResponseCode("1001");
			respBean.setResponseDesc("Error:- Please conatct admin ");
		}
		return respBean;
	}
}
