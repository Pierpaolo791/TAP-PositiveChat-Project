package com.tap.positiveingestor.config;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;

@Configuration
public class LangDetectorConfig {
	
	@Bean
	public LanguageDetector languageDetectorBeand() {
		List<LanguageProfile> languageProfiles = null;
		try {
			languageProfiles = new LanguageProfileReader().read(List.of("en","it","es","fr","de"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
		        .withProfiles(languageProfiles)
		        .build();
		return languageDetector;
	}
	
}
