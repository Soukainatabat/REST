package com.example.tp2.Repositories;

import com.example.tp2.Entities.Bankccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountBankRepository extends JpaRepository<Bankccount,String> {


}
