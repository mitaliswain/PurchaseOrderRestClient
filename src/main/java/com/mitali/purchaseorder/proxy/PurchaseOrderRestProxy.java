package com.mitali.purchaseorder.proxy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.mitali.purchaseorder.proxy.domain.GetPurchaseOrderResponse;
import com.mitali.purchaseorder.proxy.domain.PostPurchaseOrderRequest;
import com.mitali.purchaseorder.proxy.domain.PostPurchaseOrderResponse;
import com.mitali.purchaseorder.proxy.domain.Sku;
import com.mitali.purchaseorder.proxy.domain.SkuQuantity;


@Component
public class PurchaseOrderRestProxy {
	
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderRestProxy.class);

	@Bean
	public GetPurchaseOrderResponse getPOService() {
		
		RestTemplate restTemplate = new RestTemplate();
		
	
		HttpHeaders headers = new HttpHeaders();
		headers.set("apigee-signature", "123456789012");
		
		String url ="http://localhost:8083/pms/purchase-order/31";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		try {
		ResponseEntity<GetPurchaseOrderResponse> getPurchaseOrderResponse = restTemplate.exchange(
		    url, HttpMethod.GET, entity, GetPurchaseOrderResponse.class);
		log.info(getPurchaseOrderResponse.toString());
		return getPurchaseOrderResponse.getBody();
		
		} catch(HttpClientErrorException e) {
			log.error(" Something went wrong check "+ e.getMessage() );
		} catch (HttpServerErrorException e) {
			log.error(" Something went wrong in target machine "+ e.getMessage() );
		}
	
		return null;
		
	}
	
	
	@Bean
	public PostPurchaseOrderResponse addPOService() {
		

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("apigee-signature", "123456789012");
		
		String url ="http://localhost:8083/pms/purchase-order/";

		 
		PostPurchaseOrderRequest postPurchaseOrderRequest = new PostPurchaseOrderRequest();
		

	
		postPurchaseOrderRequest.setBrandId("1");
		postPurchaseOrderRequest.setMarketId("1x");
		postPurchaseOrderRequest.setStyleId("1");
		postPurchaseOrderRequest.setProductHierarchyId("1");
		postPurchaseOrderRequest.setVendorId("1");
		postPurchaseOrderRequest.setOrderType("INITIAL");
		postPurchaseOrderRequest.setShipmentMethod("AIR");
		postPurchaseOrderRequest.setSeasonId("1");
		postPurchaseOrderRequest.setWarehouseId("1");
		postPurchaseOrderRequest.setGarmentType("1");
		postPurchaseOrderRequest.setTicketId("1");
				
		
		postPurchaseOrderRequest.setAgent("1");
		postPurchaseOrderRequest.setInWarehouseDate("444");
		postPurchaseOrderRequest.setBulkPackFactor("333");
		postPurchaseOrderRequest.setFreightPaidBy("1");
		postPurchaseOrderRequest.setTermOfSale("xx");
		postPurchaseOrderRequest.setFreightNames("xyz");
		postPurchaseOrderRequest.setOrderComment("xyx");
		postPurchaseOrderRequest.setEarliestShippingDate("444");
		postPurchaseOrderRequest.setLatestShippingDate("44");
		postPurchaseOrderRequest.setEarliestCancelDate("444");
		postPurchaseOrderRequest.setPaymentTerms("ss");
		postPurchaseOrderRequest.setPlannedReceiptMonth("ddd");
		postPurchaseOrderRequest.setReceiptWeek("22");
		postPurchaseOrderRequest.setTransferPointCode("234x");
		postPurchaseOrderRequest.setOrigin("ahh");
		List<SkuQuantity> skuQuantities = new ArrayList<>();
		Sku sku =new Sku();
		sku.setNumber("123");
		SkuQuantity skuQuantity =new SkuQuantity();
		skuQuantity.setSku(sku);
		skuQuantity.setQuantity(23);
		skuQuantities.add(skuQuantity);
		postPurchaseOrderRequest.setSkuQuantitties((skuQuantities));
		
		log.info(postPurchaseOrderRequest.toString());
		try {
			HttpEntity<PostPurchaseOrderRequest> entity = new HttpEntity<>(postPurchaseOrderRequest, headers);

			ResponseEntity<PostPurchaseOrderResponse> postPurchaseOrderResponse = restTemplate.exchange(
					url,HttpMethod.POST, entity, PostPurchaseOrderResponse.class);
			log.info(postPurchaseOrderResponse.toString());
			
			return postPurchaseOrderResponse.getBody();
		} catch(HttpClientErrorException e) {
			log.error(" Something went wrong check "+ e.getMessage() );
		} catch (HttpServerErrorException e) {
			log.error(" Something went wrong in target machine "+ e.getMessage() );
		}
		return null;
		
	}
	
	
}
