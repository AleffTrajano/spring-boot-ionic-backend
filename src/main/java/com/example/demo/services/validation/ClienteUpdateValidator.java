
package com.example.demo.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.resources.exception.FieldMessage;
import com.example.demo.services.validation.utils.BR;
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
 
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}
 	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
 		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
 		Integer uriId =Integer.parseInt(map.get("id"));
 		
 		List<FieldMessage> list = new ArrayList<>();
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux !=null && !aux.getId().equals(uriId)){
			list.add(new FieldMessage("email","email já cadastrado"));
		}
		
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage i : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(i.getMessage()).addPropertyNode(i.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
 }