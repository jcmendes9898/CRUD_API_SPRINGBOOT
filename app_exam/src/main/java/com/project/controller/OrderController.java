package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.ResourceNotFoundException;
import com.project.model.Order;
import com.project.model.OrderDetail;
import com.project.model.ProductOrder;
import com.project.repository.OrderRepository;
import com.project.repository.ProdOrderRepository;

@CrossOrigin
@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProdOrderRepository prodOrderRepository;

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@PostMapping("/createOrder")
	public Order createOrder(@Validated @RequestBody OrderDetail orderD) {

		Order order = new Order(orderD.getEmail(), orderD.getTotal());
		long id = order.getId(); // relacionar tabela ProdOrders com Orders
		orderRepository.save(order);
		List<ProductOrder> prodOrderList = new ArrayList<ProductOrder>();

		orderD.getProducts().forEach(prod -> {
			ProductOrder prodOrder = new ProductOrder(id, prod.getId_p(), prod.getName(), prod.getPrice(),
					prod.getQuantity());
			prodOrderList.add(prodOrder);
			prodOrderRepository.save(prodOrder);
		});
		order.setProducts(prodOrderList);
		return order;
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
		orderRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/prodOrder/{id}")
	public ResponseEntity<?> deleteProdOrder(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		prodOrderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
		prodOrderRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
