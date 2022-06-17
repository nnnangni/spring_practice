package com.jbfg.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbfg.news.dto.News;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

}
