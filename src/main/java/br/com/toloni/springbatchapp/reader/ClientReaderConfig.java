package br.com.toloni.springbatchapp.reader;

import br.com.toloni.springbatchapp.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ClientReaderConfig {

    @Bean
    @StepScope
    public JdbcPagingItemReader<Client> clientJdbcPagingItemReader(
            @Qualifier("appADataSource") DataSource dataSource,
            PagingQueryProvider queryProvider
    ) {
        return new JdbcPagingItemReaderBuilder<Client>()
                .name("clientReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .pageSize(1)
                .rowMapper(new BeanPropertyRowMapper<Client>(Client.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(
            @Qualifier("appADataSource") DataSource dataSource
    ) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from Clients");
        queryProvider.setSortKey("id_client");

        return queryProvider;
    }

}
