package com.service.banking.repository.AccountsRepo;

import com.service.banking.hibernateEntity.BikeSurrenderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BikeSurrenderHistoryRepo extends JpaRepository<BikeSurrenderHistory, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bike_surrender_history \n" +
            "where account_id = ?1",
            nativeQuery = true)
    public void deleteBikeSurrenderHistory(Integer id);
}

