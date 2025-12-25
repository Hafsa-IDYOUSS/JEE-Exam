package org.xproce.exam_1.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.exam_1.dao.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
