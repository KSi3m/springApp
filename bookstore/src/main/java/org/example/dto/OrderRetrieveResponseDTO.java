package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class OrderRetrieveResponseDTO {


    @JsonProperty("order")
    public Order order;

    @JsonProperty("localReceiptDateTime")
    public String localReceiptDateTime;

    @JsonProperty("properties")
    public List<Properties> properties;

    public static class Properties
    {
        @JsonProperty("name")
        public String name;

        @JsonProperty("value")
        public String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    public static class Order
    {
        @JsonProperty("orderId")
        public String orderId;
        @JsonProperty("status")
        public String status;
        @JsonProperty("orderCreateDate")
        public String orderCreateDate;
        @JsonProperty("notifyUrl")
        public String notifyUrl;
        @JsonProperty("customerIp")
        public String customerIp;
        @JsonProperty("merchantPosId")
        public String merchantPosId;
        @JsonProperty("description")
        public String description;
        @JsonProperty("currencyCode")
        public String currencyCode;
        @JsonProperty("totalAmount")
        public String totalAmount;

        @JsonProperty("buyer")
        public Buyer buyer;

        public static class Buyer{

            @JsonProperty("customerId")
            public String customerId;

            @JsonProperty("email")
            public String email;

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
        @JsonProperty("payMethod")
        public payMethod payMethod;
        public static class payMethod{
            @JsonProperty("amount")
            public String amount;

            @JsonProperty("type")
            public String type;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

        }

        @JsonProperty("products")
        public List<ProductDTO> products;

        public List<ProductDTO> getProducts() {
            return products;
        }

        public void setProducts(List<ProductDTO> products) {
            this.products = products;
        }

        public Order.payMethod getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(Order.payMethod payMethod) {
            this.payMethod = payMethod;
        }

        public String getOrderCreateDate() {
            return orderCreateDate;
        }

        public void setOrderCreateDate(String orderCreateDate) {
            this.orderCreateDate = orderCreateDate;
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

        public Buyer getBuyer() {
            return buyer;
        }

        public void setBuyer(Buyer buyer) {
            this.buyer = buyer;
        }



        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        @Override
        public String toString() {
            return "OrderJSON{" +
                    "status='" + status + '\'' +
                    ", orderId='" + orderId + '\'' +
                    '}';
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getLocalReceiptDateTime() {
        return localReceiptDateTime;
    }

    public void setLocalReceiptDateTime(String localReceiptDateTime) {
        this.localReceiptDateTime = localReceiptDateTime;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }
}


