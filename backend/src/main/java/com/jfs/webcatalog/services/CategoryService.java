package com.jfs.webcatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfs.webcatalog.dto.CategoryDTO;
import com.jfs.webcatalog.entities.Category;
import com.jfs.webcatalog.repositories.CategoryRepository;

/*Anotação @Service registra a classe como componente que participa 
do controle de injeção de dependências do Spring*/

@Service
public class CategoryService {

	/*
	 * Anotação para injetar dependência válida do Repository
	 */
	@Autowired
	private CategoryRepository repository;

	/*
	 * Transação de apenas leitura, não é necessário locking no banco.
	 */
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		/* Forma alternativa
		List<CategoryDTO> listDto = new ArrayList<>();
		for (Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		return listDto;
		*/
		
		//Recurso Lambda Java:
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
	}
}
