package com.epam.test.skos;

import java.util.Map;
import org.apache.jena.rdf.model.Model;

/**
 * Do not modify!
 */
public interface Extractor {
    Map<String, Map<String, String>> concepts(Model model);
}