package springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;;
import springboot.converter.DTOHelper;
import springboot.dao.PurchaseRepository;
import springboot.dto.PurchaseDTO;
import springboot.model.Purchase;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @MockBean
    private PurchaseRepository purchaseRepository;

    @Test
    public void findAllTest() {

        List<PurchaseDTO> purchases = new ArrayList<>();
        List<Purchase> purchaseList = new ArrayList<>();
        for (long i=1 ; i < 5 ; i++) {
            Purchase purchase = new Purchase();
            purchase.setId(i);
            purchase.setCustomerName("test");
            purchase.setCustomerAddress("test");
            purchase.setSum(5);
            purchaseList.add(purchase);

        }
        Mockito.when(purchaseRepository.findAll()).thenReturn(purchaseList);
        DTOHelper.requestToRequestDTO(purchaseRepository.findAll(),purchases);
        assertThat(purchaseService.findAll()).isEqualTo(purchases);

    }

    @Test
    public void testAddPurchase() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setCustomerName("test");
        purchase.setCustomerAddress("test");
        purchase.setSum(0);
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setId(purchase.getId());
        purchaseDTO.setCustomerName(purchase.getCustomerName());
        purchaseDTO.setCustomerAddress(purchase.getCustomerAddress());
        purchaseDTO.setSum(purchase.getSum());
        Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
        assertThat(purchaseService.add(purchaseDTO)).isEqualTo(purchaseDTO);
    }

    @Test
    public void getByIdTest() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setCustomerName("test");
        purchase.setCustomerAddress("test");
        purchase.setSum(0);
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setId(purchase.getId());
        purchaseDTO.setCustomerName(purchase.getCustomerName());
        purchaseDTO.setCustomerAddress(purchase.getCustomerAddress());
        purchaseDTO.setSum(purchase.getSum());
        Mockito.when(purchaseRepository.getOne(1L)).thenReturn(purchase);
        assertThat(purchaseService.findById(1L)).isEqualTo(purchaseDTO);
    }

    @Test
    public void updateTest() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setCustomerName("test");
        purchase.setCustomerAddress("test");
        purchase.setSum(0);
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setId(purchase.getId());
        purchaseDTO.setCustomerName(purchase.getCustomerName());
        purchaseDTO.setCustomerAddress(purchase.getCustomerAddress());
        purchaseDTO.setSum(purchase.getSum());
        Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
        assertThat(purchaseService.update(purchaseDTO)).isEqualTo(purchaseDTO);
    }


}