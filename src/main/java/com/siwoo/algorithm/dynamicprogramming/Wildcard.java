package com.siwoo.algorithm.dynamicprogramming;

/**
 * 특정 문자열과 와일드카드 패턴이 매칭되는지 확인하라.
 * 와일드 카드에는
 *  ?: 어떤 글자와도 대응.
 *  *: 0 글자 이상의 어떤 문자열에도 대응.
 */
public class Wildcard {
    
    public static void main(String[] args) {
        Wildcard wildcard = new Wildcard();
        System.out.println( wildcard.match("he?p", "*p*") );
    }

    private boolean match(String s, String p) {
        int pos = 0;
        while (pos < s.length() && pos < p.length() &&
                (p.charAt(pos) == '?' || p.charAt(pos) == s.charAt(pos)))
            pos++;
        if (p.length() == pos)
            return s.length() == pos;
        if (p.charAt(pos) == '*')
            for (int skip=0; skip+pos<=s.length(); skip++)
                if (match(s.substring(pos+skip), p.substring(pos+1)))
                    return true;
        return false;
    }


}
