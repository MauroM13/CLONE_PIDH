package br.com.digital_hoteis.model.repository;

import br.com.digital_hoteis.model.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, UUID> {
    Optional<UserDetail> findByEmail(String name);
}
