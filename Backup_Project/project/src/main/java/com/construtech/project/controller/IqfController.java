package com.construtech.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.construtech.project.repositories.Iqf;
import com.construtech.project.services.IqfService;

import java.net.URI;

@RestController
@CrossOrigin("*")
@RequestMapping("/iqf")
@Validated
public class IqfController {

    @Autowired
    private IqfService iqfService;

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Iqf> getIqfByCnpj(@PathVariable String cnpj) {
        return iqfService.findByCnpj(cnpj)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iqf> getIqfById(@PathVariable Long id) {
        return iqfService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<Iqf> getAllIqfs() {
        return iqfService.findAll();
    }

    @PostMapping
    public ResponseEntity<Iqf> createIqf(@RequestBody @Validated Iqf iqf) {
        iqfService.saveIqf(iqf);
        return ResponseEntity.created(URI.create("/iqf/" + iqf.getId())).body(iqf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Iqf> updateIqf(@PathVariable Long id, @RequestBody @Validated Iqf updatedIqf) {
        return iqfService.findById(id)
                .map(existingIqf -> {
                    BeanUtils.copyProperties(updatedIqf, existingIqf, "id", "result");

                    iqfService.saveIqf(existingIqf);
                    return ResponseEntity.ok(existingIqf);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIqf(@PathVariable Long id) {
        iqfService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
