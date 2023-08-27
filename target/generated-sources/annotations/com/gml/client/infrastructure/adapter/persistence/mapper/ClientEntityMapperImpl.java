package com.gml.client.infrastructure.adapter.persistence.mapper;

import com.gml.client.domain.model.Client;
import com.gml.client.infrastructure.adapter.persistence.entity.ClientEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-26T16:32:47-0500",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ClientEntityMapperImpl implements ClientEntityMapper {

    @Override
    public ClientEntity toEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setBindingDate( client.getBindingDate() );
        clientEntity.setEndDate( client.getEndDate() );
        clientEntity.setMail( client.getMail() );
        clientEntity.setName( client.getName() );
        clientEntity.setPhone( client.getPhone() );
        clientEntity.setSharedKey( client.getSharedKey() );
        clientEntity.setStartDate( client.getStartDate() );

        return clientEntity;
    }

    @Override
    public Client toModel(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.bindingDate( clientEntity.getBindingDate() );
        client.endDate( clientEntity.getEndDate() );
        client.mail( clientEntity.getMail() );
        client.name( clientEntity.getName() );
        client.phone( clientEntity.getPhone() );
        client.sharedKey( clientEntity.getSharedKey() );
        client.startDate( clientEntity.getStartDate() );

        return client.build();
    }
}
