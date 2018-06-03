package com.bharath.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;

import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWsClient_Create {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		CreateOrdersRequest request = new CreateOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		
		Order order= new Order();
		order.setId(BigInteger.valueOf(10));
		
		Product product= new Product();
		product.setId("5");
		product.setDescription("MacBook");
		product.setQuantity(BigInteger.valueOf(6));
	
		order.getProduct().add(product);

		request.setOrder(order);
		
		CreateOrdersResponse response = customerOrdersWsImplPort.createOrders(request);
		
		System.out.println("Result is : "+ response.isResult());
		
	}

}