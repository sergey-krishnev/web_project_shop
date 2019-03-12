package springboot.service;

import springboot.model.ProductDescription;
import springboot.model.Request;

import java.util.List;

public interface RequestService {

    List<Request> findAll();

    Request findById(Integer id);
}
