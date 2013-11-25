package com.lateralthoughts.randori.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Custom analyzer
 */
public class LateralAnalyzer extends Analyzer{
    public static final Version CURRENT_VERSION = Version.LUCENE_45;


    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        Tokenizer source;
        TokenStream result;
        // just lower case everything
        source = new StandardTokenizer(CURRENT_VERSION, reader);
        result = new LowerCaseFilter(CURRENT_VERSION, source);

        return new TokenStreamComponents(source, result);
    }
}
