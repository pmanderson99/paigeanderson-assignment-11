package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
	
	public Transaction findById(Long transactionId) {
		Optional<Transaction> transactionOptnl = transactionRepo.findAll()
                .stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findAny();
        System.out.println(transactionOptnl.toString());
        return transactionOptnl.orElse(new Transaction());
    }
}
