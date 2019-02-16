package com.securepay.cardvalidator.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author karuna
 */
@Entity(name="TblCardInfoModel")
@Table(name = "tbl_card_info", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCardInfoModel.findAll", query = "SELECT t FROM TblCardInfoModel t")
    , @NamedQuery(name = "TblCardInfoModel.findById", query = "SELECT t FROM TblCardInfoModel t WHERE t.id = :id")
    , @NamedQuery(name = "TblCardInfoModel.findByCardno", query = "SELECT t FROM TblCardInfoModel t WHERE t.cardno = :cardno")
    , @NamedQuery(name = "TblCardInfoModel.findByCardNickname", query = "SELECT t FROM TblCardInfoModel t WHERE t.cardNickname = :cardNickname")
    , @NamedQuery(name = "TblCardInfoModel.findByCardType", query = "SELECT t FROM TblCardInfoModel t WHERE t.cardType = :cardType")
    , @NamedQuery(name = "TblCardInfoModel.findByCardSubtype", query = "SELECT t FROM TblCardInfoModel t WHERE t.cardSubtype = :cardSubtype")
    , @NamedQuery(name = "TblCardInfoModel.findByCardHolderName", query = "SELECT t FROM TblCardInfoModel t WHERE t.cardHolderName = :cardHolderName")
    , @NamedQuery(name = "TblCardInfoModel.deleteCardNos", query = "DELETE  FROM TblCardInfoModel t WHERE t.cardno IN (:cardNos)")})

public class TblCardInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "cardno")
    private String cardno;
    
    @Column(name = "card_nickname")
    private String cardNickname;
    
    @Column(name = "card_type")
    private String cardType;
    
    @Column(name = "card_subtype")
    private String cardSubtype;
    
    @Column(name = "card_holder_name")
    private String cardHolderName;

    public TblCardInfoModel() {
    }

    public TblCardInfoModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardNickname() {
        return cardNickname;
    }

    public void setCardNickname(String cardNickname) {
        this.cardNickname = cardNickname;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardSubtype() {
        return cardSubtype;
    }

    public void setCardSubtype(String cardSubtype) {
        this.cardSubtype = cardSubtype;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCardInfoModel)) {
            return false;
        }
        TblCardInfoModel other = (TblCardInfoModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TblCardInfoModel[ id=" + id + " ]";
    }
    
}
