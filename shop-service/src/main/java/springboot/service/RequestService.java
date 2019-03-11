package springboot.service;

import springboot.model.RequestDetails;

import java.util.List;

public interface RequestService {

    List<RequestDetails> findAll();

    RequestDetails getOne(Integer id);
}
