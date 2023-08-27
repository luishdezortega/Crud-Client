package com.gml.client.application.mapper;

import com.gml.client.application.dto.ClientResponseDto;
import com.gml.client.application.dto.PaginationResponseDto;
import com.gml.client.domain.model.Client;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-27T10:14:40-0500",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientResponseDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        LocalDate bindingDate = null;
        String mail = null;
        String name = null;
        String phone = null;
        String sharedKey = null;

        bindingDate = client.getBindingDate();
        mail = client.getMail();
        name = client.getName();
        phone = client.getPhone();
        sharedKey = client.getSharedKey();

        ClientResponseDto clientResponseDto = new ClientResponseDto( sharedKey, name, bindingDate, mail, phone );

        return clientResponseDto;
    }

    @Override
    public PaginationResponseDto<Client> toPageableDto(List<Client> responseDto, Long numberOfElements, Integer numberOfPages) {
        if ( responseDto == null && numberOfElements == null && numberOfPages == null ) {
            return null;
        }

        List<Client> responseDto1 = null;
        List<Client> list = responseDto;
        if ( list != null ) {
            responseDto1 = new ArrayList<Client>( list );
        }
        Long numberOfElements1 = null;
        numberOfElements1 = numberOfElements;
        Integer numberOfPages1 = null;
        numberOfPages1 = numberOfPages;

        PaginationResponseDto<Client> paginationResponseDto = new PaginationResponseDto<Client>( numberOfElements1, numberOfPages1, responseDto1 );

        return paginationResponseDto;
    }
}
