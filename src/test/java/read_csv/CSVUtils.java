package read_csv;

import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvParser;
import pojo.CustomerPolicy;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;


public class CSVUtils {

    public <T> List<T> getListOfPOJOFromCSV(String csvFilePath, Class<T> tClass) throws IOException {
        File csvFile = new File(csvFilePath);

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE);
        CsvSchema csvSchema = csvMapper
                .typedSchemaFor(tClass)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        MappingIterator<T> complexUsersIter = csvMapper
                .readerWithTypedSchemaFor(tClass)
                .with(csvSchema)
                .readValues(csvFile);

       return complexUsersIter.readAll();
    }
    public List<CustomerPolicy> getCustomerDetailsFromCSV() throws IOException {
        return getListOfPOJOFromCSV("src/test/resources/test_data/testdata.csv",CustomerPolicy.class);
    }
}
