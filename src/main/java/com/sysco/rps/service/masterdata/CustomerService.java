package com.sysco.rps.service.masterdata;

import com.sysco.rps.dto.pp.ListResponse;
import com.sysco.rps.dto.pp.masterdata.BaseCustomerDTO;
import com.sysco.rps.dto.pp.masterdata.CustomerDTO;
import com.sysco.rps.service.exception.RecordNotFoundException;
import com.sysco.rps.service.exception.ValidationException;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

  /**
   * Create a new customer
   * @param opCoNumber - opCo number
   * @param customer - customer information
   * @return CustomerDTO object
   */
  CustomerDTO createCustomer(String opCoNumber, CustomerDTO customer)
          throws ValidationException;

  /**
   * Update an customer
   * @param opCoNumber - opCo number
   * @param baseCustomerDTO - customer information to update (only the base information locked and stop class)
   */
  void updateCustomer(String opCoNumber, String customerNumber, BaseCustomerDTO baseCustomerDTO)
          throws ValidationException, RecordNotFoundException;

  /**
   * find customer by opCo and customer number
   * @param opCoNumber - opCo number
   * @param customerNumber - customer number
   * @return CustomerDTO object
   */
  CustomerDTO findCustomer(String opCoNumber, String customerNumber)
          throws RecordNotFoundException;

  /**
   * findCustomers - list of customers belong to an opCo
   * @param opCoNumber - opCo number
   * @return List<CustomerDTO>
   */
  ListResponse<CustomerDTO> findCustomers(String opCoNumber, Pageable pageable) throws RecordNotFoundException;
}
