package org.iesfm.newspaper.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.iesfm.newspaper.entity.Section;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    
    
    
    
    
    public static Section toEntity(SectionDto dto){
        return new Section(
                dto.getId(),
                dto.getName()

        );
    }
    public static SectionDto toDto(Section entity){
        return new SectionDto(
                entity.getId(),
                entity.getName()
        );
    }
}
