package com.multi.pratice.multipratice.jpa.domain.mappedbytest.repository;

import com.multi.pratice.multipratice.jpa.domain.mappedbytest.domain.MapMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapMemberJpaRepository extends JpaRepository<MapMember, Long> {
}
