package com.epam.test.skos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.apache.jena.rdf.model.Model;
import org.testng.annotations.Test;

/**
 * Do not modify!
 */
public class ExtractorImplTest {
    private static final String EXPECTED_CONCEPT_URI = "http://data.wolterskluwer.com/wkbe/kos/audienceType/Practical";
    private static final String EXPECTED_CONCEPT_LANGUAGE = "nl";
    private static final String EXPECTED_CONCEPT_LABEL = "Juridisch";

    private final Extractor extractor = new ExtractorImpl();
    private final Model model = Helper.parseRdf("src/test/resources/audiencetype.skos.rdf");

    @Test
    public void conceptsShouldReturnExtractedMap() {
        // Given
        // When
        final Map<String, Map<String, String>> result = extractor.concepts(model);
        // Then
        assertThat(result.keySet(), hasSize(2));
        assertThat(result.keySet(), hasItem(EXPECTED_CONCEPT_URI));
        assertThat(result.get(EXPECTED_CONCEPT_URI).keySet(), hasItem(EXPECTED_CONCEPT_LANGUAGE));
        assertThat(result.get(EXPECTED_CONCEPT_URI).get(EXPECTED_CONCEPT_LANGUAGE), equalTo(EXPECTED_CONCEPT_LABEL));
    }
}