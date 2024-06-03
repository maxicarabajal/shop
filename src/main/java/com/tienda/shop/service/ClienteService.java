package com.tienda.shop.service;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.excepcion.EntityNotFoundException;
import com.tienda.shop.mapper.ClienteMapper;
import com.tienda.shop.mapper.PedidoMapper;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository repoCliente;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PedidoMapper pedidoMapper;


    @Override
    public List<ClienteDTO> getAllCliente() {
        return clienteMapper.entityListToDtoList(repoCliente.findAll()) ;
    }

    @Override
    public ClienteDTO findClienteById(Long id) {
        ClienteDTO clienteDTO = clienteMapper.entityToDto(findClienteByIdEntity(id));
        return clienteDTO;
    }

    @Override
    public Cliente findClienteByIdEntity(Long id) {
        Optional<Cliente> cliente = repoCliente.findById(id);
        if(!cliente.isPresent()){
            throw new EntityNotFoundException("No se encontro un cliente con id: "+id);
        }
        return cliente.get();
    }

    @Override
    public void createCliente(ClienteDTO clienteDTO) {
        repoCliente.save(clienteMapper.dtoToEntity(clienteDTO));
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente cliente = findClienteByIdEntity(id);
        repoCliente.delete(cliente);
    }

    @Override
    public void editCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = findClienteByIdEntity(id);
        cliente.setIdCliente(id);
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());
        cliente.setPedidoList(pedidoMapper.dtoListToEntityList(clienteDTO.getPedidoList()));
        repoCliente.save(cliente);
    }

    @Override
    public ClienteDTO findClienteByDni(String dni) {
        Optional<Cliente> cliente = repoCliente.findClienteByDni(dni);
        if(!cliente.isPresent()){
            throw new EntityNotFoundException("No se encontro el cliente con dni: "+dni);
        }
        return clienteMapper.entityToDto(cliente.get());
    }


}
