package org.iesfm.newspaper.controllers;

import org.iesfm.newspaper.controllers.dto.SectionDto;
import org.iesfm.newspaper.entity.Section;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SectionService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SectionController {


    private SectionService sectionService;
@GetMapping(path = "/sections")
    public ResponseEntity<List<SectionDto>> list(
    ){
        return ResponseEntity.ok(
                sectionService.listSections()
                        .stream()
                        .map(section -> SectionDto.toDto(section))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping(path = "/sections/{sectionId}")
    public ResponseEntity<SectionDto> getSection(
            @PathVariable(value = "sectionId", required = false) int sectionId
    ) {
        Section section = sectionService.getSection(sectionId);
        if (section != null) {
            return ResponseEntity.ok(SectionDto.toDto(section));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping(path = "/sections")
    public ResponseEntity<Void> add(
            @Valid @RequestBody SectionDto section
    ) {
        if (sectionService.add(SectionDto.toEntity(section))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PutMapping(path = "/sections/{sectionId}")
    public ResponseEntity<Void> update(
            @PathVariable(value = "sectionId", required = false) int sectionId,
            @Valid @RequestBody SectionDto section
    ) {
        if (sectionService.update(sectionId, SectionDto.toEntity(section))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping(path = "/sections/{sectionId}")
    public ResponseEntity<Void> delete(
            @PathVariable(value = "sectionId", required = false) int sectionId
    ) {
        if (sectionService.delete(sectionId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }





}
