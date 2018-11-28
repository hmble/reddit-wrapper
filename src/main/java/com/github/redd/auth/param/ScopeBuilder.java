package com.github.redd.auth.param;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ScopeBuilder {
    private Set<Scope> scopeSet;

    public ScopeBuilder() {
        this.scopeSet = new HashSet<>();
    }

    public ScopeBuilder addScope(Scope scope) {
        scopeSet.add(scope);
        return this;
    }

    public ScopeBuilder addScope(Scope... scopes) {

        for(Scope s: scopes){
            addScope(s);
        }
        //For shorter classes using for loop will be more
        //useful than stream

        return this;
    }

    public ScopeBuilder removeScope(Scope scope) {
        scopeSet.remove(scope);
        return this;
    }

    public ScopeBuilder removeScope(Scope... scopes) {
        for(Scope s: scopes){
            addScope(s);
        }
        return this;
    }

    public ScopeBuilder completeScope(){

        EnumSet.allOf(Scope.class)
                .forEach(e -> addScope(e));
        return this;
    }

    public boolean has(Scope scope){
        return scopeSet.contains(scope.getValue());
    }

    public String buildString(){
        String r = scopeSet.stream()
                .map(i->i.getValue())
                .collect(Collectors.joining(","));
        return r;
    }
}
