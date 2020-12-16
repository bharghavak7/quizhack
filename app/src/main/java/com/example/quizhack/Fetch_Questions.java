package com.example.quizhack;

public class Fetch_Questions {
    String questions;String options1;String options2;String options3;String options4;String ans;

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptions1() {
        return options1;
    }

    public void setOptions1(String options1) {
        this.options1 = options1;
    }

    public String getOptions2() {
        return options2;
    }

    public void setOptions2(String options2) {
        this.options2 = options2;
    }

    public String getOptions3() {
        return options3;
    }

    public void setOptions3(String options3) {
        this.options3 = options3;
    }

    public String getOptions4() {
        return options4;
    }

    public void setOptions4(String options4) {
        this.options4 = options4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Fetch_Questions(String questions, String options1, String options2, String options3, String options4, String ans ){
        this.options1=options1;
        this.questions=questions;
        this.ans=ans;
        this.options2=options2;
        this.options3=options3;
        this.options4=options4;
    }

}
