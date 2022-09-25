package com.bar.bartender.bartender.repository;

import com.bar.bartender.bartender.entity.Cups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BartenderRepository extends JpaRepository<Cups, Integer> {


}
