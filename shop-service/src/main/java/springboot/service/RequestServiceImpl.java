package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.converter.DTOHelper;
import springboot.dao.RequestRepository;
import springboot.dto.ProductDescriptionDTO;
import springboot.dto.RequestDTO;
import springboot.model.ProductDescription;
import springboot.model.Request;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional(readOnly = true)
    @Override
    public List<RequestDTO> findAll() {

        List<Request> requestList = requestRepository.findAll();
        List<RequestDTO> requests = new ArrayList<>();
        DTOHelper.requestToRequestDTO(requestList,requests);
        return requests;
    }

    @Transactional(readOnly = true)
    @Override
    public RequestDTO findById(long id) {

        Request request = requestRepository.findById(id).get();
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setCustomerName(request.getCustomerName());
        requestDTO.setCustomerAddress(request.getCustomerAddress());
        requestDTO.setSum(request.getSum());
        List<ProductDescription> productDescriptionList = request.getProductDescriptions();
        List<ProductDescriptionDTO> productDescriptions = new ArrayList<>();
        DTOHelper.productDescriptionToProductDescriptionDTO(productDescriptionList,productDescriptions);
        requestDTO.setProductDescriptions(productDescriptions);
        return requestDTO;
    }

    @Transactional
    @Override
    public void addRequest(RequestDTO requestDTO) {
        Request request = new Request();
        request.setCustomerName(requestDTO.getCustomerName());
        request.setCustomerAddress(requestDTO.getCustomerAddress());
        request.setSum(requestDTO.getSum());
        List<ProductDescriptionDTO> productDescriptions = requestDTO.getProductDescriptions();
        List<ProductDescription> productDescriptionList = new ArrayList<>();
        DTOHelper.productDescriptionDTOToProductDescription(productDescriptions,productDescriptionList);
        request.setProductDescriptions(productDescriptionList);
        requestRepository.save(request);
    }

    @Override
    public void updateRequest(RequestDTO requestDTO) {
        Request request = new Request();
        request.setId(requestDTO.getId());
        request.setCustomerName(requestDTO.getCustomerName());
        request.setCustomerAddress(requestDTO.getCustomerAddress());
        request.setSum(requestDTO.getSum());
        List<ProductDescriptionDTO> productDescriptions = requestDTO.getProductDescriptions();
        List<ProductDescription> productDescriptionList = new ArrayList<>();
        DTOHelper.productDescriptionDTOToProductDescription(productDescriptions,productDescriptionList);
        request.setProductDescriptions(productDescriptionList);
        requestRepository.save(request);
    }
}
