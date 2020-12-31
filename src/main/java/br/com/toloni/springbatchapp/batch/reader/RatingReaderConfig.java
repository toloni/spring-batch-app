package br.com.toloni.springbatchapp.batch.reader;

import br.com.toloni.springbatchapp.persistence.entity.Rating;
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
public class RatingReaderConfig {

    @Bean
    @StepScope
    public JdbcPagingItemReader<Rating> ratingJdbcPagingItemReader(
            @Qualifier("appADataSource") DataSource dataSource,
            PagingQueryProvider ratingQueryProvider
    ) {
        return new JdbcPagingItemReaderBuilder<Rating>()
                .name("ratingJdbcPagingItemReader")
                .dataSource(dataSource)
                .queryProvider(ratingQueryProvider)
                .pageSize(1)
                .rowMapper(new BeanPropertyRowMapper<Rating>(Rating.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean ratingQueryProvider(
            @Qualifier("appADataSource") DataSource dataSource
    ) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from Rating");
        queryProvider.setSortKey("id_rating");

        return queryProvider;
    }
}
