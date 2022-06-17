package com.jbfg.springguestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbfg.springguestbook.dto.Guestbook;

@Repository
public interface GuestbookRepository extends JpaRepository<Guestbook, Integer>{ //인터페이스를 인터페이스가 상속



}
