package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dao.RequestRepository;
import springboot.model.ProductDescription;
import springboot.model.Request;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Request findById(Integer id) {
        return requestRepository.findById(id).get();
    }
}
