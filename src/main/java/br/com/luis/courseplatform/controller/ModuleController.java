package br.com.luis.courseplatform.controller;


import br.com.luis.courseplatform.dtos.module.ModuleRequestDto;
import br.com.luis.courseplatform.dtos.module.ModuleResponseDto;
import br.com.luis.courseplatform.services.ModuleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService service;

    @GetMapping
    public ResponseEntity<List<ModuleResponseDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleResponseDto> findModuleById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModuleResponseDto> createModule(@RequestBody ModuleRequestDto moduleRequestDto) {
        return new ResponseEntity<>(service.create(moduleRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ModuleResponseDto> updateModule(@PathVariable("id") UUID id,
                                                          @RequestBody ModuleRequestDto moduleRequestDto) {
        return new ResponseEntity<>(service.update(id, moduleRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModuleById(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
