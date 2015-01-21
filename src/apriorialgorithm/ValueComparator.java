/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apriorialgorithm;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Piotrek
 */
public class ValueComparator implements Comparator<Set<String>> {
    Map<Set<String>, Integer> base;
    public ValueComparator(Map<Set<String>, Integer> base) {
        this.base = base;
    }

    public int compare(Set<String> a, Set<String> b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
