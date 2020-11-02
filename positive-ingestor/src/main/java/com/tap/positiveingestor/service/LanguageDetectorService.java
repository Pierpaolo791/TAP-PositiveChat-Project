package com.tap.positiveingestor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

@Service
public class LanguageDetectorService {
	
	@Autowired
	private LanguageDetector detector; 
	
	public String getLanguage(String text) {
		TextObjectFactory textObjectFactory = getTextObjectFactory(text);
		TextObject textObject = textObjectFactory.forText(text);
		Optional<LdLocale> lang = detector.detect(textObject);
		if(lang.isPresent())
			return lang.get().getLanguage();
		return "nd";
	}

	private TextObjectFactory getTextObjectFactory(String text) {
		TextObjectFactory textObjectFactory; 
		if (text.length()>50)
			textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();
		else textObjectFactory = CommonTextObjectFactories.forDetectingShortCleanText();
		return textObjectFactory;
	}
	
}
