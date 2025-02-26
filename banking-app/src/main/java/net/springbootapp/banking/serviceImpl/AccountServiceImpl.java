package net.springbootapp.banking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.springbootapp.banking.Entity.Account;
import net.springbootapp.banking.Exception.AccountException;
import net.springbootapp.banking.dto.AccountDto;
import net.springbootapp.banking.mapper.AccountMapper;
import net.springbootapp.banking.repository.BankRepository;
import net.springbootapp.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	
	private BankRepository bankRepository;
	
	
    
	 
	public AccountServiceImpl(BankRepository bankRepository) {
		super();
		this.bankRepository = bankRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = bankRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		Account account = bankRepository
				                         .findById(id)
				                         .orElseThrow(()-> new AccountException("Account doesnot exist"));
		
		 return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = bankRepository.findById(id)
                .orElseThrow(()-> new AccountException("Account doesnot exist"));
           double total = account.getBalance()+amount;
           account.setBalance(total);
           Account saveAccount = bankRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = bankRepository.findById(id)
                .orElseThrow(()-> new AccountException("Account doesnot exist"));
		if(account.getBalance()<amount) {
			throw new AccountException("Insufficient amount");
		}
		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account saveAccount = bankRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account > accounts = bankRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
				          .collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(Long id) {
		
		Account account = bankRepository.findById(id)
                .orElseThrow(()-> new AccountException("Account doesnot exist"));
	 
		bankRepository.deleteById(id);
		
	}
	
	

}
