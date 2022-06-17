package com.jbfg.memberjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbfg.memberjpa.entity.MemberVO;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long>{

}
