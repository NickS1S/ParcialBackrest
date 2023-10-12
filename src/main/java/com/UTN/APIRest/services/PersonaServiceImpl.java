package com.UTN.APIRest.services;

import com.UTN.APIRest.entities.Persona;
import com.UTN.APIRest.repositories.BaseRepository;
import com.UTN.APIRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{//llamada al metodo con met Query
            //List<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //jpql
            //List<Persona> personas= personaRepository.search(filtro);
            //queryNativo
            List<Persona> personas= personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);

            //Page<Persona> personas= personaRepository.search(filtro, pageable);

            Page<Persona> personas= personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
