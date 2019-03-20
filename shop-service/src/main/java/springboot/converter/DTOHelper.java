package springboot.converter;

import springboot.dto.ProductDescriptionDTO;
import springboot.dto.RequestDTO;
import springboot.model.ProductDescription;
import springboot.model.Request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DTOHelper {



    public static void requestToRequestDTO(List<Request> requestList, List<RequestDTO> requests) {
        for (Request request : requestList) {
            RequestDTO requestDTO = new RequestDTO();
            List<ProductDescription> productDescriptionList = request.getProductDescriptions();
            List<ProductDescriptionDTO> productDescriptions = new ArrayList<>();
            productDescriptionToProductDescriptionDTO(productDescriptionList, productDescriptions);
            requestDTO.setId(request.getId());
            requestDTO.setCustomerName(request.getCustomerName());
            requestDTO.setCustomerAddress(request.getCustomerAddress());
            requestDTO.setSum(request.getSum());
            requestDTO.setProductDescriptions(productDescriptions);
            requests.add(requestDTO);
        }
    }

    public static void productDescriptionToProductDescriptionDTO(List<ProductDescription> productDescriptionList, List<ProductDescriptionDTO> productDescriptions) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (ProductDescription productDescription : productDescriptionList) {
            ProductDescriptionDTO productDescriptionDTO = new ProductDescriptionDTO();
            productDescriptionDTO.setSerial(productDescription.getSerial());
            productDescriptionDTO.setName(productDescription.getName());
            productDescriptionDTO.setDescription(productDescription.getDescription());
            productDescriptionDTO.setDate(df.format(productDescription.getDate()));
            productDescriptions.add(productDescriptionDTO);
        }
    }

}
