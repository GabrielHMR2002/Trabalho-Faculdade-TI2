package com.construtech.project.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construtech.project.models.Denuncia;
import com.construtech.project.repositories.Denunciarepository;

@Service
public class DenunciaService {

    @Autowired
    private Denunciarepository denunciarepository;

    public Denuncia findById(Long id){
        Optional<Denuncia> denuncia = this.denunciarepository.findById(id);
        return denuncia.orElseThrow(() -> new RuntimeException("Denuncia não encontrada!"));
    }

    @Transactional
    public Denuncia criarDenuncia(Denuncia obj){
        obj.setId(null);
        obj = this.denunciarepository.save(obj);  
        return obj;
    }

    @Transactional
    public Denuncia atualizarDenuncia(Denuncia obj){
        Denuncia newObj = findById(obj.getId());
        newObj.setNomeDenunciante(obj.getNomeDenunciante());
        newObj.setEmail(obj.getEmail());
        newObj.setDescricao(obj.getDescricao());
        newObj.setTipoDenuncia(obj.getTipoDenuncia());
        return this.denunciarepository.save(newObj);
    }

    public void deletarDenuncia(Long id){
        findById(id);
        try {
            this.denunciarepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir");
        }
    }
}
