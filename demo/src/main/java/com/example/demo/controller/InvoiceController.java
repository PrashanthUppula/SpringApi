package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;

@RestController
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/Invoice/{Id}")
	public Optional <Invoice> getInvoice(@PathVariable Long Id){
		Optional<Invoice> invoiceGet = invoiceService.getInvoice(Id);
		return invoiceGet;
	}
	
	@GetMapping("/InvoiceList")
	public List<Invoice> findAllInvoices(){
		List<Invoice> listOfInvoices = invoiceService.findAll();
				return listOfInvoices;
	}
	
	@DeleteMapping("/Invoice/{Id}")
	public void deleteInvoice(@PathVariable long Id) {
		invoiceService.deleteInvoice(Id);
	}
	
	@PutMapping("/updateInvoice")
	public Invoice updateInvoice(@RequestBody Invoice invoice) throws Exception {
		return invoiceService.updateInvoice(invoice);
	}
	
	@PostMapping("/createInvoice")
	public Invoice saveInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}
	
	
	

}
