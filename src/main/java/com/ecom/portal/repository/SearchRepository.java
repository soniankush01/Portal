package com.ecom.portal.repository;

import com.ecom.portal.repository.model.SKU;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface SearchRepository extends CassandraRepository<SKU, String> {
}
