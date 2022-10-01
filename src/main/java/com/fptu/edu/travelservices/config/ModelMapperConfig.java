package com.fptu.edu.travelservices.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        // create object ModelMapper config
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

//    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
//        return entityList.stream()
//                .map(entity -> map(entity, outCLass))
//                .collect(Collectors.toList());
//    }
}
