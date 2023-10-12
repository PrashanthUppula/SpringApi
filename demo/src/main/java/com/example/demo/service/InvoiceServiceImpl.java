package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repo.InvoiceRepo;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepo invoiceRepo;

	@Override
	public Optional<Invoice> getInvoice(Long Id) {
		Optional<Invoice> invoiceById = invoiceRepo.findById(Id);
		return invoiceById;
	}

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		Invoice invoiceSave = invoiceRepo.save(invoice);
		return invoiceSave;
	}

	@Override
	public List<Invoice> findAll() {
		List<Invoice> invoiceList = invoiceRepo.findAll();
		return invoiceList;
	}

	@Override
	public void deleteInvoice(Long Id) {
		invoiceRepo.deleteById(Id);

	}

	@Override
	public Invoice updateInvoice(Invoice invoice) throws Exception {
		Optional<Invoice> productDb = this.invoiceRepo.findById(invoice.getOrderId());
		if (productDb.isPresent()) {
			Invoice productUpdate = productDb.get();
			 productUpdate.setOrderName("Adidas");
			 invoiceRepo.save(productUpdate);
			 return productUpdate;
			
		}else {
            throw new Exception("Order name details not found");
	 }
	}

}
