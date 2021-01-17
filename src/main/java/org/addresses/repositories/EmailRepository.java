package org.addresses.repositories;

import org.addresses.models.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Integer> {
}
