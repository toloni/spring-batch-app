package br.com.toloni.springbatchapp.batch.writer;

import br.com.toloni.springbatchapp.persistence.entity.Rating;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingWriter implements ItemWriter<Rating> {

    private JdbcTemplate jdbcTemplate;

    public RatingWriter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void write(List<? extends Rating> list) {

        list.forEach(rating -> {

            jdbcTemplate.update(
                    "INSERT INTO RATING(ID_RATING, DATE_RATING, ID_CLIENT, NUMBER_STARS_RATING) VALUES (?, ?, ?, ?)",
                    rating.getIdRating().toString(), Timestamp.valueOf(rating.getDateRating()), rating.getIdClient(), rating.getNumberStarsRating());
        });
    }

}
