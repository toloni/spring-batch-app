package br.com.toloni.springbatchapp.batch.writer;

import br.com.toloni.springbatchapp.persistence.entity.Rating;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class RatingFileWriterConfiguration {

    private Resource outputResource = new FileSystemResource("./output/outputData.txt");

    @Bean
    public FlatFileItemWriter<Rating> ratingFlatFileItemWriter() {
        //Create writer instance
        FlatFileItemWriter<Rating> writer = new FlatFileItemWriter<>();

        //Set output file location
        writer.setResource(outputResource);

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(true);

        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<Rating>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Rating>() {
                    {
                        setNames(new String[]{"idRating", "dateRating", "idClient", "numberStarsRating"});
                    }
                });
            }
        });
        return writer;
    }
}
