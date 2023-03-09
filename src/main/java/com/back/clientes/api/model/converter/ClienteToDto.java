package com.back.clientes.api.model.converter;

import com.back.clientes.api.model.ClienteDto;
import com.back.clientes.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteToDto {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteDto converter(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public List<ClienteDto> toCollectionDto(List<Cliente> clientes) {
        return  clientes.stream()
                .map(cliente -> converter(cliente))
                .collect(Collectors.toList());

    }
        public Page<ClienteDto> convertToPageDto(Page<Cliente> clientesPage, Pageable pageable) {
            Page<ClienteDto> clienteDtoPage = clientesPage.map(
                    cliente -> modelMapper.map(cliente, ClienteDto.class));
            return clienteDtoPage;
        }

}
