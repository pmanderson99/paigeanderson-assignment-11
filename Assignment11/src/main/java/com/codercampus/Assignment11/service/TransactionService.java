package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	
	public List<Transaction> findAll(){
		List<Transaction> transaction = transactionRepo.findAll();
		Collections.sort(transaction,(transaction1, transaction2)
				-> transaction1.getDate().compareTo(transaction2.getDate()));
		return transaction;
	}
	
	public Transaction findById(Long id) {
        return transactionRepo.findById(id);
    }
}
