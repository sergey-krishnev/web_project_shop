package springboot.service;

import springboot.dto.PurchaseDTO;
import springboot.model.Purchase;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDTO> findAll();

    PurchaseDTO findById(long id);

    PurchaseDTO add(PurchaseDTO purchaseDTO);

    PurchaseDTO update(PurchaseDTO purchaseDTO);
}
