/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apriorialgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Piotrek
 */
public class Rule {
    Set<String> lhs;
    Set<String> rhs;
    int lhsCount;
    int rhsCount;
    double confidence;
    int support;
    List<List<String>> transactionList = new ArrayList<List<String>>();

    Rule(List<List<String>> tl)
    {
        transactionList = tl;
        lhs = new HashSet<String>();
        rhs = new HashSet<String>();
    }

    private int getSupportCount(Set<String> set)
    {
        int count = 0;
        for(int i = 0; i < transactionList.size(); i ++)
        {
            if(transactionList.get(i).containsAll(set))
            {
                count ++;
            }
        }
        return count;
    }

    public void setLhs(Set<String> lhs) {
        this.lhs = lhs;
    }

    public Set<String> getLhs() {
        return lhs;
    }

    @Override
    public String toString() {
        return Arrays.toString(lhs.toArray()) + " ==> " + Arrays.toString(rhs.toArray()) + " (Conf: " + confidence * 100 + "%, Supp: " + (getSupportCount(union(lhs,rhs)) / (double)transactionList.size()) * 100 + "%)";
    }

    public int getLhsCount() {
        return lhsCount;
    }

    public Set<String> getRhs() {
        return rhs;
    }

    public int getRhsCount() {
        return rhsCount;
    }

    public void setLhsCount(int lhsSupport) {
        this.lhsCount = lhsSupport;
    }

    public void setRhs(Set<String> rhs) {
        this.rhs = rhs;
    }

    public void setRhsCount(int rhsSupport) {
        this.rhsCount = rhsSupport;
    }

    public double computeAndGetConfidence()
    {
        confidence = getSupportCount(union(lhs, rhs));
        support = (int)confidence;
        confidence /= getSupportCount(lhs);
        return confidence;
    }

    public <T>Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new HashSet<T>(setA);
        tmp.addAll(setB);
        return tmp;
    }
}
