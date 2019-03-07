package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.RequestDetailsRepository;
import springboot.model.RequestDetails;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDetailsRepository requestDetailsRepository;


    @Override
    public List<RequestDetails> findAll() {
        return requestDetailsRepository.findAll();
    }
}
