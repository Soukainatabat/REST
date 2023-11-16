package com.example.tp2.Web;

import com.example.tp2.Entities.Bankccount;
import com.example.tp2.Repositories.AccountBankRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private AccountBankRepository accountBankRepository;

    public AccountRestController(AccountBankRepository accountBankRepository) {
        this.accountBankRepository = accountBankRepository;
    }
    @GetMapping("/bankAccounts")
    public List<Bankccount> bankAccounts(){
        return accountBankRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public Bankccount bankAccounts( @PathVariable String id ){
        return accountBankRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public Bankccount save(Bankccount bankccount){
        bankccount.setId(UUID.randomUUID().toString());
         return accountBankRepository.save(bankccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public Bankccount update(@PathVariable String id, @RequestBody Bankccount bankccount){
        Bankccount account=accountBankRepository.findById(id).orElseThrow();
        if(bankccount.getBalance()!=null)
         account.setBalance(bankccount.getBalance());
         account.setCreatedAt(new Date());
        if(bankccount.getType()!=null)
         account.setType(bankccount.getType());
        if(bankccount.getCurrency()!=null)
         account.setCurrency(bankccount.getCurrency());
        return accountBankRepository.save(account);

    }
    @DeleteMapping("/bankAccounts/{id}")
     public void delete(@PathVariable String id){
        accountBankRepository.deleteById(id);
    }

}
