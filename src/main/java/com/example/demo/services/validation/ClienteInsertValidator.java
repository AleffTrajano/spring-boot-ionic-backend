
package com.example.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.dto.ClienteNewDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.resources.exception.FieldMessage;
import com.example.demo.services.validation.utils.BR;
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
 
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}
 	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("cpfouCnpj","CPF inválido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("cpfouCnpj","CNPJ inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux !=null){
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