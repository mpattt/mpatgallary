package com.mpattt.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mpattt.domain.entity.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
	public Image findByName(String name);

}
