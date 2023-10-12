package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Invoice;

public interface InvoiceService {
	
	Optional<Invoice> getInvoice(Long Id);
	Invoice saveInvoice(Invoice invoice);
	List<Invoice> findAll();
	void deleteInvoice(Long Id);
	Invoice updateInvoice(Invoice invoice)throws Exception;

}
