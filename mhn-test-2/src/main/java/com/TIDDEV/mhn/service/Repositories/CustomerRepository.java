package com.TIDDEV.mhn.service.Repositories;

import com.TIDDEV.mhn.service.model.Customer;
import com.TIDDEV.mhn.service.modelDto.CustomCustomerList;
import com.TIDDEV.mhn.service.modelDto.CustomersListByCheckListCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
    @Query("select new com.TIDDEV.mhn.service.modelDto.CustomersListByCheckListCount(" +
            "cus.ID , cus.customerName ,count (cusC) , cusC.checkDate)" +
            "from Customer cus join CustomerCheck  cusC on cus.ID = cusC.customer.ID" +
            " where (:sDate IS NULL Or  cusC.checkDate BETWEEN :sDate and :eDate)" +
            " group by cus.ID , cus.customerName , cusC.checkDate" +
            " having count (cusC) = :size")
    List<CustomersListByCheckListCount> findCustomersByCheckListSize(@Param("size")Integer size ,
    @Param("sDate")LocalDate sDate ,@Param("eDate")LocalDate eDate) ;
    @Query("select cus from Customer cus join CustomerCheck cusC on cusC.customer.ID = cus.ID " +
            "where cusC.amount not between :amountA and :amountB")
    List<Customer> havingChecksNotBetweenAmounts(@Param("amountA") Double a , @Param("amountB") Double b) ;
    @Query("select cus from Customer cus join CustomerCheck cusC on cusC.customer.ID = cus.ID " +
            "where cusC.amount between :amountA and :amountB")
    List<Customer> havingChecksBetweenAmounts(@Param("amountA") Double a , @Param("amountB") Double b) ;
    @Query("select cus from Customer cus where cus.accNo like :prefix%")
    List<Customer> customersStartingWith(@Param("prefix") String prefix);
    @Query("select cus from Customer cus where cus.accNo like %:suffix")
    List<Customer> customersEndingWith(@Param("suffix") String prefix);
    @Query("select new com.TIDDEV.mhn.service.modelDto.CustomCustomerList(" +
            "cus.ID , cus.customerName , AVG (cusC.amount) )" +
            "from Customer cus join CustomerCheck  cusC on cus.ID = cusC.customer.ID" +
            " group by cus.ID , cus.customerName "
    )
    List<CustomCustomerList> customCustomerList() ;
}
