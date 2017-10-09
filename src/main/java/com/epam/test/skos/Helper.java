package com.epam.test.skos;

import static java.nio.file.Paths.get;
import java.io.FileInputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * Do not modify!
 */
public class Helper {
    public static Model parseRdf(String path) {
        try {
            final Model model = ModelFactory.createDefaultModel();
            model.read(new FileInputStream(get(path).toFile()), null);
            return model;
        } catch (Exception e) {
            throw new RuntimeException("parse error of file='" + path + "'", e);
        }
    }
}
