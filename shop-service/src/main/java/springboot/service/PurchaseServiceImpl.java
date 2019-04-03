package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.converter.DTOHelper;
import springboot.dao.PurchaseRepository;
import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
import springboot.model.Product;
import springboot.model.Purchase;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PurchaseDTO> findAll() {

        List<Purchase> purchaseList = purchaseRepository.findAll();
        List<PurchaseDTO> requests = new ArrayList<>();
        DTOHelper.requestToRequestDTO(purchaseList,requests);
        return requests;
    }

    @Transactional(readOnly = true)
    @Override
    public PurchaseDTO findById(long id) {

        Purchase purchase = purchaseRepository.getOne(id);
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setId(purchase.getId());
        purchaseDTO.setCustomerName(purchase.getCustomerName());
        purchaseDTO.setCustomerAddress(purchase.getCustomerAddress());
        purchaseDTO.setSum(purchase.getSum());
        List<Product> productList = purchase.getProduct();
        List<ProductDTO> productDescriptions = new ArrayList<>();
        DTOHelper.productDescriptionToProductDescriptionDTO(productList,productDescriptions);
        purchaseDTO.setProduct(productDescriptions);
        return purchaseDTO;
    }

    @Transactional
    @Override
    public PurchaseDTO add(PurchaseDTO purchaseDTO) {
        Purchase purchase = new Purchase();
        purchase.setCustomerName(purchaseDTO.getCustomerName());
        purchase.setCustomerAddress(purchaseDTO.getCustomerAddress());
        purchase.setSum(purchaseDTO.getSum());
        List<ProductDTO> productDescriptions = purchaseDTO.getProduct();
        List<Product> productList = new ArrayList<>();
        DTOHelper.productDescriptionDTOToProductDescription(productDescriptions, productList);
        purchase.setProduct(productList);
        purchaseRepository.save(purchase);
        return purchaseDTO;
    }

    @Override
    public PurchaseDTO update(PurchaseDTO purchaseDTO) {
        Purchase purchase = new Purchase();
        purchase.setId(purchaseDTO.getId());
        purchase.setCustomerName(purchaseDTO.getCustomerName());
        purchase.setCustomerAddress(purchaseDTO.getCustomerAddress());
        purchase.setSum(purchaseDTO.getSum());
        List<ProductDTO> productDescriptions = purchaseDTO.getProduct();
        List<Product> productList = new ArrayList<>();
        DTOHelper.productDescriptionDTOToProductDescription(productDescriptions, productList);
        purchase.setProduct(productList);
        purchaseRepository.save(purchase);
        return purchaseDTO;
    }
}
