package springboot.service;

import springboot.dto.RequestDTO;
import springboot.model.ProductDescription;
import springboot.model.Request;

import java.util.List;

public interface RequestService {

    List<RequestDTO> findAll();

    RequestDTO findById(int id);

    void addRequest(RequestDTO requestDTO);
}
