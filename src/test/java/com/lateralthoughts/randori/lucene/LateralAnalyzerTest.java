package com.lateralthoughts.randori.lucene;

import org.apache.lucene.analysis.BaseTokenStreamTestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Simple test
 */
public class LateralAnalyzerTest extends BaseTokenStreamTestCase {

   @Test
   public void should_put_everything_in_lowercase() throws IOException {
      assertAnalyzesTo(new LateralAnalyzer(),
              "ta mere en SLIPPPP",
              new String[] {"ta", "mere", "en", "slipppp"});
   }

   @Test
   public void should_ignore_stopwords() throws IOException {
      assertAnalyzesTo(new LateralAnalyzer(),
              "ta mere le SLIP",
              new String[] {"ta", "mere", "slipppp"});
   }
}
