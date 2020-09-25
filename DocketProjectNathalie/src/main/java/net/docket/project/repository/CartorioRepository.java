package net.docket.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.docket.project.entity.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

}
