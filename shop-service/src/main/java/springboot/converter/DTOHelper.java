package springboot.converter;

import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
import springboot.model.Product;
import springboot.model.Purchase;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DTOHelper {



    public static void requestToRequestDTO(List<Purchase> purchaseList, List<PurchaseDTO> requests) {
        for (Purchase purchase : purchaseList) {
            PurchaseDTO purchaseDTO = new PurchaseDTO();
            List<Product> productList = purchase.getProduct();
            List<ProductDTO> productDescriptions = new ArrayList<>();
            productDescriptionToProductDescriptionDTO(productList, productDescriptions);
            purchaseDTO.setId(purchase.getId());
            purchaseDTO.setCustomerName(purchase.getCustomerName());
            purchaseDTO.setCustomerAddress(purchase.getCustomerAddress());
            purchaseDTO.setSum(purchase.getSum());
            purchaseDTO.setProduct(productDescriptions);
            requests.add(purchaseDTO);
        }
    }

    public static void productDescriptionToProductDescriptionDTO(List<Product> productList, List<ProductDTO> productDescriptions) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setDate(df.format(product.getDate()));
            productDescriptions.add(productDTO);
        }
    }

    public static void productDescriptionDTOToProductDescription(List<ProductDTO> productDescriptions, List<Product> productList) {
        for(ProductDTO productDTO :productDescriptions) {
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setDate(Date.valueOf(productDTO.getDate()));
            productList.add(product);
        }
    }

}
