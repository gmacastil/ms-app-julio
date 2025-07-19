package com.lite.factura.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lite.factura.infrastructure.entity.FacturaEntity;

import java.util.List;

@Repository
public interface FacturaJpaRepository extends JpaRepository<FacturaEntity, Long> {
    
    List<FacturaEntity> findByClienteId(Long clienteId);
    
}
