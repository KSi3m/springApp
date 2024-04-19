package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.entity.Book;
import org.example.entity.User;

import java.sql.Timestamp;
import java.util.List;

public class OrderCreateRequestDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer extOrderId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp orderCreateDate;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer validityTime;
    private String description;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String additionalDescription;
    private String currencyCode;
    private String totalAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BuyerDTO buyer;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String continueUrl;
    private List<ProductDTO> products;

    public OrderCreateRequestDTO() {
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public void setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getExtOrderId() {
        return extOrderId;
    }

    public void setExtOrderId(Integer extOrderId) {
        this.extOrderId = extOrderId;
    }

    public Timestamp getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Timestamp orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public Integer getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(Integer validityTime) {
        this.validityTime = validityTime;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public BuyerDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerDTO buyer) {
        this.buyer = buyer;
    }

    public String getContinueUrl() {
        return continueUrl;
    }

    public void setContinueUrl(String continueUrl) {
        this.continueUrl = continueUrl;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
