package com.jfs.webcatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfs.webcatalog.entities.Category;
import com.jfs.webcatalog.repositories.CategoryRepository;

/*Anotação @Service registra a classe como componente que participa 
do controle de injeção de dependências do Spring*/

@Service
public class CategoryService {
	
	/*Anotação para injetar dependência válida 
	 * do Repository*/
	@Autowired
	private CategoryRepository repository;
	
	/*Transação de apenas leitura, 
	 * não é necessário locking no banco.*/
	@Transactional(readOnly = true)
	public List<Category> findAll(){
		return repository.findAll();
	}
}
