package com.mitali.purchaseorder.proxy.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetPurchaseOrderResponse {

	String id;
	Brand brand;
	Market market;
	List<SkuQuantity> skuQuantities;
	String status;
}






