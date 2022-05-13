package com.thgroup.fms.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.ProductPhotos;

public interface ProductPhotosService {
	List<ProductPhotos> getAllFiles();
    void saveAllFilesList(List<ProductPhotos> fileList);
	void deleteByid(@Param("id") int id);

}
