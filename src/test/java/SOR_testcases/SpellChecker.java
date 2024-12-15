package SOR_testcases;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

public class SpellChecker {
    public static void main(String[] args) throws IOException {
        // Initialize LanguageTool for British English
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

        // Disable all rules except for spell checking
        for (Rule rule : langTool.getAllRules()) {
            if (!rule.isDictionaryBasedSpellingRule()) {
                langTool.disableRule(rule.getId());
            }
        }

        // Example text to check
        String text = "This is a lable with a speling error.";

        // Check the text for spelling errors
        List<RuleMatch> matches = langTool.check(text);

        // Print the results
        for (RuleMatch match : matches) {
            System.out.println("Potential typo at characters " +
                    match.getFromPos() + "-" + match.getToPos() + ": " +
                    match.getMessage());
            System.out.println("Suggested correction(s): " +
                    match.getSuggestedReplacements());
        }
    }
}
