package com.sowamaciej.BackendApplication.Configuration;

import com.sowamaciej.BackendApplication.Repository.ClientRepository;
import com.sowamaciej.BackendApplication.Services.ClientService;
import com.sowamaciej.BackendApplication.Services.H2CarService;
import com.sowamaciej.BackendApplication.Services.H2ClientService;
import com.sowamaciej.BackendApplication.Services.ListClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ClientServiceConfig {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceConfig (ClientRepository clientRepository)
    {
        this.clientRepository=clientRepository;
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name="H2_STORAGE_ENABLED",havingValue = "TRUE")
    public H2ClientService h2ClientService()
    {
        return new H2ClientService(clientRepository);
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name="H2_STORAGE_ENABLED",havingValue = "FALSE", matchIfMissing = true)
    public ListClientService ListClientService()
    {
        return new ListClientService();
    }
}
