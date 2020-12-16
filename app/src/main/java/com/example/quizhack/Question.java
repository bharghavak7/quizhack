package com.example.quizhack;

public class Question {
    String spin;
    String ques;
    String opti1;
    String opti2;
    String opti3;
    String opti4;
    String an;
    public Question(String ques, String opti1, String opti2, String opti3, String opti4, String an, String spin){
        this.ques=ques;
        this.opti1=opti1;
        this.opti2=opti2;
        this.opti3=opti3;
        this.opti4=opti4;
        this.an=an;
        this.spin=spin;


    }
}
