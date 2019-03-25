package springboot.service;

import springboot.dto.PurchaseDTO;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDTO> findAll();

    PurchaseDTO findById(long id);

    void add(PurchaseDTO purchaseDTO);

    void update(PurchaseDTO purchaseDTO);
}
