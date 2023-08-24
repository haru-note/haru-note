package net.harunote.data.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CodeVillains
 */
@Component
public class ModelMapConverter {
    private final ModelMapper modelMapper;
    public ModelMapConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S, D> D toDto(S entity, Class<D> dto) {
        return modelMapper.map(entity, dto);
    }

    public <S, D> D toEntity(S dto, Class<D> entity) {
        return modelMapper.map(dto, entity);
    }

    public <S, D> List<D> listToDto(List<S> sourceList, Class<D> destinationType) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }

    public <S, D> List<D> listToEntity(List<S> sourceList, Class<D> destinationType) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }

}
