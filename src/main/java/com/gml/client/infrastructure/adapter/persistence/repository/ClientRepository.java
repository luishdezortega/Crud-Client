package com.gml.client.infrastructure.adapter.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gml.client.infrastructure.adapter.persistence.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	Optional<ClientEntity> findBySharedKeyIs(String sharedKey);

}
