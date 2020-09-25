package net.docket.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.docket.project.entity.Certidao;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Long> {

}