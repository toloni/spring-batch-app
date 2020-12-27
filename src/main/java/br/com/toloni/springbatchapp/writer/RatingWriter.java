package br.com.toloni.springbatchapp.writer;

import br.com.toloni.springbatchapp.domain.Rating;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class RatingWriter {

    @Bean
    public JdbcBatchItemWriter<Rating> ratingItemWriter(
            @Qualifier("appADataSource") DataSource dataSource
    ) {
        return new JdbcBatchItemWriterBuilder<Rating>()
                .dataSource(dataSource)
                .sql("INSERT INTO RATING(ID_RATING, DATE_RATING, ID_CLIENT, NUMBER_STARS_RATING) VALUES (?, ?, ?, ?)")
                .itemPreparedStatementSetter(this::itemPreparedStatementSetter)
                .build();
    }

    private void itemPreparedStatementSetter(
            Rating rating,
            PreparedStatement ps
    ) throws SQLException {

        ps.setString(1, rating.getIdRating().toString());
        ps.setTimestamp(2, Timestamp.valueOf(rating.getDateRating()));
        ps.setLong(3, rating.getIdClient());
        ps.setInt(4, rating.getNumberStarsRating());
    }

}
