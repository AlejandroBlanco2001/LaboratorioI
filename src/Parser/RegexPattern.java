/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

/**
 *
 * @author alexz
 */
public enum RegexPattern {
    OBJECT("\\{|}","OBJECT"),
    INSIDE_DATA("(?<=\")[^:,]*(?=\")|\\d+","INSIDE_DATA"),
    FIRST_PARAMETER("\"","FIRST_PARAMTER"),
    MULTI_OBJECTS("[^:]\\s\\{|\\}","MULTI_OBJECTS");
    

    private String pattern;
    private String patternName;

    private RegexPattern(String pattern, String patternName) {
        this.pattern = pattern;
        this.patternName = patternName;
    }

    public static RegexPattern getOBJECT() {
        return OBJECT;
    }

    public static RegexPattern getINSIDE_DATA() {
        return INSIDE_DATA;
    }

    public String getPattern() {
        return pattern;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }
    
    
}
